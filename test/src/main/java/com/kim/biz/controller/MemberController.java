package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
@SessionAttributes("member")
public class MemberController {
	// 로그인 화면을 보여주는 로직
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}

	// 로그인 해주는 로직
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String selectOneMember(MemberVO mVO, MemberDAO mDAO, Model model, HttpSession session) {
		System.out.println("post방식의 memberC 통과");
		mVO = mDAO.selectOneMember(mVO);
		session.setAttribute("userId", mVO);
		System.out.println("MemberController_login_31_login : " + mVO); // 로그
		if (mVO == null) { // 로그인 실패
			return "main.jsp";
		} else { // 로그인 성공	
			System.out.println("MemberController_login_35_login : " + mVO); // 로그
			session.setAttribute("member", mVO);	
			return "main.do";
		}
	}

	// 로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}

	// 회원가입
	@RequestMapping(value = "/signin.do")
	public String signin(MemberVO mVO, MemberDAO mDAO) {
		mDAO.insertMember(mVO);
		return "login.jsp";
	}

	// 회원탈퇴
	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(@ModelAttribute("member") MemberVO mVO, MemberDAO mDAO, HttpSession session) {
		// mVO = (MemberVO)session.getAttribute("userId");
		mDAO.deleteMember(mVO);
		return "login.do";
	}

}
