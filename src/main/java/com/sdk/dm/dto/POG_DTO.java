package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("pointgame")
public class POG_DTO {

    private String GMID;
    private String GRESULT;
    private Date GDATE;
    private int POUSE;
    private int POGET;
    private String POPAY;
    private Date PODATE;
    private String POGRESULT;
    private String POMID;
    private String PTMID;
    private int PTTOTAL;
}
