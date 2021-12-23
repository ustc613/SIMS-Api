package com.simsapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto extends BaseDto{
    private Integer id;
    private Integer schoolid;
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    private String username;
    private String password;
    private String schoolname;
}
