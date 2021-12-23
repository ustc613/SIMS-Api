package com.simsapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerModel {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String phone;
    private Integer role;
    private Integer schoolid;
}
