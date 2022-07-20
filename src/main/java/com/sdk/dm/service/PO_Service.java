package com.sdk.dm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dao.PO_DAO;
import com.sdk.dm.dto.G_DTO;
import com.sdk.dm.dto.POG_DTO;
import com.sdk.dm.dto.PO_DTO;

@Service
public class PO_Service {
    // 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
    // 2. DAO 연결
    @Autowired
    private PO_DAO podao;
    // 3. id 객체 생성
    List<G_DTO> game = new ArrayList<G_DTO>();

    // 게임한 회원 아이디 조회 - 관리자
    public List<G_DTO> PO_Game(String GMID) {
        game = podao.PO_Game(GMID);
        return game;
    }
    // 포인트 적립 (내역) - 관리자
    public ModelAndView PO_Write(POG_DTO pointgame) {
        podao.PO_Total(pointgame);
        int result = podao.PO_Write(pointgame);
        if (result > 0) {
            mav.setViewName("redirect:/M_List");
        } else {
            mav.setViewName("redirect:/PO_WriteForm");
        }
        return mav;
    }
    // 포인트 적립 내역 - 회원
    public ModelAndView PO_List(String MID) {
        List<PO_DTO> point = podao.PO_List(MID);
        mav.setViewName("PO_List");
        mav.addObject("point",point);
        return mav;
    }
    // 포인트 잔액 조회 : 회원
   public int PT_Total(String MID) {
      int total = podao.PT_Total(MID);
      return total;
   }
}