package com.sdk.dm.controller;

import com.sdk.dm.dto.G_DTO;
import com.sdk.dm.service.G_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class G_Controller {

    G_DTO gdto = new G_DTO();

    @Autowired
    private G_Service gsvc;

    @PostMapping("G_Write")
    public @ResponseBody G_DTO G_Write(@RequestParam("GMID") String GMID, @RequestParam("GRESULT") String GRESULT){
        System.out.println("[1] " + GMID + GRESULT);
    	gdto = gsvc.G_Write(GMID, GRESULT);
    	System.out.println("[5] : " + gdto);
        return gdto;
    }

}
