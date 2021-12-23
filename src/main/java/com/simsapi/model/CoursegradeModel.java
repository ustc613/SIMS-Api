package com.simsapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursegradeModel {
    private Integer courseid;
    private Integer stuid;
    private Integer grade;
    private Double average;
}
