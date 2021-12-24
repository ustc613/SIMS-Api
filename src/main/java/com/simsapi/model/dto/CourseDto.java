package com.simsapi.model.dto;

import lombok.Data;

@Data
public class CourseDto extends BaseDto{
    private Integer id;
    private Integer schoolid;
    private String name;
    private String teachername;
}
