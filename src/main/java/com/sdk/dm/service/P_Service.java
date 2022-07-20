package com.sdk.dm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dao.P_DAO;
import com.sdk.dm.dto.CA_DTO;
import com.sdk.dm.dto.M_DTO;
import com.sdk.dm.dto.P_DTO;
import com.sdk.dm.dto.S_DTO;

@Service
public class P_Service {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private P_DAO pdao;

	private M_DTO member = new M_DTO();

	// 카트를 가지고 작성 폼으로 이동
	public ModelAndView P_WriteForm(String CAMID) {
		List<CA_DTO> cart = pdao.P_WriteForm(CAMID);
		mav.setViewName("P_WriteForm");
		mav.addObject("cart", cart);
		return mav;
	}

	// 멤버 테이블의 포인트 잔액 조회
	public M_DTO M_Total(String MID) {
		member = pdao.M_Total(MID);
		return member;
	}

	// 가맹점 조회
	public List<S_DTO> PS_List() {
		List<S_DTO> shop = pdao.PS_List();
		return shop;
	}

	// 결제 내역 저장
	public int P_Write(P_DTO pay) {
		int result = pdao.P_Write(pay);
		return result;
	}

	// 결제 내역 상세 : 회원
	public ModelAndView MP_List(String PMID) {
		List<P_DTO> pay = pdao.MP_List(PMID);
		mav.setViewName("MP_List");
		mav.addObject("pay", pay);
		return mav;
	}

	// 결제 내역 취소(삭제) : 회원
	public ModelAndView MP_Delete(int PNUM, String PMID) {
		int result = pdao.MP_Delete(PNUM);
		mav.setViewName("redirect:/MP_List?PMID=" + PMID);
		return mav;
	}

	// 결제내역 목록 : 관리자
	public ModelAndView P_List() {
		List<P_DTO> pay = pdao.P_List();
		mav.setViewName("P_List");
		mav.addObject("pay", pay);
		return mav;
	}

	// 회원별 결제내역 상세 : 관리자
	public ModelAndView P_View(String PMID) {
		P_DTO pay = pdao.P_View(PMID);
		mav.setViewName("P_View");
		mav.addObject("pay", pay);
		return mav;
	}
}
