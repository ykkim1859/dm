package com.sdk.dm.controller;

import com.sdk.dm.dto.*;
import com.sdk.dm.service.PO_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PO_Controller {
    // 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
    // 2. 서비스 연결
    @Autowired
    private PO_Service posvc;
    // 3. id 객체 생성
    List<G_DTO> game = new ArrayList<G_DTO>();

    // 포인트 적립 페이지로 이동 - 관리자
    @GetMapping("/PO_WriteForm")
    public String PO_WriteForm(){
        return "PO_WriteForm";
    }
    // 게임한 회원 아이디 조회 - 관리자
    @PostMapping("/PO_Game")
    public @ResponseBody List<G_DTO> PO_Game(@RequestParam("GMID") String GMID){
        game = posvc.PO_Game(GMID);
        return game;
    }
    // 포인트 적립 (내역) - 관리자
    @PostMapping("/PO_Write")
    public ModelAndView PO_Write(@ModelAttribute POG_DTO pointgame){
        mav = posvc.PO_Write(pointgame);
        return mav;
    }
    // 포인트 적립 내역 - 회원
    @GetMapping("/PO_List")
    public ModelAndView PO_List(@RequestParam("MID") String MID){
        mav = posvc.PO_List(MID);
        return mav;
    }
    // 포인트 잔액 조회 - 회원
    @PostMapping("/PT_Total")
    public @ResponseBody int PT_Total(@RequestParam("MID") String MID) {
       int total = posvc.PT_Total(MID);
       return total;
    }


}