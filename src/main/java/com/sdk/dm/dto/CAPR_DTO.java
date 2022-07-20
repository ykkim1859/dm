package com.sdk.dm.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("capr")
public class CAPR_DTO {
	private int CANUM;				 // 상품 번호
	private String CAMID;            // 회원 아이디
    private int CACOUNT;             // 수량
    private int CATOTAL;             // 총액
    private int CAPRICE;             // 단가
    private int PRNUM;               // 번호
    private String PRNAME;           // 이름
    private String PRCONTENT;		 // 상품 설명
    private String PRFILENAME;       // 사진 이름
    private int PRTNUM;              // 분류 번호 (술, 안주, 기타)
    private int PRKNUM;              // 종류 번호 (와인, 막걸리, 안주 등)
}
