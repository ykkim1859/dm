package com.sdk.dm.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dao.B_DAO;
import com.sdk.dm.dto.B_DTO;

@Service
public class B_Service {
	// 1. ModelAndView 객체 생성
	private ModelAndView mav = new ModelAndView();
	// 2. 서비스 연결
	@Autowired
	private B_DAO bdao;
	
	// 게시글 작성
	public ModelAndView B_Write(B_DTO board) throws IOException {
		System.out.println("[2] Service : " + board);
		// 1. 파일 처리
		MultipartFile BFILE = board.getBFILE();
        String originalFileName = BFILE.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        String BFILENAME = uuid + "_" + originalFileName;
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/BFILE");
        String savePath = path + "/" + BFILENAME;
        if (!BFILE.isEmpty()) {
        	board.setBFILENAME(BFILENAME);
            BFILE.transferTo(new File(savePath));
        } else {
        	board.setBFILENAME("default.png");
        }
		// 2. 결과에 따른 페이지 출력
		int result = bdao.B_Write(board);
		System.out.println("[4] Service : " + result);
		if(result > 0) {
			mav.setViewName("redirect:/B_List?BGROUP="+board.getBGROUP());
		} else {
			mav.setViewName("B_Write");
		}
		return mav;
	}
	
	// 게시글 목록
	public ModelAndView B_List(String BGROUP) {
		List<B_DTO> board = bdao.B_List(BGROUP);
		mav.setViewName("B_List");
		mav.addObject("board",board);
		return mav;
	}
	// 게시글 상세
	public ModelAndView B_View(int BNUM) {
		B_DTO board = bdao.B_View(BNUM);
		bdao.B_Hit(BNUM);
		mav.setViewName("B_View");
		mav.addObject("board", board);
		return mav;
	}
	
	// 게시글 수정 페이지 이동
	public ModelAndView B_ModiForm(int BNUM) {
		B_DTO board = bdao.B_View(BNUM);
		mav.setViewName("B_ModiForm");
		mav.addObject("board", board);
		return mav;
	}
	
	// 게시글 수정
	public ModelAndView B_Modify(B_DTO board) throws IOException {
		// 1. 파일 처리
		MultipartFile BFILE = board.getBFILE();
		String originalFileName = BFILE.getOriginalFilename();
		String uuid = UUID.randomUUID().toString().substring(0, 8);
		String BFILENAME = uuid + "_" + originalFileName;
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/BFILE");
        String savePath = path + "/" + BFILENAME;
        if (!BFILE.isEmpty()) {
        	board.setBFILENAME(BFILENAME);
            BFILE.transferTo(new File(savePath));
        } else {
        	board.setBFILENAME("default.png");
        }
		// 2. 결과에 따른 페이지 이동
		int result = bdao.B_Modify(board);
		if(result > 0) {
			mav.setViewName("redirect:/B_View?BNUM="+board.getBNUM());
		} else {
			mav.setViewName("B_ModiForm?BNUM="+board.getBNUM());
		}
		return mav;
	}
	
	// 게시글 삭제
	public ModelAndView B_Delete(int BNUM) {
		int result = bdao.B_Delete(BNUM);
		if(result > 0) {
			mav.setViewName("redirect:/B_List?BGROUP=notice");
		} else {
			mav.setViewName("redirect:/B_View?BNUM="+BNUM);
		}
		return mav;
	}
}
