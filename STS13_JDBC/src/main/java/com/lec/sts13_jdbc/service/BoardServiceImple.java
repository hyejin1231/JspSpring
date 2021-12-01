package com.lec.sts13_jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.sts13_jdbc.dao.BoardDAO;
import com.lec.sts13_jdbc.vo.BoardVO;

@Service("boardService")
public class BoardServiceImple implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list() {
		List<BoardVO> list = boardDAO.selectAll();
		if(list.isEmpty()) {
			System.out.println("BoardService list null");
		}
		return list;
	}

	@Override
	public BoardVO view(String wr_uid) {
		BoardVO board = boardDAO.selectOne(wr_uid);
		return board;
	}

	@Override
	public void updateViewcnt(String wr_uid) {
		boardDAO.updateViewcnt(wr_uid);
//		System.out.println(wr_uid + " 조회수 증가 완료");
	}

	@Override
	public void insertOne(BoardVO board) {
		boardDAO.insertOne(board);
//		System.out.println(board.getSubject() + "글 등록 완료");
		
	}

	@Override
	public void updateOne(BoardVO board) {
		boardDAO.updateOne(board);
//		System.out.println(board.getName()+ "님의 글 정보 수정 완료");
	}

	@Override
	public void deleteOne(String wr_uid) {
		boardDAO.deleteOne(wr_uid);
//		System.out.println(wr_uid + "글 삭제 완료 ");
	}

	

}
