package com.sdk.dm.controller;

import com.sdk.dm.dto.S_DTO;
import com.sdk.dm.service.S_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class S_Controller {
	// 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
    // 2. 서비스 연결
    @Autowired
    private S_Service ssvc;

    // 가맹점 등록 페이지로 이동
    @GetMapping("/S_WriteForm")
    public String S_WriteForm() {
        return "S_WriteForm";
    }

    // 가맹점 등록
    @PostMapping("/S_Write")
    public ModelAndView S_Write(@ModelAttribute S_DTO shop) {
        mav = ssvc.S_Write(shop);
        return mav;
    }

    // 가맹점 목록
    @RequestMapping(value = "/S_List", method = RequestMethod.GET)
    public ModelAndView S_List() {
        mav = ssvc.S_List();
        return mav;
    }

    // 가맹점 상세
    @RequestMapping(value = "/S_View", method = RequestMethod.GET)
    public ModelAndView S_View(@RequestParam("SNUM") int SNUM) {
        mav = ssvc.S_View(SNUM);
        return mav;
    }

    // 가맹점 수정 페이지로 이동
    @RequestMapping(value = "/S_ModiForm", method = RequestMethod.GET)
    public ModelAndView S_ModiForm(@RequestParam("SNUM") int SNUM) {
        mav = ssvc.S_ModiForm(SNUM);
        return mav;
    }

    // 가맹점 수정
    @PostMapping("/S_Modify")
    public ModelAndView S_Modify(@ModelAttribute S_DTO shop){
        mav = ssvc.S_Modify(shop);
        return mav;
    }

    // 가맹점 삭제
    @GetMapping ("/S_Delete")
    public ModelAndView S_Delete(@RequestParam("SNUM") int SNUM){
        mav = ssvc.S_Delete(SNUM);
        return mav;
    }
}
