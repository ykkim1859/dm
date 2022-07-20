package com.sdk.dm.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("mpoint")
public class MPOINT_DTO {

    private String POMID;
    private String POGRESULT;
    private Date PODATE;
    private String POPAY;
    private int POGET;
    private int POUSE;
    private int MPOINT;

}
