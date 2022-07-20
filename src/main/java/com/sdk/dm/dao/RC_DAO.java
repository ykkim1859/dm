package com.sdk.dm.dao;

import com.sdk.dm.dto.GOODS_DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RC_DAO {
	// 추천 등록 페이지로 이동
    List<GOODS_DTO> RC_WriteForm();
}
