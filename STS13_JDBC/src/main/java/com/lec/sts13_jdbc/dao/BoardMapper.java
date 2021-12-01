package com.lec.sts13_jdbc.dao;

import java.util.List;

import com.lec.sts13_jdbc.vo.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> Sql_select();
	
	BoardVO Sql_selectByUid(String wr_uid);
	
	void Sql_incViewCnt(String wr_uid);
	
	void Sql_insert(BoardVO board);
	
	void Sql_update(BoardVO board);
	
	void Sql_delete(String wr_uid);
}
