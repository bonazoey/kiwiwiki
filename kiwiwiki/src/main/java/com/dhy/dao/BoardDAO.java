package com.dhy.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.dhy.domain.BoardVO;
import com.dhy.util.MongoDB;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class BoardDAO {
	
	private MongoDatabase db = MongoDB.getConnection();
	private MongoCollection<BoardVO> moncol = db.getCollection("board", BoardVO.class);
	
	public List<BoardVO> getBoardList() {
		return null;
	}
	
	public List<BoardVO> getSearchList(String keyword) {
		List<BoardVO> result= new ArrayList<BoardVO>();
		Document query = new Document("title", new Document("$regex", keyword));
		FindIterable<BoardVO> cursor = moncol.find(query).limit(10);
		for (BoardVO vo : cursor) {
			result.add(vo);
		}
		return result;
	}
	
	public BoardVO getBoard(String title) {
		Document doc = new Document("title", title);
		BoardVO vo = new BoardVO(moncol.find(doc).first().getTitle(), moncol.find(doc).first().getText(), moncol.find(doc).first().getContributors());
		return vo;
	}
}
