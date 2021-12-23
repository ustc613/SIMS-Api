package com.simsapi.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.simsapi.model.ManagerModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.ManagerService;
import com.simsapi.utils.StpManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @ResponseBody
    @GetMapping("/login")
    public String login(){
        //此id测试用 实际是传过来的
        int loginID = 125;
        StpManagerUtil.login(loginID);
        return "成功";
    }

    @ResponseBody
    @GetMapping("/manager")
    @SaCheckRole(type = "manager",value = "super")
    public TableResult<ManagerModel> getAllManagers(@RequestBody ManagerDto managerDto){
        return managerService.getAllManagers(managerDto);
    }
}
