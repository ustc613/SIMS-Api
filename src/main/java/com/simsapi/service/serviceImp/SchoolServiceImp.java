package com.simsapi.service.serviceImp;

import com.simsapi.mapper.SchoolMapper;
import com.simsapi.model.SchoolModel;
import com.simsapi.model.dto.SchoolDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImp implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public TableResult<SchoolModel> getSchool() {
        List<SchoolModel> schoolModels = schoolMapper.getAllSchool();
        TableResult<SchoolModel> tableResult = new TableResult<>();
        tableResult.setRows(schoolModels);
        tableResult.setTotalCount(schoolModels.size());
        return tableResult;
    }

    @Override
    public Boolean insertSchool(SchoolDto schoolDto) {
        return schoolMapper.insertSchool(schoolDto);
    }
}
