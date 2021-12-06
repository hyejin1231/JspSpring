package com.lec.sts19_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.service.BoardService;
import com.lec.sts19_rest.vo.AjaxBoardList;
import com.lec.sts19_rest.vo.AjaxBoardQryResult;
import com.lec.sts19_rest.vo.BoardVO;

@RestController
@RequestMapping("/BoardAJAX")
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;

//	@RequestMapping("/list.do/{writePages}/{page}")
//	public List<BoardVO> list(@PathVariable("writePages") int writePages, @PathVariable("page") int page){
//		List<BoardVO> list = boardService.selectByRow((page-1) * writePages + 1, writePages);
//		
//		return list;
//	}
	
	@RequestMapping("/list.do/{writePages}/{page}")
	public AjaxBoardList list(@PathVariable("writePages") int writePages, @PathVariable("page") int page){
		AjaxBoardList result = new AjaxBoardList();
		
		List<BoardVO> list = boardService.selectByRow((page-1) * writePages + 1, writePages);
		result.setList(list);
		
		if(list != null && list.size() > 0) {
			result.setStatus("OK");
			result.setCount(list.size());
		}else {
			result.setStatus("FAIL");
		}
		return result;
	}
	
	
	@RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
	public AjaxBoardQryResult writeOk(BoardVO board) {
		AjaxBoardQryResult result = new AjaxBoardQryResult();
		
		if(board != null) {
			boardService.insertOne(board);
			result.setCount(1);
			result.setStatus("OK");
		}else {
			result.setStatus("FAIL");
		}
		return result;
	}
	
	@RequestMapping(value = "/deleteOk.do")
	public AjaxBoardQryResult deleteOk(String[] wr_uid) {
		AjaxBoardQryResult result = new AjaxBoardQryResult();
		
		if(wr_uid != null && wr_uid.length > 0) {
			for(String i : wr_uid) {
				boardService.deleteOne(i);
			}
			
			result.setStatus("OK");
		}else {
			result.setStatus("FAIL");
		}
		
		return result;
	}
}













































