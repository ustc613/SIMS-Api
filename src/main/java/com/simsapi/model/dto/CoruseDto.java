package com.simsapi.model.dto;

import lombok.Data;

@Data
public class CoruseDto extends BaseDto{
    private Integer id;
    private Integer schoolid;
    private String name;
    private String teachername;
}
