package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("cart")
public class CA_DTO {
	private int CANUM;				// 장바구니번호
    private String CAMID;           // 회원 아이디
    private int CAPRNUM;			// 상품 번호
    private int CAPRTNUM;			// 상품 분류 번호
    private int CACOUNT;            // 수량
    private int CATOTAL;            // 총액
    private int CAPRICE;            // 단가
}
