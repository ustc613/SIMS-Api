package com.simsapi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseModel {
    private Integer id;
    private Integer schoolid;
    private String schoolname;
    private String name;
    private String teachername;
    //新加的字段用于求课程平均分
    private String average;
}
