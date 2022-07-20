package com.sdk.dm.controller;

import java.util.List;

import com.sdk.dm.dto.P_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dto.M_DTO;
import com.sdk.dm.dto.S_DTO;
import com.sdk.dm.service.P_Service;

@Controller
public class P_Controller {
	// ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
    
    // Service 연결
    @Autowired
    private P_Service psvc;
    
    // member 객체 생성
    private M_DTO member = new M_DTO();

    // 카트를 가지고 작성 폼으로 이동
    @GetMapping("/P_WriteForm")
    public ModelAndView P_WriteForm(@RequestParam("CAMID") String CAMID){
    	mav = psvc.P_WriteForm(CAMID);
        return mav;
    }
    
    // 멤버 테이블에서 잔액을 조회
    @PostMapping("/M_Total")
    public @ResponseBody M_DTO M_Total(@RequestParam("MID") String MID) {
    	member = psvc.M_Total(MID);
    	return member;
    }
    
    // 가맹점 조회
    @PostMapping("/PS_List")
    public @ResponseBody List<S_DTO> PS_List(){
        List<S_DTO> shop = psvc.PS_List();
        return shop;
    }

    // 결제내역에 저장
    @PostMapping("/P_Write")
    public @ResponseBody int P_Write(@ModelAttribute P_DTO pay){
        int result = psvc.P_Write(pay);
        return result;
    }

    // 결제 내역 상세 : 회원
    @GetMapping("/MP_List")
    public ModelAndView MP_List(@RequestParam("PMID") String PMID){
    	mav = psvc.MP_List(PMID);
        return mav;
    }
    
    // 결제 내역 삭제 : 회원
    @GetMapping("/MP_Delete")
    public ModelAndView MP_Delete(@RequestParam("PNUM") int PNUM, @RequestParam("PMID") String PMID) {
    	mav = psvc.MP_Delete(PNUM,PMID);
    	return mav;
    }

    // 결제 내역 목록 : 관리자
    @RequestMapping(value = "/P_List", method = RequestMethod.GET)
    public ModelAndView P_List() {
        mav = psvc.P_List();
        return mav;
    }

    // 회원별 결제 내역 상세 : 관리자
    @RequestMapping(value = "/P_View", method = RequestMethod.GET)
    public ModelAndView P_View(@RequestParam("PMID") String PMID) {
        mav = psvc.P_View(PMID);
        return mav;
    }

}
