package com.simsapi.service;

import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.StudentPersonalResult;
import com.simsapi.model.res.TableResult;


public interface StudentService {

    SaResult login(StudentDto studentDto);

    /**
     * 教育局管理员查看所有的学生
     * @param studentDto
     * @return
     */
    TableResult<StudentModel> selectAllStudent(StudentDto studentDto);

    /**
     * 学生个人信息主页
     * @param studentDto
     * @return
     */
    StudentPersonalResult<StudentModel, CoursegradeModel>selectPersonStudent(StudentDto studentDto);
}
