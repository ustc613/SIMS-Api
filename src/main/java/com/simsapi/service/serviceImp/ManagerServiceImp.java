package com.simsapi.service.serviceImp;

import com.simsapi.mapper.ManagerMapper;
import com.simsapi.model.ManagerModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImp implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public TableResult<ManagerModel> getAllManagers(ManagerDto managerDto) {
        TableResult<ManagerModel> result = new TableResult<>();
        List<ManagerModel> managerModels = managerMapper.selectAllManagers(managerDto);
        result.setRows(managerModels);
        result.setTotalCount(managerMapper.selectCount());
        result.setPageCount(managerDto.getPageSize());
        return  result;
    }
}
