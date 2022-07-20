package com.sdk.dm.dao;

import com.sdk.dm.dto.M_DTO;
import com.sdk.dm.dto.PAGE_DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface M_DAO {
    // 회원 등록
    int M_Join(M_DTO member);
    // 회원 목록
    List<M_DTO> M_List(PAGE_DTO paging);
    // 회원 상세
    M_DTO M_View(String MID);
    // 회원 삭제
    int M_Delete(String MID);
    // 로그인
    String M_Login(M_DTO member);
    // 회원 갯수
    int M_Count();
    // 회원 수정
    int M_Modify(M_DTO member);
}
