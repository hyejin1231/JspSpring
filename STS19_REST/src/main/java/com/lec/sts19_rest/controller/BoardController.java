package com.lec.sts19_rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lec.sts19_rest.BoardVaildator;
import com.lec.sts19_rest.service.BoardService;
import com.lec.sts19_rest.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// 목록 조회 
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<BoardVO> list = boardService.list();
		model.addAttribute("list", list);
		
		if(list.isEmpty()) {
			System.out.println("list is null");
		}
		
		return "board/list";
	}
	
	
	@RequestMapping("/view.do")
	public ModelAndView view(@RequestParam("wr_uid") String wr_uid) {
		boardService.updateViewcnt(wr_uid);
		BoardVO board = boardService.view(wr_uid);
		return new ModelAndView("board/view", "board",board);
	}
	
	@RequestMapping("/write.do")
	public String writepage() {
		return "board/write";
	}
	
	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute("board") @Valid BoardVO board, BindingResult result) {
//		boardService.insertOne(board);
		
		showErrors(result);
		
		if(result.hasErrors()) {
			return "board/write";
		}else {
			boardService.insertOne(board);
			return "redirect:/board/list.do";	
		}
		
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam("wr_uid") String wr_uid) {
		 BoardVO board = boardService.view(wr_uid);
		 return new ModelAndView("board/update", "board", board);
	}
	
	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute("board") @Valid BoardVO board, BindingResult result) {
		showErrors(result);
		
		if(result.hasErrors()) {
			return "board/update";
		}else {
			boardService.updateOne(board);
			return "redirect:/board/list.do";
		}
	}
	
	@RequestMapping("/deleteOk.do/{wr_uid}")
	public String deleteOk(@PathVariable String wr_uid) {
		boardService.deleteOne(wr_uid);
		return "redirect:/board/list.do";
	}
	
	
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수 :" + errors.getErrorCount());
			System.out.println("\t[filed]\t[code]");
			List<FieldError> errlist = errors.getFieldErrors();
			
			for(FieldError err : errlist) {
				System.out.println("\t " + err.getField() + "\t|" + err.getCode());
			}
		}else {
			System.out.println("에러 없음");
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardVaildator());
	}
	
	@RequestMapping("/rest")
	public String restBoard() {
		return "/board/rest"; 
	}
	
}




























