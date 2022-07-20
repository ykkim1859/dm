package com.sdk.dm.controller;

import com.sdk.dm.dto.PR_DTO;
import com.sdk.dm.service.PR_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class PR_Controller {
	// 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
    // 2. 서비스 연결
    @Autowired
    private PR_Service prsvc;

    // 상품 등록 페이지로 이동
    @GetMapping("/PR_WriteForm")
    public String PR_WriteForm(){
        return "PR_WriteForm";
    }

    // 상품 등록
    @PostMapping("/PR_Write")
    public ModelAndView PR_Write(@ModelAttribute PR_DTO product) throws IOException {
        mav = prsvc.PR_Write(product);
        return mav;
    }

    // 상품 목록
    @GetMapping("/PR_List")
    public ModelAndView PR_List(@RequestParam("PRTNUM") int PRTNUM, @RequestParam("PRKNUM") int PRKNUM){
        mav = prsvc.PR_List(PRTNUM, PRKNUM);
        System.out.println("[5]" + mav);
        return mav;
    }

    // 상품 상세
    @GetMapping("/PR_View")
    public ModelAndView PR_View(@RequestParam("PRNUM") int PRNUM){
        mav = prsvc.PR_View(PRNUM);
        return mav;
    }

    // 상품 수정 페이지로 이동
    @GetMapping("/PR_ModiForm")
    public ModelAndView PR_ModiForm(@RequestParam("PRNUM") int PRNUM){
        mav = prsvc.PR_ModiForm(PRNUM);
        return mav;
    }

    // 상품 수정
    @PostMapping("/PR_Modify")
    public ModelAndView PR_Modify(@ModelAttribute PR_DTO product) throws IOException {
        mav = prsvc.PR_Modify(product);
        return mav;
    }

    // 상품 삭제
    @GetMapping("/PR_Delete")
    public ModelAndView PR_Delete(@RequestParam("PRNUM") int PRNUM){
        mav = prsvc.PR_Delete(PRNUM);
        return mav;
    }
    
    ///////////////////////////////////////////////////// 회원 /////////////////////////////////////////////////////
    
    // 상품 목록
    @GetMapping("/MPR_List")
    public ModelAndView MPR_List(@RequestParam("PRTNUM") int PRTNUM, @RequestParam("PRKNUM") int PRKNUM){
        mav = prsvc.MPR_List(PRTNUM, PRKNUM);
        return mav;
    }

    // 상품 상세
    @GetMapping("/MPR_View")
    public ModelAndView MPR_View(@RequestParam("PRNUM") int PRNUM){
        mav = prsvc.MPR_View(PRNUM);
        return mav;
    }
}
