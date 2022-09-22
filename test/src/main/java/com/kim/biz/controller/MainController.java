package com.kim.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;
import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
@SessionAttributes("userId")
public class MainController {
	
	@ModelAttribute("scMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> scMap = new HashMap<String, String>();
		scMap.put("제목", "TITLE");
		scMap.put("작성자", "WRITER");
		return scMap;
	}
	
	@RequestMapping(value="/main.do")
	public String main(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String searchCondition, @RequestParam(value="searchContent", defaultValue="", required=false) String searchContent, MemberVO mVO, MemberDAO mDAO, BoardVO bVO, BoardDAO bDAO, Model model) {
		System.out.println("검색조건 : " + searchCondition);
		System.out.println("검색어 : " + searchContent);
		if(searchCondition != null) {
			if(searchCondition.equals("TITLE")) {
				bVO.setTitle(searchContent);
				System.out.println("검색로그 : " + bVO);
			} else if(searchCondition.equals("WRITER")) {	
				bVO.setWriter(searchContent);
			}
		}
		List<BoardVO> datas=bDAO.selectAllBoard(bVO); // 1개 이상일 수 있기때문에 배열리스트에 저장
		mVO=mDAO.selectOneMember(mVO);	
		
		model.addAttribute("datas", datas); // 왼쪽 "datas"라는 이름으로 datas를 전달한다.
		model.addAttribute("member", mVO);
		return "main.jsp";
	}
	//2022.09.22
//	@RequestMapping(value="/main.do")
//	public ModelAndView selectAllBoard(MemberVO mVO, MemberDAO mDAO, BoardVO bVO, BoardDAO bDAO, ModelAndView mav, HttpSession session) {
//		List<BoardVO> datas=bDAO.selectAllBoard(bVO); // 1개 이상일 수 있기때문에 배열리스트에 저장
//		mVO = (MemberVO)session.getAttribute("userId");
//		System.out.println("MainController로그 1 : " + datas);
//		
//		mav.addObject("datas", datas); // 왼쪽 "datas"라는 이름으로 datas를 전달한다.
//		mav.setViewName("main.jsp");
//		return mav;
//	}

	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bVO=new BoardVO();
		
		BoardDAO bDAO=new BoardDAO();
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("datas", datas);
		
		return "main";
	}
	*/
	
}
