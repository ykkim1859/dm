package com.sdk.dm.controller;

import java.io.IOException;

import com.sdk.dm.service.B_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dto.B_DTO;

@Controller
public class B_Controller {
	// 1. ModelAndView 객체 생성
	private ModelAndView mav = new ModelAndView();
	// 2. 서비스 연결
	@Autowired
	private B_Service bsvc;
	
	// 게시글 등록 페이지로 이동
	@GetMapping("/B_WriteForm")
	public String B_WriteForm() {
		return "B_WriteForm";
	}
	
	// 게시글 등록
	@PostMapping("/B_Write")
	public ModelAndView B_Write(@ModelAttribute B_DTO board) throws IllegalStateException, IOException {
		mav = bsvc.B_Write(board);
		return mav;
	}
	
	// 게시글 목록
	@GetMapping("/B_List")
	public ModelAndView B_List(@RequestParam("BGROUP") String BGROUP) {
		mav = bsvc.B_List(BGROUP);
		return mav;
	}
	
	// 게시글 상세
	@GetMapping("/B_View")
	public ModelAndView B_View(@RequestParam("BNUM") int BNUM) {
		mav = bsvc.B_View(BNUM);
		return mav;
	}
	
	// 게시글 수정 페이지로 이동
	@GetMapping("/B_ModiForm")
	public ModelAndView B_ModiForm(@RequestParam("BNUM") int BNUM) {
		mav = bsvc.B_ModiForm(BNUM);
		return mav;
	}
	
	// 게시글 수정
	@PostMapping("/B_Modify")
	public ModelAndView B_Modify(@ModelAttribute B_DTO board) throws IOException {
		mav = bsvc.B_Modify(board);
		return mav;
	}
	
	// 게시글 삭제
	@GetMapping("/B_Delete")
	public ModelAndView B_Delete(@RequestParam("BNUM") int BNUM) {
		mav = bsvc.B_Delete(BNUM);
		return mav;
	}
}
