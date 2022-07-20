package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("goods")
public class GOODS_DTO {

    private int FNUM;     // 안주 번호
    private String FNAME; // 안주 이름
}
