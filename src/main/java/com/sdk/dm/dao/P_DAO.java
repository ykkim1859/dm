package com.sdk.dm.dao;

import java.util.List;

import com.sdk.dm.dto.P_DTO;
import org.apache.ibatis.annotations.Mapper;

import com.sdk.dm.dto.CA_DTO;
import com.sdk.dm.dto.M_DTO;
import com.sdk.dm.dto.S_DTO;

@Mapper
public interface P_DAO {

	// 카트를 가지고 작성 폼으로 이동
	List<CA_DTO> P_WriteForm(String CAMID);

	// 포인트 잔액 조회
	M_DTO M_Total(String MID);

	// 가맹점 조회
	List<S_DTO> PS_List();

	// 결제내역 저장
	int P_Write(P_DTO pay);

	// 결제내역 상세 : 회원
	List<P_DTO> MP_List(String PMID);

	// 결제내역 취소 : 회원
	int MP_Delete(int PNUM);

	// 결제내역 목록 : 관리자
	List<P_DTO> P_List();

	// 회원별 결제내역 상세 : 관리자
	P_DTO P_View(String PMID);
}
