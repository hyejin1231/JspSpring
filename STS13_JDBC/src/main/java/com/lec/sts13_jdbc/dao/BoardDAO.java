package com.lec.sts13_jdbc.dao;

import java.util.List;

import com.lec.sts13_jdbc.vo.BoardVO;

public interface BoardDAO {

	public List<BoardVO> selectAll();
	
	public BoardVO selectOne(String wr_uid);
	
	public void updateViewcnt(String wr_uid);
	
	public void insertOne(BoardVO board);
	
	public void updateOne(BoardVO board);
	
	public void deleteOne(String wr_uid);
}
