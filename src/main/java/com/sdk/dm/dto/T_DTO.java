package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("T")
public class T_DTO {

    private int TNUM;           // 번호
    private String TTYPE;       // 분류 (술, 안주, 기타용품)
}
