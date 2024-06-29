package com.dhy.service;

import java.util.List;

import com.dhy.domain.BoardVO;

public interface BoardService {
	
	List<BoardVO> getBoardList();
	
	List<BoardVO> getSearchList(String keyword);
	
	List<String> getHotList();
	
	List<String> getRecentList();
	
	List<String> getRandomList();
	
	BoardVO getBoard(String title);
	
	void insertBoard(String title, String text, String id);

}
