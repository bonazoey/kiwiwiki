package com.dhy.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;
import com.dhy.domain.BoardVO;
import com.dhy.util.MongoDB;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

@Repository
public class BoardDAO {

	private MongoDatabase db = MongoDB.getConnection();
	private MongoCollection<BoardVO> moncol = db.getCollection("board", BoardVO.class);

	private final Parser parser = Parser.builder(new MutableDataSet()).build();
	private final HtmlRenderer renderer = HtmlRenderer.builder(new MutableDataSet()).build();
	
	public BoardDAO() {
		moncol.createIndex(new Document("title", 1));
		moncol.createIndex(new Document("cnt", -1));
	}

	public List<BoardVO> getBoardList() {
		return null;
	}

	public List<BoardVO> getSearchList(String keyword) {
		List<BoardVO> result = new ArrayList<BoardVO>();
		Document query = new Document("title", new Document("$regex", keyword));
		FindIterable<BoardVO> cursor = moncol.find(query).limit(10);
		for (BoardVO vo : cursor) {
			result.add(vo);
		}
		return result;
	}

	public List<String> getHotList() {
		List<String> result = new ArrayList<String>();
		FindIterable<BoardVO> cursor = moncol.find().sort(Sorts.descending("cnt")).limit(10);
		for (BoardVO vo : cursor) {
			result.add(vo.getTitle());
		}
		return result;
	};

	public List<String> getRecentList() {
		List<String> result = new ArrayList<String>();
		FindIterable<BoardVO> cursor = moncol.find().limit(10);
		for (BoardVO vo : cursor) {
			result.add(vo.getTitle());
		}
		return result;
	};

	public List<String> getRandomList() {
		List<String> result = new ArrayList<String>();
		AggregateIterable<BoardVO> cursor = moncol.aggregate(Arrays.asList(Aggregates.sample(10)));
		for (BoardVO vo : cursor) {
			result.add(vo.getTitle());
		}
		return result;
	};

	public BoardVO getBoard(String title) {
		Document doc = new Document("title", title);
		BoardVO item = moncol.find(doc).first();
		BoardVO vo = new BoardVO(item.getTitle(), convertToHtml(item.getText()), item.getContributors());
		return vo;
	}

	public String convertToHtml(String markdown) {
		Node node = parser.parse(markdown);
		return renderer.render(node);
	}
	
	public void insertBoard(String title, String text, String id) {
		Document doc = new Document("title", title);
		BoardVO item = moncol.find(doc).first();
		if (item == null) {
			item = new BoardVO(MongoDB.getNextSeq("num"), title, text, Arrays.asList(id));
			moncol.insertOne(item);
		} else {
			if (item.getContributors().contains(id)) {
				moncol.updateOne(doc, new Document("$set", new Document().append("text", text).append("date", new Date())));
			} else {
				moncol.updateOne(doc, new Document("$set", new Document().append("text", text).append("contributors", item.getContributors().add(id)).append("date", new Date())));
			}
		}
	}

}
