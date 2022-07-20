package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Alias("board")
public class B_DTO {

    private int BNUM;                   // 번호
    private String BGROUP;              // 게시글 분류
    private String BMID;                // 작성자 아이디
    private String BTITLE;              // 제목
    private String BCONTENT;            // 내용
    private Date BDATE;                 // 작성일
    private int BHIT;                   // 조회수
    private String BFILENAME;           // 첨부파일 이름
    private MultipartFile BFILE;        // 첨부파일

}
