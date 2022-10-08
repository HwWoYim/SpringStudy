package com.kim.biz.board;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int bid; // 글 고유 번호
	private String title; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private int cnt; // 조회수
	private String regdate; // 글이 데이터베이스 들어온 시간(작성된 시간)
	private String searchCondition; // 어떤 검색조건을 선택할 것인지	
	private String searchContent; // 검색조건을 골랐다면 어떤 내용을 검색할 것이지.
	private MultipartFile uploadFile; // springframework에서 제공하는 MultipartFile
	private String fileName; // 저장된 파일이름
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", title=" + title + ", writer=" + writer + ", content=" + content + ", cnt="
				+ cnt + ", regdate=" + regdate + ", searchCondition=" + searchCondition + ", searchContent="
				+ searchContent + ", uploadFile=" + uploadFile + ", fileName=" + fileName + "]";
	}
	
	
	
}
