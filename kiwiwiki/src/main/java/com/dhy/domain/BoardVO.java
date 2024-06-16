package com.dhy.domain;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;

import lombok.Data;

@Data
public class BoardVO {
	
	@BsonProperty("title")
	private String title;
	
	@BsonProperty("text")
	private String text;
	
	@BsonProperty("contributors")
	private List<String> contributors;
	private int cnt;
	
	
	
	public BoardVO(String title, String text, List<String> contributors) {
		super();
		this.title = title;
		this.text = text;
		this.contributors = contributors;
	}

	public BoardVO() {
		super();
	}
	
}
