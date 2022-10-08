package com.kim.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO3 {
	@Autowired
   private SqlSessionTemplate mybatis; // SqlSession을 얻기 위해 팩토리 생성했었음.
  /*
   public BoardDAO3() {
      mybatis=SqlSessionBean.getSqlSessionInstance();
   }
   */
   public void insertBoard(BoardVO vo) {
      mybatis.insert("BoardDAO.insertBoard",vo);
     // mybatis.commit(); 메소드를 수행할 때 commit을 만나면 DB에 올려줌. 
   }
   public void updateBoard(BoardVO vo) {
      mybatis.update("BoardDAO.updateBoard",vo);
     // mybatis.commit();
   }
   public void deleteBoard(BoardVO vo) {
      mybatis.delete("BoardDAO.deleteBoard",vo);
      //mybatis.commit();
   }
   public BoardVO selectOneBoard(BoardVO vo) {
	   mybatis.update("BoardDAO.cntUpdate", vo); // 글 방문시 조회수를 올려주는 로직.
      return mybatis.selectOne("BoardDAO.selectOneBoard",vo);
   }
   public List<BoardVO> selectAllBoard(BoardVO vo) {
      return mybatis.selectList("BoardDAO.selectAllBoard",vo);
   }
}