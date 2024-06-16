package com.dhy.service;

import java.util.List;

import com.dhy.domain.BoardVO;

public interface BoardService {
	
	List<BoardVO> getBoardList();
	
	List<BoardVO> getSearchList(String keyword);
	
	BoardVO getBoard(String title);
}
