package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("review")
public class R_DTO {

    private int RNUM;               // 번호
    private int RPRTNUM;            // 등록한 상품의 분류 번호
    private int RPRNUM;             // 등록한 상품의 번호
    private String RMID;            // 리뷰 작성 회원 아이디
    private String RCONTENT;        // 내용
    private Date RDATE;             // 작성일

}
