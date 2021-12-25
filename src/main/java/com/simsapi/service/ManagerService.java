package com.simsapi.service;

import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.ManagerModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.res.TableResult;

public interface ManagerService {
    TableResult<ManagerModel> getAllManagers();
    SaResult login(ManagerDto managerDto);

    Boolean insertManager(ManagerDto managerDto);

    /**
     * 更新管理员信息
     * @param managerDto
     * @return
     */
    SaResult updateManager(ManagerDto managerDto);
}
