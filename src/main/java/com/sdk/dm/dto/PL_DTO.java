package com.sdk.dm.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("payList")
public class PL_DTO {
	private int PNUM;           // 번호
    private String PMID;        // 결제 회원 아이디
    private Date PDATE;         // 결제 날짜
    private String SNAME;		// 픽업 가맹점
    private int PTOTAL;			// 결제 총액
    private String PRNAME;		// 결제 상품이름
    private String PRFILENAME;	// 결제 상품사진
}
