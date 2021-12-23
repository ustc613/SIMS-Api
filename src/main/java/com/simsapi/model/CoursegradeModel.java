package com.simsapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursegradeModel {
    //表内结构
    private Integer courseid;
    private Integer stuid;
    private Integer grade;
    //返回需要新加的记录
    private String coursename;
}
