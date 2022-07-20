package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("game")
public class G_DTO {

    private String GMID;           // 게임한 회원 아이디
    private String GRESULT;        // 게임 결과
    private Date GDATE;            // 게임 실행 날짜

}
