package com.sdk.dm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dao.CA_DAO;
import com.sdk.dm.dto.CAPR_DTO;
import com.sdk.dm.dto.CA_DTO;

@Service
public class CA_Service {
	// mav 객체 생성
	private ModelAndView mav = new ModelAndView();

	// dao 연결
	@Autowired
	private CA_DAO cadao;
	
	// 장바구니 저장
	public int CA_Write(CA_DTO cart) {
		// CATOTAL 변수를 만들어 cart의 가격과 갯수를 곱함
		int CATOTAL = cart.getCAPRICE() * cart.getCACOUNT();
		// cart에 CATOTAL을 저장
		cart.setCATOTAL(CATOTAL);
		// PR에서 PRNAME 검색
		Integer PRNUM = cadao.CA_PRNUM(cart.getCAPRNUM());
		if(PRNUM == null) {
			// 결과를 반출
			int result = cadao.CA_Write(cart);
			return result;
		} else {
			PRNUM += cart.getCACOUNT();
			cart.setCACOUNT(PRNUM);
			int result = cadao.CA_Add(cart);
			return result;
		}
	}
	
	// 장바구니 목록
	public ModelAndView CA_List(String CAMID) {
		List<CAPR_DTO> cart = cadao.CA_List(CAMID);
		mav.setViewName("CA_List");
		mav.addObject("cart", cart);
		return mav;
	}

	// 장바구니 수량 수정
	public ModelAndView CA_Modify(CA_DTO cart) {
		// CATOTAL 변수를 만들어 cart의 가격과 갯수를 곱함
		int CATOTAL = cart.getCAPRICE() * cart.getCACOUNT();
		// cart에 CATOTAL을 저장
		cart.setCATOTAL(CATOTAL);
		int result = cadao.CA_Modify(cart);
		if(result > 0) {
			mav.setViewName("redirect:/CA_List?CAMID="+cart.getCAMID());
		}
		return mav;
	}
	
	// 상품에 대한 합계 리스트로 갖고 오기
	public List<Integer> CA_PTotal(String CAMID) {
		List<Integer> result = cadao.CA_Total(CAMID);
		return result;
	}
	
	// 장바구니 전체 삭제
	public ModelAndView CA_DeleteAll(String CAMID) {
		int result = cadao.CA_DeleteAll(CAMID);
		if (result > 0) {
			// 삭제 성공
			mav.setViewName("redirect:/CA_List?CAMID="+CAMID);
		}  else {
			// 삭제 실패
			mav.setViewName("index");
		}
		return mav;
	}

	// 장바구니 삭제 (개별)
	public ModelAndView CA_DeleteChoice(int CANUM, String CAMID) {
		int result = cadao.CA_DeleteChoice(CANUM);
		if(result>0){
			mav.setViewName("redirect:/CA_List?CAMID="+CAMID);
		} else{
			mav.setViewName("redirect:/CA_List");
		}
		return mav;
	}
}
