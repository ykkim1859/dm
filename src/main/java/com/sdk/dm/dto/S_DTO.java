package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("shop")
public class S_DTO {

    private int SNUM;           // 번호
    private String SNAME;       // 이름
    private String SADDR;       // 주소
    private String SPHONE;      // 연락처
    private String SBOSS;       // 점주 이름

    private String addr1;
    private String addr2;
    private String addr3;

}
