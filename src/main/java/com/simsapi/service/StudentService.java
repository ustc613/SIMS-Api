package com.simsapi.service;

import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.ManagerDto;
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

    /**
     * 学校管理员根据学校id查询该校的所有学生
     * @param managerDto
     * @return
     */
    TableResult<StudentModel> getSchoolStudent(ManagerDto managerDto);

    /**
     * 学校管理员增加学生
     * @param studentDto
     * @return
     */
    SaResult insertStudent(StudentDto studentDto);

    /**
     * 学校管理员删除学生
     * @param studentDto
     * @return
     */
    SaResult deleteStudentById(StudentDto studentDto);

    /**
     * 更新学生信息
     * @param studentDto
     * @return
     */
    SaResult upadteStudent(StudentDto studentDto);
}
