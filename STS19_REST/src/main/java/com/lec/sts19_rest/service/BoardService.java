package com.lec.sts19_rest.service;

import java.util.List;

import com.lec.sts19_rest.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> list();
	
	public BoardVO view(String wr_uid);
	
	public void updateViewcnt(String wr_uid);
	
	public void insertOne(BoardVO board);
	
	public void updateOne(BoardVO board);
	
	public void deleteOne(String wr_uid);
	
	public List<BoardVO> selectByRow(int fromRow, int wirtePages);
	
}
