package com.simsapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDto extends BaseDto{
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String phone;
    private Integer role;
    private Integer schoolid;
}
