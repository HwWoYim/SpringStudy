//package com.kim.biz.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.kim.biz.member.MemberVO;
//import com.kim.biz.member.impl.MemberDAO;
//
///*
//package com.kim.biz.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public interface Controller {
//	String handleRequest(HttpServletRequest request, HttpServletResponse response);
//}
// */
//@Controller
//public class LoginController {
//	
//	@RequestMapping("/login.do") // 더 이상 상속 받는게 없기 때문에 @override하지 않는다.
//	public ModelAndView handleRequest(HttpServletRequest request) {
//		MemberVO mVO=new MemberVO();
//		mVO.setMid(request.getParameter("mid"));
//		mVO.setMpw(request.getParameter("mpw"));
//
//		MemberDAO mDAO=new MemberDAO();
//		mVO=mDAO.selectOneMember(mVO);
//
//		// 수행결과
//		// 반환해야할 타입 : mav(ModelAndView)
//		// ModelAndView 객체 내부에는 viewName이라는 멤버변수가 존재한다.
//			// ㄴ 그곳에 어디로 가야하는지 셋팅을 해준다. 
//		ModelAndView mav=new ModelAndView();
//		if(mVO==null) {
//			mav.setViewName("redirect:login.jsp");
//		}
//		else {
//			HttpSession session=request.getSession();
//			session.setAttribute("member", mVO);
//
//			mav.setViewName("redirect:main.do");
//		}
//		return mav;
//	}
//	 
//	/*
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		String mid=request.getParameter("mid");
//		String mpw=request.getParameter("mpw");
//		MemberVO mVO=new MemberVO();
//		mVO.setMid(mid);
//		mVO.setMpw(mpw);
//
//		MemberDAO mDAO=new MemberDAO();
//		mVO=mDAO.selectOneMember(mVO);
//
//		if(mVO==null) {
//			return "login"; // VR가 .jsp를 추가하기때문에 생략해서 반환
//		}
//		else {
//			HttpSession session=request.getSession();
//			session.setAttribute("member", mVO);
//
//			return "main.do";
//		}
//	}
//	 */
//
//}
