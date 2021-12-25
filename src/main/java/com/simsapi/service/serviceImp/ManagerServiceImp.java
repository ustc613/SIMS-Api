package com.simsapi.service.serviceImp;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.simsapi.mapper.ManagerMapper;
import com.simsapi.mapper.SchoolMapper;
import com.simsapi.model.ManagerModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.dto.SchoolDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.ManagerService;
import com.simsapi.utils.StpManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImp implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    SchoolMapper schoolMapper;


    @Override
    public SaResult login(ManagerDto managerDto) {
        Integer id = managerMapper.selectIdForLogin(managerDto);
        //没有查询到 登陆失败
        if (id == null) {
            return SaResult.error("登录失败：账号或密码错误");
        } else {
            StpManagerUtil.login(id);
            return new SaResult(200, "登录成功", StpUtil.getTokenInfo());
        }
    }

    @Override
    public TableResult<ManagerModel> getAllManagers() {
        TableResult<ManagerModel> result = new TableResult<>();
        List<ManagerModel> managerModels = managerMapper.selectAllManagers();
        result.setRows(managerModels);
        result.setTotalCount(managerMapper.selectCount());
        return result;
    }


    @Override
    public Boolean insertManager(ManagerDto managerDto) {
        managerDto.setSchoolid(schoolMapper.selectSchoolId(managerDto.getSchoolname()));
        return managerMapper.insertManager(managerDto);
    }
}
