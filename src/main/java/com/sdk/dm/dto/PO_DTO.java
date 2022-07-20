package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("point")
public class PO_DTO {

    private String POMID;           // 포인트 받은 회원 아이디
    private String POGRESULT;        // 적립 내역
    private Date PODATE;          // 적립일
    private String POPAY;           // 사용 내역
    private int POGET;              // 적립 포인트
    private int POUSE;             // 잔여 포인트
}
