package com.sdk.dm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sdk.dm.dto.B_DTO;

@Mapper
public interface B_DAO {
	// 게시글 등록
	int B_Write(B_DTO board);
	// 게시글 갯수
	int B_Count();
	// 게시글 목록
	List<B_DTO> B_List(String BGROUP);
	// 게시글 상세
	B_DTO B_View(int BNUM);
	// 게시글 수정
	int B_Modify(B_DTO board);
	// 게시글 삭제
	int B_Delete(int BNUM);
	// 조회수 증가
	void B_Hit(int BNUM);
}
