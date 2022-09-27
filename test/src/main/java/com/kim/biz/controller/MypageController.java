//package com.kim.biz.controller;
//
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.kim.biz.member.MemberService;
//import com.kim.biz.member.MemberVO;
//import com.kim.biz.member.impl.MemberDAO;
//
//@Controller
//@SessionAttributes("member")
//public class MypageController{
//	
//	@Autowired
//	private MemberService memberService;
//	
//	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
//	public String mypage(@ModelAttribute("member")MemberVO mVO, Model model, HttpSession session) {
////		mVO = (MemberVO)session.getAttribute("userId");
//		mVO = memberService.selectOneMember(mVO);
//
////		mav.addObject("member", mVO);
////		mav.setViewName("mypage.jsp");
//		System.out.println("Mypage_27_mVO로그 : " + mVO);
////		model.addAttribute("member", mVO);
//		return "mypage.jsp";
//	}
//
//	@RequestMapping(value="/update.do", method = RequestMethod.POST)
//	public String update(@ModelAttribute("member")MemberVO mVO, Model model) {
//		memberService.updateMember(mVO);
//
//		return "main.do";
//	}
//	
//	
//}