package com.yim.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yim.biz.common.LogAdvice;
import com.yim.biz.member.MemberService;
import com.yim.biz.member.MemberVO;
	
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired // MemberDAO 타입의 객체가 메모리에 있어야지만 DI(의존성 주입) 가능함!
	private MemberDAO memberDAO; // 핵심로직을 수행할 객체
	
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public MemberVO selectOneMember(MemberVO vo) {
		if(vo.getMid().equals("timo")) { // 일부러 예외를 발생시켜서 실습
			throw new IllegalArgumentException("[실행시 예외]");
		}
		return memberDAO.selectOneMember(vo);
	}

	@Override
	public List<MemberVO> selectAllMember(MemberVO vo) {
		return memberDAO.selectAllMember(vo);
	}

}
