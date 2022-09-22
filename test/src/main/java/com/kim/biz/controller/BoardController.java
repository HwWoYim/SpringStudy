package com.kim.biz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("data")
public class BoardController{
	@RequestMapping(value="/board.do")
	public String board(BoardVO bVO, BoardDAO bDAO, Model model) {

		bVO=bDAO.selectOneBoard(bVO);
		model.addAttribute("data", bVO); // boot방식
		return "board.jsp";
	}
	//게시글 작성
	@RequestMapping(value="/insertBoard.do")
	public String insertboard(BoardVO bVO, BoardDAO bDAO) {
		bDAO.insertBoard(bVO);
		System.out.println("게시글 추가 로그 : " + bVO);
		return "main.do";
	}
	//게시글 변경
	@RequestMapping(value="/updateBoard.do")
	public String updateboard(@ModelAttribute("data")BoardVO bVO, BoardDAO bDAO, Model model) {
		bDAO.updateBoard(bVO);
		return "main.do";
	}
	//게시글 삭제
	@RequestMapping(value="/deleteBoard.do")
	public String deleteboard(@ModelAttribute("data")BoardVO bVO, BoardDAO bDAO, Model model) {
		bDAO.deleteBoard(bVO);
		return "main.do";
	}
}
