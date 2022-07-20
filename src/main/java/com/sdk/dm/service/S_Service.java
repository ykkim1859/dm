package com.sdk.dm.service;

import com.sdk.dm.dao.S_DAO;
import com.sdk.dm.dto.S_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class S_Service {
	// 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
	// 2. 서비스 연결
    @Autowired
    private S_DAO sdao;
    
    // 가맹점 등록
    public ModelAndView S_Write(S_DTO shop) {
        // 1. 주소 처리
        String addr1 = shop.getAddr1();
        String addr2 = shop.getAddr2();
        String addr3 = shop.getAddr3();

        String SADDR = "(" + addr1 + ")" + addr2 + " " + addr3;

        if (!addr1.equals("")) {
            shop.setSADDR(SADDR);
        }
        // 2. 결과에 따른 페이지 이동
        int result = sdao.S_Write(shop);
        if (result > 0) {
            mav.setViewName("M_Admin");
        } else {
            mav.setViewName("index");
        }

        return mav;
    }
    
    // 가맹점 목록
    public ModelAndView S_List() {
        List<S_DTO> shop = sdao.S_List();
        mav.setViewName("S_List");
        mav.addObject("shop", shop);
        return mav;
    }
    
    // 가맹점 상세
    public ModelAndView S_View(int SNUM) {
        S_DTO shop = sdao.S_View(SNUM);
        mav.setViewName("S_View");
        mav.addObject("shop", shop);
        return mav;
    }
    
    // 가맹점 수정 페이지로 이동
    public ModelAndView S_ModiForm(int SNUM) {
        S_DTO shop = sdao.S_View(SNUM);
        mav.setViewName("S_ModiForm");
        mav.addObject("shop", shop);
        return mav;
    }
    
    // 가맹점 수정
    public ModelAndView S_Modify(S_DTO shop) {
        // 1. 주소 처리
        String addr1 = shop.getAddr1();
        String addr2 = shop.getAddr2();
        String addr3 = shop.getAddr3();

        String SADDR = "(" + addr1 + ")" + addr2 + " " + addr3;

        if (!addr1.equals("")) {
            shop.setSADDR(SADDR);
        }
        // 2. 결과에 따른 페이지 이동
        int result = sdao.S_Modify(shop);
        if (result > 0) {
            mav.setViewName("M_Admin");
        } else {
            mav.setViewName("index");
        }

        return mav;
    }
    
    // 가맹점 삭제
    public ModelAndView S_Delete(int SNUM) {
        int result = sdao.S_Delete(SNUM);
        if(result>0){
            mav.setViewName("redirect:/S_List");
        } else{
            mav.setViewName("redirect:/S_View?SNUM="+SNUM);
        }
        return mav;
    }
}
