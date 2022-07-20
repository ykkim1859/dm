package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("pay")
public class P_DTO {

    private int PNUM;           // 번호
    private String PMID;        // 결제 회원 아이디
    private Date PDATE;         // 결제 날짜
    private int PSNUM;          // 가맹점 번호
    private int PCANUM;         // 장바구니에 담긴 상품 번호
    private int PTOTAL;         // 총 결제금액
    private String PRFILENAME;  // 상품사진 파일명
    private String PRNAME;      // 상품명
    private String SNAME;       // 가맹점명
}
