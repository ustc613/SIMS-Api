package com.simsapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursegradeDto extends BaseDto{
    private Integer courseid;
    private Integer stuid;
    private Integer grade;
}
