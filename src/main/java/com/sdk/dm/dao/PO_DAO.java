package com.sdk.dm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sdk.dm.dto.G_DTO;
import com.sdk.dm.dto.POG_DTO;
import com.sdk.dm.dto.PO_DTO;

@Mapper
public interface PO_DAO {
    List<G_DTO> PO_Game(String gmid);

    int PO_Write(POG_DTO pointgame);

    void PO_Total(POG_DTO pointgame);

    List<PO_DTO> PO_List(String MID);

   int PT_Total(String MID);

}