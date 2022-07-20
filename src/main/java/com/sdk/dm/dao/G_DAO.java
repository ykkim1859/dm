package com.sdk.dm.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface G_DAO {
	int G_Write(String GMID, String GRESULT);
}
