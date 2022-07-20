package com.sdk.dm.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("member")
public class M_DTO {

    private String MID;                 // 아이디
    private String MPW;                 // 비밀번호
    private String MNAME;               // 이름
    private Date MBIRTH;              // 생년월일
    private String MEMAIL;              // 이메일
    private String MPHONE;              // 연락처
    private String MADDR;               // 주소
    private String MPROFILENAME;        // 프로필 사진 이름
    private MultipartFile MPROFILE;     // 프로필 사진
    private int MPOINT;                 // 포인트

    private String addr1;
    private String addr2;
    private String addr3;
}
