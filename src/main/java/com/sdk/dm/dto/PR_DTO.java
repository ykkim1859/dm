package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Data
@Alias("product")
public class PR_DTO {
    private int PRNUM;               // 번호
    private String PRNAME;           // 이름
    private int PRPRICE;             // 가격
    private String PRCONTENT;        // 설명
    private String PRFILENAME;       // 사진 이름
    private MultipartFile PRFILE;    // 사진
    private int PRTNUM;              // 분류 번호 (술, 안주, 기타)
    private int PRKNUM;              // 종류 번호 (와인, 막걸리, 안주 등)
    private String TNAME;            // 분류명
    private String KNAME;            // 종류명
}
