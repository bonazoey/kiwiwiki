package com.dhy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhy.dao.BoardDAO;
import com.dhy.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public List<BoardVO> getSearchList(String keyword) {
		return dao.getSearchList(keyword);
	}

	@Override
	public BoardVO getBoard(String title) {
		return dao.getBoard(title);
	}

}
