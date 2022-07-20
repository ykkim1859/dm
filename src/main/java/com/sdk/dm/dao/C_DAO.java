package com.sdk.dm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sdk.dm.dto.C_DTO;

@Mapper
public interface C_DAO {
	// 댓글 작성
	int C_Write(C_DTO comm);

	// 댓글 목록
	List<C_DTO> C_List(int cbNum);

	// 댓글 수정
	int C_Modify(C_DTO comm);

	// 댓글 삭제
	int C_Delete(C_DTO comm);
}
