package com.sdk.dm.dao;

import com.sdk.dm.dto.PR_DTO;
import com.sdk.dm.dto.TK_DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PR_DAO {
	// 상품 등록
    int PR_Write(PR_DTO product);
    // 상품 목록
    List<PR_DTO> PR_List(TK_DTO tk);
    // 상품 상세
    PR_DTO PR_View(int PRNUM);
    // 상품 수정
    int PR_Modify(PR_DTO product);
    // 상품 삭제
    int PR_Delete(int PRNUM);

    ///////////////////////////////////////////////////// 회원 /////////////////////////////////////////////////////
    
    // 상품 목록
	List<PR_DTO> MPR_List(TK_DTO tk);
	// 상품 상세
	PR_DTO MPR_View(int PRNUM);
}
