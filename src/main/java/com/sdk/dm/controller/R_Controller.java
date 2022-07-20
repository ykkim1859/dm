package com.sdk.dm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdk.dm.dto.R_DTO;
import com.sdk.dm.service.R_Service;

@Controller
public class R_Controller {
    // Service 연결
    @Autowired
    private R_Service rsvc;

    // 객체 생성
    List<R_DTO> REVIEWLIST = new ArrayList<R_DTO>();

    // 목록
    @PostMapping("/R_List")
    public @ResponseBody List<R_DTO> R_List(@RequestParam(value = "RPRNUM", required = true) int RPRNUM) {
        REVIEWLIST = rsvc.R_List(RPRNUM);
        return REVIEWLIST;
    }

    // 작성
    @PostMapping("/R_Write")
    public @ResponseBody List<R_DTO> R_Write(@ModelAttribute R_DTO review) {
        System.out.println("[1] controller : " + review);
        REVIEWLIST = rsvc.R_Write(review);
        return REVIEWLIST;
    }

    // 수정
    @PostMapping("/R_Modify")
    public @ResponseBody List<R_DTO> R_Modify(@ModelAttribute R_DTO review){
        System.out.println("[1] controller : " + review);
        REVIEWLIST = rsvc.R_Modify(review);
        System.out.println("[5] controller : " + REVIEWLIST);
        return REVIEWLIST;
    }

    // 삭제
    @PostMapping("/R_Delete")
    public @ResponseBody List<R_DTO> R_Delete(@ModelAttribute R_DTO review) {
        System.out.println("[1] Controller : " + review);
        REVIEWLIST = rsvc.R_Delete(review);
        return REVIEWLIST;
    }


    }