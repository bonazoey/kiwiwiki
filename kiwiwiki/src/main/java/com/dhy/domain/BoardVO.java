package com.dhy.domain;

import java.util.Date;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;

import lombok.Data;

@Data
public class BoardVO {
	
	@BsonProperty("num")
	long num;
	
	@BsonProperty("title")
	private String title;
	
	@BsonProperty("text")
	private String text;
	
	@BsonProperty("contributors")
	private List<String> contributors;
	
	@BsonProperty("cnt")
	private int cnt;
	
	@BsonProperty("date")
	private Date date = new Date();
	
	public BoardVO(String title, String text, List<String> contributors) {
		super();
		this.title = title;
		this.text = text;
		this.contributors = contributors;
	}
	
	public BoardVO(long num, String title, String text, List<String> contributors) {
		super();
		this.num = num;
		this.title = title;
		this.text = text;
		this.contributors = contributors;
	}

	public BoardVO() {
		super();
	}
	
}
