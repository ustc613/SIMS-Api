package com.simsapi.service.serviceImp;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.simsapi.mapper.CoursegradeMapper;
import com.simsapi.mapper.ManagerMapper;
import com.simsapi.mapper.SchoolMapper;
import com.simsapi.mapper.StudentMapper;
import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.StudentPersonalResult;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    CoursegradeMapper coursegradeMapper;

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public SaResult login(StudentDto studentDto) {
        Integer id = studentMapper.selectIdForLogin(studentDto);
        //没有查询到 登陆失败
        if(id == null){
            return SaResult.error("登录失败：账号或密码错误");
        } else {
            StpUtil.login(id);
            return SaResult.ok("登录成功");
        }
    }

    @Override
    public TableResult<StudentModel> selectAllStudent(StudentDto studentDto) {
        TableResult<StudentModel> tableResult = new TableResult<>();
        List<StudentModel> students = studentMapper.selectAllStudent(studentDto);
        Integer totalCount = studentMapper.selectCount(studentDto);
        tableResult.setRows(students);
        tableResult.setTotalCount(totalCount);
        tableResult.setPageCount(studentDto.getPageSize());
        return tableResult;
    }

    @Override
    public StudentPersonalResult<StudentModel, CoursegradeModel> selectPersonStudent(StudentDto studentDto) {
        List<StudentModel> students = studentMapper.selectPersonStudent(studentDto);
        List<CoursegradeModel> coursegrades = coursegradeMapper.selectGradeForStudent(studentDto);
        double average = 0;
        int sum = 0;
        for(CoursegradeModel coursegradeModel:coursegrades){
            sum+=coursegradeModel.getGrade();
        }
        average = sum*1.0/coursegrades.size();
        StudentPersonalResult<StudentModel,CoursegradeModel> res = new StudentPersonalResult<>();
        res.setStudentRows(students);
        res.setCourseRows(coursegrades);
        res.setAverage(average);

        return res;
    }

    @Override
    public TableResult<StudentModel> getSchoolStudent(ManagerDto managerDto) {
        Integer shcoolid = managerMapper.selectSchoolid(managerDto.getId());
        StudentDto studentDto = new StudentDto();
        studentDto.setSchoolid(shcoolid);
        List<StudentModel> students = studentMapper.selectForManager0(studentDto);
        TableResult<StudentModel> tableResult = new TableResult<>();
        tableResult.setRows(students);
        tableResult.setTotalCount(students.size());
        return tableResult;
    }

    @Override
    public SaResult insertStudent(StudentDto studentDto) {
//        studentDto.setSchoolid(schoolMapper.selectSchoolId(studentDto.getSchoolname()));
        Boolean b = studentMapper.insertStudent(studentDto);
        if(b == true){
            return SaResult.ok("添加学生成功");
        } else {
            return SaResult.error("添加学生失败");
        }
    }

    @Override
    public SaResult deleteStudentById(StudentDto studentDto) {
        Boolean b = studentMapper.deleteStudentById(studentDto.getId());
        if(b == true){
            return SaResult.ok("删除学生成功");
        }  else{
            return SaResult.error("添加学生失败");
        }
    }

    @Override
    public SaResult upadteStudent(StudentDto studentDto) {
        Boolean success = false;
        success = studentMapper.updateStudent(studentDto);
        if(success){
            return SaResult.ok("更新成功");
        }else {
            return SaResult.error("更新失败");
        }
    }


}
