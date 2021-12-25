package com.simsapi.service;

import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.CourseModel;
import com.simsapi.model.dto.CourseDto;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.dto.SchoolDto;
import com.simsapi.model.res.TableResult;

import java.util.List;

public interface CourseService {
    /**
     * 学校管理员查询所有课程
     * @param managerDto
     * @return
     */
    TableResult<CourseModel> selectAllcoruse(ManagerDto managerDto);

    /**
     * super管理员可以看到所有课程
     * @param schoolDto
     * @return
     */
    TableResult<CourseModel> selectAllcoruseForSuper(SchoolDto schoolDto);

    SaResult insertCourseForManager(CourseDto courseDto);

    SaResult updateCourse(CourseDto courseDto);

}
