package com.lec.sts16_interceptor.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.sts16_interceptor.vo.BoardVO;

@Repository("boardDAO")
public class BoardDaoJDBC implements BoardDAO {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = boardMapper.Sql_select();
		if(list.isEmpty()) {
			System.out.println("BoardDAOJDBC list null");
		}
		return list;
	}

	@Override
	public BoardVO selectOne(String wr_uid) {
		BoardVO board = boardMapper.Sql_selectByUid(wr_uid);
		return board;
	}

	@Override
	public void updateViewcnt(String wr_uid) {
		boardMapper.Sql_incViewCnt(wr_uid);
	}

	@Override
	public void insertOne(BoardVO board) {
		boardMapper.Sql_insert(board);
	}

	@Override
	public void updateOne(BoardVO board) {
		boardMapper.Sql_update(board);
	}

	@Override
	public void deleteOne(String wr_uid) {
		boardMapper.Sql_delete(wr_uid);
	}

}
