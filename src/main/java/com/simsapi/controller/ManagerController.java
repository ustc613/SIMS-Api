package com.simsapi.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.CourseModel;
import com.simsapi.model.ManagerModel;
import com.simsapi.model.SchoolModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.CourseDto;
import com.simsapi.model.dto.ManagerDto;
import com.simsapi.model.dto.SchoolDto;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.CourseService;
import com.simsapi.service.ManagerService;
import com.simsapi.service.SchoolService;
import com.simsapi.service.StudentService;
import com.simsapi.utils.StpManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/login")
    public SaResult login(@RequestBody ManagerDto managerDto){
        return managerService.login(managerDto);
    }

    @PostMapping("/logout")
    @SaCheckLogin(type = "manager")
    public SaResult logout(){
        StpManagerUtil.logout();
        return SaResult.ok("下线成功");
    }

    /**
     * super管理员获取所有学校管理员
     * @param
     * @return
     */
    @PostMapping("/allManager")
    @SaCheckLogin(type = "manager")
    @SaCheckRole(type = "manager",value = "super")
    public TableResult<ManagerModel> getAllManagers(){
        return managerService.getAllManagers();
    }

    /**
     * super管理员获得所有的学校
     * @return
     */
    @PostMapping("/school")
    @SaCheckRole(type = "manager",value = "super")
    public TableResult<SchoolModel> getAllSchool(){
        return schoolService.getSchool();
    }



    /**
     * super管理员添加学校
     * @param schoolDto
     * @return
     */
    @PostMapping("/addSchool")
    @SaCheckRole(type = "manager",value = "super")
    public SaResult addSchool(@RequestBody SchoolDto schoolDto){
        return schoolService.insertSchool(schoolDto);
    }


    /**
     * super管理员添加管理员
     * @param managerDto
     * @return
     */
    @PostMapping("/addManager")
    @SaCheckRole(type = "manager",value = "super")
    public SaResult addManager(@RequestBody ManagerDto managerDto){
        return managerService.insertManager(managerDto);
    }


    /**
     * super管理员查询某个学校的所有课程
     * @param schoolDto
     * @return
     */
    @PostMapping("/getCourses")
    @SaCheckRole(type = "manager",value = "super")
    public TableResult<CourseModel> getCoursesForSuper(@RequestBody SchoolDto schoolDto){
        return courseService.selectAllcoruseForSuper(schoolDto);
    }




    /**
     * 学校管理员获取所有学生
     * @param
     * @return
     */
    @PostMapping("/allStudent")
    @SaCheckRole(type = "manager",value = "normal")
    public TableResult<StudentModel> getStudentForManager(){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(StpUtil.getLoginIdAsInt());
        return studentService.getSchoolStudent(managerDto);
    }

    /**
     * 学校管理员查看所有课程接口
     * @param
     * @return
     */
    @PostMapping("/allCourse")
    @SaCheckRole(type = "manager",value = "normal")
    public TableResult<CourseModel> getCoursesForManager(){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(StpUtil.getLoginIdAsInt());
        return courseService.selectAllcoruse(managerDto);
    }

    /**
     * 学校管理员为他管理的学校添加课程
     * @param courseDto
     * @return
     */
    @PostMapping("/addCourse")
    @SaCheckRole(type = "manager",value = "normal")
    public SaResult addCourseForManager(@RequestBody CourseDto courseDto){
        return courseService.insertCourseForManager(courseDto);
    }

    /**
     * 学校管理员增加学生接口
     * @param studentDto
     * @return
     */
    @PostMapping("/addStudent")
    @SaCheckRole(type = "manager",value = "normal")
    public SaResult addStudent(@RequestBody StudentDto studentDto){
        return studentService.insertStudent(studentDto);
    }

    /**
     * 学校管理员删除某个学生
     * @param studentDto
     * @return
     */
    @PostMapping("/deleteStudent")
    @SaCheckRole(type = "manager",value = "normal")
    public SaResult deleteStudent(@RequestBody StudentDto studentDto){
        return studentService.deleteStudentById(studentDto);
    }

    /**
     * 所有管理员更新学生信息
     * @param studentDto
     * @return
     */
    @PostMapping("/updateStudent")
    @SaCheckLogin(type = "manager")
    public SaResult updateStudent(@RequestBody StudentDto studentDto){
        return studentService.upadteStudent(studentDto);
    }

    /**
     * 所有管理员更新学校信息
     * @param schoolDto
     * @return
     */
    @PostMapping("/updateSchool")
    @SaCheckLogin(type = "manager")
    public SaResult updateSchool(@RequestBody SchoolDto schoolDto){
        return schoolService.updateSchool(schoolDto);
    }

    /**
     * super管理员更新管理员信息
     * @param managerDto
     * @return
     */
    @PostMapping("/updateManager")
    @SaCheckRole(type = "manager",value="super")
    public SaResult updateStudent(@RequestBody ManagerDto managerDto){
        return managerService.updateManager(managerDto);
    }

    /**
     * 所有管理员更新课程信息
     * @param courseDto
     * @return
     */
    @PostMapping("/updateCourse")
    @SaCheckLogin(type = "manager")
    public SaResult updateCourse(@RequestBody CourseDto courseDto){
        return courseService.updateCourse(courseDto);
    }
}
