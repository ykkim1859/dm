package com.sdk.dm.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("comm")
public class C_DTO {

    private int CNUM;               // 번호
    private int CBNUM;              // 댓글 다는 게시글 번호
    private String CBGROUP;         // 댓글 다는 게시글 분류
    private String CMID;            // 작성자 아이디
    private String CCONTENT;        // 내용
    private Date CDATE;             // 작성일
}
