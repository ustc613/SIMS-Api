package com.simsapi.service.serviceImp;

import com.simsapi.mapper.CourseMapper;
import com.simsapi.mapper.CoursegradeMapper;
import com.simsapi.mapper.ManagerMapper;
import com.simsapi.model.CourseModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.dto.SchoolDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 根据manager传回来的managerid查询出schoolid再根据schoolid查询所有课程
     * @param managerDto
     * @return
     */
    @Override
    public TableResult<CourseModel> selectAllcoruse(ManagerDto managerDto) {
        Integer schoolid = managerMapper.selectSchoolid(managerDto.getId());
        List<CourseModel> courseModels = courseMapper.selectAllCoruse(schoolid);
        TableResult<CourseModel> tableResult = new TableResult<>();
        tableResult.setRows(courseModels);
        tableResult.setTotalCount(courseModels.size());
        return tableResult;
    }

    @Override
    public TableResult<CourseModel> selectAllcoruseForSuper(SchoolDto schoolDto) {
        List<CourseModel> courseModels = courseMapper.selectAllCoruse(schoolDto.getId());
        TableResult<CourseModel> tableResult = new TableResult<>();
        tableResult.setRows(courseModels);
        tableResult.setTotalCount(courseModels.size());
        return tableResult;
    }


}
