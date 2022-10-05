package com.kim.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO3 {

	// SqlSession을 얻기 위해 팩토리를 생성하고 멤버변수를 선언해줌으로써 가져옴.
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 회원가입
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	// 회원정보변경
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}
	// 회원탈퇴
	public void deleteMember(MemberVO vo) {
		mybatis.delete("MemberDAO.deleteMember", vo);
	}
	// 로그인
	public MemberVO selectOneMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.selectOneMember", vo);
	}
	// 회원목록 - 딱히 해당 프로젝트에선 불필요
	public List<MemberVO> selectAllMember(MemberVO vo){
		return mybatis.selectList("MemberDAO.selectAllMember", vo);
	}
}
