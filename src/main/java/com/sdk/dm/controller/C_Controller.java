package com.sdk.dm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdk.dm.dto.C_DTO;
import com.sdk.dm.service.C_Service;

@Controller
public class C_Controller {
	// Service 연결
	@Autowired
	private C_Service csvc;
	
	// 댓글 객체 생성
	List<C_DTO> COMMLIST = new ArrayList<C_DTO>();

	// 댓글 목록
	@PostMapping("/C_List")
	public @ResponseBody List<C_DTO> C_List(@RequestParam(value = "cbNum", required = true) int cbNum) {
		COMMLIST = csvc.C_List(cbNum);
		return COMMLIST;
	}

	// 댓글 작성
	@PostMapping("/C_Write")
	public @ResponseBody List<C_DTO> C_Write(@ModelAttribute C_DTO comm) {
		COMMLIST = csvc.C_Write(comm);
		return COMMLIST;
	}
	
	// 댓글 수정
	@PostMapping("/C_Modify")
	public @ResponseBody List<C_DTO> C_Modify(@ModelAttribute C_DTO comm){
		System.out.println("[1] controller : " + comm);
		COMMLIST = csvc.C_Modify(comm);
		System.out.println("[5] controller : " + COMMLIST);
		return COMMLIST;
	}

	// 댓글 삭제
	@PostMapping("/C_Delete")
	public @ResponseBody List<C_DTO> C_Delete(@ModelAttribute C_DTO comm) {
		System.out.println("[1] Controller : " + comm);
		COMMLIST = csvc.C_Delete(comm);
		return COMMLIST;
	}
}
