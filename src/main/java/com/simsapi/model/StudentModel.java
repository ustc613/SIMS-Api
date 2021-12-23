package com.simsapi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentModel {
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
