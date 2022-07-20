package com.sdk.dm.service;

import com.sdk.dm.dao.M_DAO;
import com.sdk.dm.dto.M_DTO;
import com.sdk.dm.dto.PAGE_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class M_Service {
	// 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
	// 2. 서비스 연결
    @Autowired
    private M_DAO mdao;
    // 3. 로그인을 사용하기 위한 session 연결
    @Autowired
    private HttpSession session;

	// 회원 등록
    public ModelAndView M_Join(M_DTO member) throws IOException {
        // 1. 파일 처리
        MultipartFile MPROFILE = member.getMPROFILE();
        String originalFileName = MPROFILE.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        String MPROFILENAME = uuid + "_" + originalFileName;
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/MPROFILE");
        String savePath = path + "/" + MPROFILENAME;
        if (!MPROFILE.isEmpty()) {
            member.setMPROFILENAME(MPROFILENAME);
            MPROFILE.transferTo(new File(savePath));
        } else {
            member.setMPROFILENAME("default.png");
        }
        // 2. 주소 처리
        String addr1 = member.getAddr1();
        String addr2 = member.getAddr2();
        String addr3 = member.getAddr3();

        String MADDR = "(" + addr1 + ")" + addr2 + " " + addr3;

        if (!addr1.equals("")) {
            member.setMADDR(MADDR);
        }
        // 3. 결과에 따른 페이지 이동
        int result = mdao.M_Join(member);
        if (result > 0) {
            // 회원가입성공 result = 1
            mav.setViewName("M_Login");
        } else {
            // 회원가입실패 result=0
            mav.setViewName("M_JoinForm");
        }
        return mav;
    }
    
    // 회원 목록
    public ModelAndView M_List(int page, int limit) {
        // 1. 회원 목록 페이징 처리
        int block = 5;
        int M_Count = mdao.M_Count();
        int startRow = (page - 1) * limit + 1;
        int endRow = page * limit;
        int maxPage = (int)(Math.ceil((double) M_Count / limit));
        int startPage = (((int)(Math.ceil((double) page / block)))- 1) * block + 1;
        int endPage = startPage + block - 1;
        if(endPage > maxPage) {
            endPage = maxPage;
        }

        // 2. 페이징 객체 생성 및 값 대입
        PAGE_DTO paging = new PAGE_DTO();

        paging.setPage(page);
        paging.setEndPage(endPage);
        paging.setMaxPage(maxPage);
        paging.setStartPage(startPage);
        paging.setLimit(limit);
        paging.setEndRow(endRow);
        paging.setStartRow(startRow);

        List<M_DTO> M_List = mdao.M_List(paging);
        mav.setViewName("M_List");
        mav.addObject("paging", paging);
        mav.addObject("M_List", M_List);

        return mav;
    }
    
    // 회원 상세
    public ModelAndView M_View(String MID) {
        M_DTO member = mdao.M_View(MID);
        mav.setViewName("M_View");
        mav.addObject("member", member);
        return mav;
    }
    // 회원 탈퇴
    public ModelAndView M_Delete(String MID) {
        int result = mdao.M_Delete(MID);
        mav.setViewName("index");
        return mav;
    }
    
    // 회원 수정 페이지로 이동
    public ModelAndView M_ModiForm(String MID) {
        M_DTO member = mdao.M_View(MID);
        mav.setViewName("M_ModiForm");
        mav.addObject("member", member);
        return mav;
    }

    // 회원 수정
    public ModelAndView M_Modify(M_DTO member) throws IOException {
        // 1. 파일 처리
        MultipartFile MPROFILE = member.getMPROFILE();
        String originalFileName = MPROFILE.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        String MPROFILENAME = uuid + "_" + originalFileName;
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/MPROFILE");
        String savePath = path + "/" + MPROFILENAME;
        if (!MPROFILE.isEmpty()) {
            member.setMPROFILENAME(MPROFILENAME);
            MPROFILE.transferTo(new File(savePath));
        } else {
            member.setMPROFILENAME("default.png");
        }
        // 2. 주소 처리
        String addr1 = member.getAddr1();
        String addr2 = member.getAddr2();
        String addr3 = member.getAddr3();

        String MADDR = "(" + addr1 + ")" + addr2 + " " + addr3;

        if (!addr1.equals("")) {
            member.setMADDR(MADDR);
        }
        // 3. 결과에 따른 페이지 이동
        int result = mdao.M_Modify(member);
        if (result > 0) {
            // 회원가입성공 result = 1
            mav.setViewName("index");
        } else {
            // 회원가입실패 result=0
            mav.setViewName("M_JoinForm");
        }
        return mav;
    }
    
    // 회원 로그인
    public ModelAndView M_Login(M_DTO member) {
        String loginId = mdao.M_Login(member);
        if (loginId != null) {
            session.setAttribute("loginId", loginId);
            mav.setViewName("index");
        } else {
            mav.setViewName("M_Login");
        }
        return mav;
    }


}
