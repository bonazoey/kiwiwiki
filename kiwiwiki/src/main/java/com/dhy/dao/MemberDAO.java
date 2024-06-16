package com.dhy.dao;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.dhy.domain.MemberVO;
import com.dhy.util.MongoDB;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class MemberDAO {
	
	MongoDatabase con = MongoDB.getConnection(); 
	private MongoCollection<Document> moncol = con.getCollection("member");
	MemberVO vo;
	
	public MemberVO getMember(String id, String pw) {
		Document doc = new Document("id", id).append("pw", pw);
		if (moncol.find(doc).first() == null) {
			return null;
		}
		vo = new MemberVO(moncol.find(doc).first().getString("id"), moncol.find(doc).first().getString("pw"));
		return vo;
	}
}
