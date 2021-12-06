package com.lec.sts19_rest.dao;

import java.util.List;

import com.lec.sts19_rest.vo.BoardVO;

public interface BoardDAO {

	public List<BoardVO> selectAll();
	
	public BoardVO selectOne(String wr_uid);
	
	public void updateViewcnt(String wr_uid);
	
	public void insertOne(BoardVO board);
	
	public void updateOne(BoardVO board);
	
	public void deleteOne(String wr_uid);
	
	public List<BoardVO> selectByRow(int fromRow, int writePages);
}
