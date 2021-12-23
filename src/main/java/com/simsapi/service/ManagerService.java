package com.simsapi.service;

import com.simsapi.model.ManagerModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.res.TableResult;

public interface ManagerService {
    TableResult<ManagerModel> getAllManagers(ManagerDto managerDto);
}
