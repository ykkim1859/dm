package com.sdk.dm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdk.dm.dao.C_DAO;
import com.sdk.dm.dto.C_DTO;

@Service
public class C_Service {
	// DAO 연결
	@Autowired
	private C_DAO cdao;
	// 댓글 객체 생성
	List<C_DTO> COMMLIST = new ArrayList<C_DTO>();
	
	// 댓글 목록
	public List<C_DTO> C_List(int cbNum) {
		COMMLIST = cdao.C_List(cbNum);
		return COMMLIST;
	}
	
	// 댓글 작성
	public List<C_DTO> C_Write(C_DTO comm) {
		int result = cdao.C_Write(comm);
		if(result > 0) {
			COMMLIST = cdao.C_List(comm.getCBNUM());
		} else {
			COMMLIST = null;
		}
		return COMMLIST;
	}
	
	// 댓글 수정
	public List<C_DTO> C_Modify(C_DTO comm) {
		System.out.println("[2] service : " + comm);
		int result = cdao.C_Modify(comm);
		System.out.println("[4] service : " + result);
		if(result > 0) {
			COMMLIST = cdao.C_List(comm.getCBNUM());
		} else {
			COMMLIST = null;
		}
		return COMMLIST;
	}
	
	// 댓글 삭제
	public List<C_DTO> C_Delete(C_DTO comm) {
		int result = cdao.C_Delete(comm);
		if(result > 0) {
			COMMLIST = cdao.C_List(comm.getCBNUM());
		} else {
			COMMLIST = null;
		}
		return COMMLIST;
	}
}
