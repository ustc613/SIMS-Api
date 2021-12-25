package com.simsapi.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.StudentPersonalResult;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student") //统一在 /student下做关于学生的操作
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 学生登录
     * @param studentDto
     * 学生的loginID和数据库中的id相等并且一一对应
     * @return
     */
    @PostMapping("/login")
    public SaResult login(@RequestBody StudentDto studentDto){
        return studentService.login(studentDto);
    }

    /**
     * 已登录的学生下线
     * @return
     */
    @PostMapping("/logout")
    @SaCheckLogin() //下线操作前必须已经登录，里面不指定值就是学生，指定为"manager"即是管理员
    public SaResult logout(){
        StpUtil.logout();
        return SaResult.ok("下线成功");
    }

    /**
     * 查看学生信息得到所有学生信息
     * @param studentDto
     * @return TableResult<StudentModel>
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    @SaCheckRole(type = "manager",value = "super")
    public TableResult<StudentModel> getAllStudent(@RequestBody StudentDto studentDto){
        return studentService.selectAllStudent(studentDto);
    }

    /**
     * 学生登录，只能查看自己的信息
     * @param
     * @return
     */
    @RequestMapping(value = "/personal",method = RequestMethod.POST)
    @SaCheckLogin //学生需要先登录 coockie中才能保存他的id
    public StudentPersonalResult<StudentModel, CoursegradeModel> getStudent(){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(StpUtil.getLoginIdAsInt());
        return studentService.selectPersonStudent(studentDto);
    }
}
