package com.simsapi.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.ManagerModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.ManagerService;
import com.simsapi.utils.StpManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/login")
    public SaResult login(@RequestBody ManagerDto managerDto){
        return managerService.login(managerDto);
    }

    @PostMapping("/logout")
    @SaCheckLogin(type = "manager")
    public SaResult logout(){
        StpManagerUtil.logout();
        return SaResult.ok("下线成功");
    }

    @PostMapping("")
    @SaCheckLogin(type = "manager")
    @SaCheckRole(type = "manager",value = "super")
    public TableResult<ManagerModel> getAllManagers(@RequestBody ManagerDto managerDto){
        return managerService.getAllManagers(managerDto);
    }
}
