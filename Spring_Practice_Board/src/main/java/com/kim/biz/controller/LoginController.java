package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

/*
package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
*/
public class LoginController implements Controller {

	// 메소드 오버라이딩 강제를 하고 있어서 반환을 ModelAndView로 해야 한다.
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO mVO=new MemberVO();
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		 
		MemberDAO mDAO=new MemberDAO();
		mVO=mDAO.selectOneMember(mVO);
		
		// 수행결과
		// 반환해야할 타입 : mav(ModelAndView)
		// ModelAndView 객체 내부에는 viewName이라는 멤버변수가 존재한다.
			// ㄴ 그곳에 어디로 가야하는지 셋팅을 해준다.
		ModelAndView mav=new ModelAndView();
		if(mVO==null) {
			mav.setViewName("redirect:login.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);
			
			mav.setViewName("redirect:main.do");
		}
		return mav;
	}

	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		MemberVO mVO=new MemberVO();
		mVO.setMid(mid);
		mVO.setMpw(mpw);
		
		MemberDAO mDAO=new MemberDAO();
		mVO=mDAO.selectOneMember(mVO);
		
		if(mVO==null) {
			return "login"; // VR가 .jsp를 추가하기때문에 생략해서 반환
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);
			
			return "main.do";
		}
	}
	*/

}
