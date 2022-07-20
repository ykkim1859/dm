package com.sdk.dm.dao;

import com.sdk.dm.dto.S_DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface S_DAO {
	// 가맹점 등록
    int S_Write(S_DTO shop);
    // 가맹점 목록
    List<S_DTO> S_List();
    // 가맹점 상세
    S_DTO S_View(int SNUM);
    // 가맹점 수정
    int S_Modify(S_DTO shop);
    // 가맹점 삭제
    int S_Delete(int SNUM);
}
