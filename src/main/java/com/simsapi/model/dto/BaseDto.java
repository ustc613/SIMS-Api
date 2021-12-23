package com.simsapi.model.dto;

import lombok.Data;

@Data
public class BaseDto {
    private Integer pageNow;
    private Integer pageSize=10;

    public Integer getStart() {
        if(pageNow==null||pageSize==null){

        }
        return (pageNow-1)*pageSize;
    }
}
