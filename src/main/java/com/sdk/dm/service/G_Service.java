package com.sdk.dm.service;

import com.sdk.dm.dao.G_DAO;
import com.sdk.dm.dto.G_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class G_Service {

    G_DTO gdto = new G_DTO();

    @Autowired
    private G_DAO gdao;
    
    public G_DTO G_Write(String GMID, String GRESULT) {
    	System.out.println("[2] : " + GMID + GRESULT);
    	gdto.setGMID(GMID);
    	gdto.setGRESULT(GRESULT);
    	int result = gdao.G_Write(GMID, GRESULT);
        System.out.println("[4] : " + result);
        if(result > 0) {
        	System.out.println("성공");
        } else {
        	System.out.println("실패");
        }
        return gdto;
    }
}
