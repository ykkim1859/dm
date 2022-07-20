package com.sdk.dm.service;

import com.sdk.dm.dao.R_DAO;
import com.sdk.dm.dto.R_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class R_Service {

        // DAO 연결
        @Autowired
        private R_DAO rdao;
        // 객체 생성
        List<R_DTO> REVIEWLIST = new ArrayList<R_DTO>();

        // 목록
        public List<R_DTO> R_List(int RPRNUM) {
            REVIEWLIST = rdao.R_List(RPRNUM);
            return REVIEWLIST;
        }

        // 작성
        public List<R_DTO> R_Write(R_DTO review) {
            System.out.println("[2] Service : " + review);
            int result = rdao.R_Write(review);
            System.out.println("[4] Service : " + result);
            if(result > 0) {
                REVIEWLIST = rdao.R_List(review.getRPRNUM());
            } else {
                REVIEWLIST = null;
            }
            return REVIEWLIST;
        }

        // 수정
        public List<R_DTO> R_Modify(R_DTO review) {
            System.out.println("[2] service : " + review);
            int result = rdao.R_Modify(review);
            System.out.println("[4] service : " + result);
            if(result > 0) {
                REVIEWLIST = rdao.R_List(review.getRPRNUM());
            } else {
                REVIEWLIST = null;
            }
            return REVIEWLIST;
        }

        // 삭제
        public List<R_DTO> R_Delete(R_DTO review) {
            int result = rdao.R_Delete(review);
            if(result > 0) {
                REVIEWLIST = rdao.R_List(review.getRPRNUM());
            } else {
                REVIEWLIST = null;
            }
            return REVIEWLIST;
        }
    }
