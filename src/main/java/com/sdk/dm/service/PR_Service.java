package com.sdk.dm.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.dm.dao.PR_DAO;
import com.sdk.dm.dto.PR_DTO;
import com.sdk.dm.dto.TK_DTO;

@Service
public class PR_Service {
	// 1. ModelAndView 객체 생성
    private ModelAndView mav = new ModelAndView();
	// 2. 서비스 연결
    @Autowired
    private PR_DAO prdao;

    // 상품 등록
    public ModelAndView PR_Write(PR_DTO product) throws IOException {

        MultipartFile PRFILE = product.getPRFILE();

        String originalFileName = PRFILE.getOriginalFilename();

        String uuid = UUID.randomUUID().toString().substring(0, 8);

        String PRFILENAME = uuid + "_" + originalFileName;

        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/PRFILE");
        String savePath = path + "/" + PRFILENAME;

        if (!PRFILE.isEmpty()) {
            product.setPRFILENAME(PRFILENAME);
            PRFILE.transferTo(new File(savePath));
        } else {
            product.setPRFILENAME("default.png");
        }

        int result = prdao.PR_Write(product);

        if (result > 0) {
            mav.setViewName("redirect:/PR_List?PRTNUM=1&PRKNUM=1");
        } else {
            mav.setViewName("redirect:/PR_WriteForm");
        }

        return mav;
    }

    // 상품 목록
    public ModelAndView PR_List(int PRTNUM, int PRKNUM) {
        // PRTNUM(상품 분류), PRKNUM(종류 : 술에만 해당)
        // ex : 술이면 1, 와인이면 1 / 안주면 2, 6
        TK_DTO tk = new TK_DTO();
        tk.setPRTNUM(PRTNUM);
        tk.setPRKNUM(PRKNUM);
        List<PR_DTO> product = prdao.PR_List(tk);
        mav.setViewName("PR_List");
        mav.addObject("PR_List", product);
        return mav;
    }

    // 상품 상세
    public ModelAndView PR_View(int PRNUM) {
        PR_DTO product = prdao.PR_View(PRNUM);

        mav.setViewName("PR_View");
        mav.addObject("product", product);

        return mav;

    }

    // 상품 수정 페이지로 이동
    public ModelAndView PR_ModiForm(int PRNUM) {

        PR_DTO product = prdao.PR_View(PRNUM);

        mav.setViewName("PR_ModiForm");
        mav.addObject("product", product);

        return mav;
    }

    // 상품 수정
    public ModelAndView PR_Modify(PR_DTO product) throws IOException {
        System.out.println("[2] service : " + product);
        MultipartFile PRFILE = product.getPRFILE();

        String originalFileName = PRFILE.getOriginalFilename();

        String uuid = UUID.randomUUID().toString().substring(0, 8);

        String PRFILENAME = uuid + "_" + originalFileName;

        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/PRFILE");
        String savePath = path + "/" + PRFILENAME;

        if (!PRFILE.isEmpty()) {
            product.setPRFILENAME(PRFILENAME);
            PRFILE.transferTo(new File(savePath));
        } else {
            product.setPRFILENAME("default.png");
        }

        int result = prdao.PR_Modify(product);
        System.out.println("[4] Service : " + result);
        if (result > 0) {
            mav.setViewName("redirect:/PR_View?PRNUM="+product.getPRNUM());
        } else {
            mav.setViewName("index");
        }

        return mav;
    }

    // 상품 삭제
    public ModelAndView PR_Delete(int PRNUM) {

        int result = prdao.PR_Delete(PRNUM);

        System.out.println("[2] service : " + result);

        if(result>0){
            mav.setViewName("index");
        } else{
            mav.setViewName("index");
        }

        System.out.println("[2] service : " + mav);

        return mav;
    }

	
    
    ///////////////////////////////////////////////////// 회원 /////////////////////////////////////////////////////
    
    // 상품 목록
    public ModelAndView MPR_List(int PRTNUM, int PRKNUM) {
    	TK_DTO tk = new TK_DTO();
        tk.setPRTNUM(PRTNUM);
        tk.setPRKNUM(PRKNUM);
        List<PR_DTO> product = prdao.MPR_List(tk);
        mav.setViewName("MPR_List");
        mav.addObject("product", product);
		return mav;
	}
    
    // 상품 상세
	public ModelAndView MPR_View(int PRNUM) {
		PR_DTO product = prdao.MPR_View(PRNUM);
        mav.setViewName("MPR_View");
        mav.addObject("product", product);
		return mav;
	}
}
