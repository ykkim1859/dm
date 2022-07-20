package com.sdk.dm.dao;

import com.sdk.dm.dto.R_DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface R_DAO {

        // 작성
        int R_Write(R_DTO review);

        // 목록
        List<R_DTO> R_List(int RPRNUM);

        // 수정
        int R_Modify(R_DTO review);

        // 삭제
        int R_Delete(R_DTO review);
    }

