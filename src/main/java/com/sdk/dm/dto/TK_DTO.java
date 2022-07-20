package com.sdk.dm.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("tk")
public class TK_DTO {
	private int PRTNUM;
	private int PRKNUM;
}
