package com.lec.sts13_jdbc.service;

import java.util.List;

import com.lec.sts13_jdbc.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> list();
	
	public BoardVO view(String wr_uid);
	
	public void updateViewcnt(String wr_uid);
	
	public void insertOne(BoardVO board);
	
	public void updateOne(BoardVO board);
	
	public void deleteOne(String wr_uid);
	
}
