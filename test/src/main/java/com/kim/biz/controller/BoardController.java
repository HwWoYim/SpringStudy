package com.kim.biz.controller;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kim.biz.board.BoardService;
import com.kim.biz.board.BoardVO;

@Controller
@SessionAttributes("data")
public class BoardController{
	
	@Autowired
	private BoardService boardService; //비지니스 컴포넌트. DAO를 직접 이용하지 않는다.
	
	@RequestMapping(value="/board.do")
	public String board(BoardVO bVO, Model model) {

		bVO=boardService.selectOneBoard(bVO);
		model.addAttribute("data", bVO); // boot���
		System.out.println("BoardController의 상세보기 : " + bVO);
		return "board.jsp";
	}
	// 글 작성하기
	@RequestMapping(value="/insertBoard.do")
	public String insertboard(BoardVO bVO) throws IllegalStateException, IOException {
//		System.out.println("Insert.do 로그 : " + bVO);
		// 업로드한 파일을 받아온다.	
		MultipartFile uploadFile=bVO.getUploadFile();
		if(!uploadFile.isEmpty()) {	// 업로드한 파일 존재여부 확인
			// 업로드한 파일명
			String fileName = uploadFile.getOriginalFilename();
//			System.out.println("==========파일이름===========");
			System.out.println("업로드된 파일이름 : "+fileName);
			bVO.setFileName(fileName);
			// 업로드한 파일을 지정한 경로에 저장
			uploadFile.transferTo(new File("C:\\0607_YIM\\newWorkSpace\\SpringStudy\\test\\src\\main\\webapp\\images\\" + fileName));
//			System.out.println("BoardController_45_bVO로그 : " + bVO);
		}
		boardService.insertBoard(bVO);
//		System.out.println("bCtrl insert로그 : " + bVO);
		return "main.do";
	}
	// 글 변경하기
	@RequestMapping(value="/updateBoard.do")
	public String updateboard(@ModelAttribute("data")BoardVO bVO, Model model) throws IllegalStateException, IOException {
		System.out.println("BoardController_33_bVO 로그 : " + bVO);
		MultipartFile uploadFile=bVO.getUploadFile();
		if(!uploadFile.isEmpty()) {	// 업로드한 파일 존재여부 확인
			String fileName = uploadFile.getOriginalFilename(); // 업로드한 파일명
			System.out.println("업로드된 파일이름 : "+fileName);
			bVO.setFileName(fileName);
			uploadFile.transferTo(new File("C:\\0607_YIM\\newWorkSpace\\SpringStudy\\test\\src\\main\\webapp\\images\\" + fileName)); // 업로드한 파일을 지정한 경로에 저장
//			System.out.println("BoardController_45_bVO로그 : " + bVO);
		}
		boardService.updateBoard(bVO);
//		System.out.println("BoardController_35_bVO 로그 : " + bVO);
		return "main.do";
	}
	//�Խñ� ����
	@RequestMapping(value="/deleteBoard.do")
	public String deleteboard(@ModelAttribute("data")BoardVO bVO, Model model) {
		boardService.deleteBoard(bVO);
		return "main.do";
	}
	@ModelAttribute("scMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> scMap = new HashMap<String, String>();
		scMap.put("제목", "TITLE");
		scMap.put("작성자", "WRITER");
		scMap.put("내용", "CONTENT");
		return scMap;
	}
	
	@RequestMapping(value="/main.do")
	public String main(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String searchCondition, @RequestParam(value="searchContent", defaultValue="", required=false) String searchContent, BoardVO bVO, Model model) {
//		System.out.println("검색어 로그 : " + searchContent);
		// 검색 조건이 null인지 체크하는 로직
		if(searchCondition != null) {
			if(searchCondition.equals("TITLE")) {
				System.out.println("검색조건 로그 : " + searchCondition);
				bVO.setTitle(searchContent);
			} else if(searchCondition.equals("WRITER")) {	
				bVO.setWriter(searchContent);
			}else if(searchCondition.equals("CONTENT")) {	
				bVO.setContent(searchContent);
			}
//			System.out.println("MainController_41_bVO로그 : " + bVO);
		}
		List<BoardVO> datas=boardService.selectAllBoard(bVO); // 1�� �̻��� �� �ֱ⶧���� �迭����Ʈ�� ����
		
		model.addAttribute("datas", datas); // ���� "datas"��� �̸����� datas�� �����Ѵ�.
		return "main.jsp";
	}
}
