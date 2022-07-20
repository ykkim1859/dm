package com.sdk.dm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dto.CA_DTO;
import com.sdk.dm.service.CA_Service;

@Controller
public class CA_Controller {

	// mav 객체 생성
	private ModelAndView mav = new ModelAndView();
	
	// service 연결
	@Autowired
	private CA_Service casvc;
	
	// 장바구니 저장
	@PostMapping("CA_Write")
	public @ResponseBody int CA_Write(@ModelAttribute CA_DTO cart) {
		int result = casvc.CA_Write(cart);
		return result;
	}

	// 장바구니 목록
	@GetMapping("CA_List")
	public ModelAndView CA_List(@RequestParam("CAMID") String CAMID) {
		mav = casvc.CA_List(CAMID);
		return mav;
	}

	// 장바구니 수량 수정
	@PostMapping("CA_Modify")
	public ModelAndView CA_Modify(@ModelAttribute CA_DTO cart) {
		System.out.println("[1] " + cart);
		mav = casvc.CA_Modify(cart);
		System.out.println("[5] " + mav);
		return mav;
	}

	// 상품에 대한 합계 리스트로 갖고 오기
	@PostMapping("CA_PTotal")
	public @ResponseBody List<Integer> CA_PTotal(@RequestParam("CAMID") String CAMID) {
		List<Integer> result = casvc.CA_PTotal(CAMID);
		System.out.println("[5] : " + result);
		return result;
	}
	
	// 장바구니 전체 삭제
	@GetMapping("CA_DeleteAll")
	public ModelAndView CA_DeleteAll(@RequestParam("CAMID") String CAMID) {
		mav = casvc.CA_DeleteAll(CAMID);
		return mav;
	}
	
	// 장바구니 삭제 (개별)
	@GetMapping("/CA_DeleteChoice")
	public ModelAndView CA_DeleteChoice(@RequestParam("CANUM") int CANUM, @RequestParam("CAMID") String CAMID){
		mav = casvc.CA_DeleteChoice(CANUM, CAMID);
		return mav;
	}
}
