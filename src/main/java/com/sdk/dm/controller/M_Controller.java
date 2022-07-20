package com.sdk.dm.controller;

import com.sdk.dm.dto.M_DTO;
import com.sdk.dm.service.M_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class M_Controller {
	// 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
    // 2. 서비스 연결
    @Autowired
    private M_Service msvc;
    // Session 사용
    @Autowired
    private HttpSession session;

    // 인덱스 페이지로 이동
    @GetMapping("/nav")
    public String nav() {
        return "nav";
    }
    // 인덱스 페이지로 이동
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    // 관리자 페이지로 이동
    @GetMapping("/M_Admin")
    public String M_Admin() {
        return "M_Admin";
    }

    // 회원 등록 페이지로 이동
    @RequestMapping(value = "/M_JoinForm", method = RequestMethod.GET)
    public String M_JoinForm() {
        return "M_JoinForm";    // /WEB-INF/views/joinForm.jsp
    }

    // 회원 등록
    @RequestMapping(value = "/M_Join", method = RequestMethod.POST)
    public ModelAndView M_Join(@ModelAttribute M_DTO member) throws IOException {
        mav = msvc.M_Join(member);
        return mav;
    }
    // 로그인 페이지로 이동
    @RequestMapping(value = "/M_LoginForm", method = RequestMethod.GET)
    public String M_LoginForm() {
        return "M_Login";
    }

    // 회원 목록
    @RequestMapping(value = "/M_List", method = RequestMethod.GET)
    public ModelAndView M_List(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(value = "limit", required = false, defaultValue = "5") int limit) {
        mav = msvc.M_List(page, limit);
        return mav;
    }

    // 회원 상세
    @RequestMapping(value = "/M_View", method = RequestMethod.GET)
    public ModelAndView M_View(@RequestParam("MID") String MID) {
        mav = msvc.M_View(MID);
        return mav;
    }

    // 회원 삭제
    @RequestMapping(value = "/M_Delete", method = RequestMethod.GET)
    public ModelAndView M_Delete(@RequestParam("MID") String MID) {
        mav = msvc.M_Delete(MID);
        session.invalidate();
        /*관리자가 삭제한 경우, 로그인이 풀려버린다.*/
//        if(session.loginId != null){
//            session.invalidate();
//        } else(session.loginId == "admin"){
//            session.getMaxInactiveInterval();
//        }
        return mav;
    }

    // 회원 수정 페이지로 이동
    @RequestMapping(value = "/M_ModiForm", method = RequestMethod.GET)
    public ModelAndView M_ModiForm(@RequestParam("MID") String MID) {
        mav = msvc.M_ModiForm(MID);
        return mav;
    }

    // 회원 수정
    @RequestMapping(value = "/M_Modify", method = RequestMethod.POST)
    public ModelAndView M_Modify(@ModelAttribute M_DTO member) throws IOException {
        mav = msvc.M_Modify(member);
        return mav;
    }

    // 로그인
    @RequestMapping(value = "/M_Login", method = RequestMethod.POST)
    public ModelAndView M_Login(@ModelAttribute M_DTO member) {
        mav = msvc.M_Login(member);
        return mav;
    }

    // 로그아웃
    @RequestMapping(value = "/M_logout", method = RequestMethod.GET)
    public String M_Logout() {
        session.invalidate();
        return "index";
    }

}
