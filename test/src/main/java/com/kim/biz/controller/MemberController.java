package com.kim.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}

	// POST방식 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String selectOneMember(MemberVO mVO, Model model, HttpSession session) {
//		System.out.println("post 방식 memberC 로그");
		mVO = memberService.selectOneMember(mVO);
		session.setAttribute("userId", mVO);
//		System.out.println("MemberController_login_31_login : " + mVO); // �α�
		if (mVO == null) { // �α��� ����
			return "main.jsp";
		} else { // �α��� ����	
//			System.out.println("MemberController_login_35_login : " + mVO); // �α�
			session.setAttribute("member", mVO);	
			return "main.do";
		}
	}

	// 로그인
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}

	// 회원가입
//	@RequestMapping(value = "/signin.do")
//	public String signin(MemberVO mVO) {
//		memberService.insertMember(mVO);
//		return "login.jsp";
//	}
	// 로그인 페이지에서 회원가입 이동할 때
	@RequestMapping(value="/signin.do", method=RequestMethod.GET)
	public String signin() {
	   return "signin.jsp";
	}
	// 회원가입 페이지에서 회원가입할 때
	@RequestMapping(value="/signin.do", method=RequestMethod.POST)
	public String signin(MemberVO mVO) {
	   memberService.insertMember(mVO);
	   return "redirect:login.do";
	}

	// ȸ��Ż��
	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(@ModelAttribute("member") MemberVO mVO, HttpSession session) {
		// mVO = (MemberVO)session.getAttribute("userId");
		memberService.deleteMember(mVO);
		return "login.do";
	}
	
	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
	public String mypage(@ModelAttribute("member")MemberVO mVO, Model model, HttpSession session) {
//		mVO = (MemberVO)session.getAttribute("userId");
		mVO = memberService.selectOneMember(mVO);

//		mav.addObject("member", mVO);
//		mav.setViewName("mypage.jsp");
//		System.out.println("Mypage_27_mVO로그 : " + mVO);
//		model.addAttribute("member", mVO);
		return "mypage.jsp";
	}

	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute("member")MemberVO mVO, Model model) {
		memberService.updateMember(mVO);

		return "main.do";
	}

}
