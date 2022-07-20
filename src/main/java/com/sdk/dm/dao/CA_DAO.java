package com.sdk.dm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sdk.dm.dto.CAPR_DTO;
import com.sdk.dm.dto.CA_DTO;

@Mapper
public interface CA_DAO {
	// 장바구니 저장
	int CA_Write(CA_DTO cart);
	// 장바구니 목록
	List<CAPR_DTO> CA_List(String CAMID);
	// CA_PRNUM(상품번호) 검색
	Integer CA_PRNUM(int CAPRNUM);
	// 장바구니 수량 추가
	int CA_Add(CA_DTO cart);
	// 장바구니 수량 수정
	int CA_Modify(CA_DTO cart);
	// 상품에 대한 합계 리스트로 갖고 오기
	List<Integer> CA_Total(String cAMID);
	// 장바구니 전체 삭제
    int CA_DeleteAll(String CAMID);
    // 장바구니 삭제 (개별)
 	int CA_DeleteChoice(int CANUM);
	
}
