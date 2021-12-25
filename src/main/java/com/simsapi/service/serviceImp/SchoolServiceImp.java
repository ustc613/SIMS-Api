package com.simsapi.service.serviceImp;

import cn.dev33.satoken.util.SaResult;
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

    @Override
    public SaResult updateSchool(SchoolDto schoolDto) {
        Boolean success = false;
        success = schoolMapper.updateSchool(schoolDto);
        if(success){
            return SaResult.ok("更新成功");
        }else {
            return SaResult.error("更新失败");
        }
    }
}
