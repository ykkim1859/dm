package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Alias("popup")
public class PU_DTO {

    private int PUNUM;              // 번호
    private String PUTITLE;         // 제목
    private String PUCONTENT;       // 내용
    private String PUFILENAME;      // 사진 이름
    private MultipartFile PUFILE;   // 사진
    private Date PUDATE;            // 기간
}
