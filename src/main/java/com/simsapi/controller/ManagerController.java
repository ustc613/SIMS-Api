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
    @CrossOrigin(origins = "*",maxAge = 3600)
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
    @CrossOrigin(origins = "*",maxAge = 3600)
    @SaCheckRole(type = "manager",value = "super")
    public Boolean addSchool(@RequestBody SchoolDto schoolDto){
        return schoolService.insertSchool(schoolDto);
    }


    /**
     * super管理员添加管理员
     * @param managerDto
     * @return
     */
    @PostMapping("/addManager")
    @CrossOrigin(origins = "*",maxAge = 3600)
    @SaCheckRole(type = "manager",value = "super")
    public Boolean addManager(@RequestBody ManagerDto managerDto){
        return managerService.insertManager(managerDto);
    }


    /**
     * super管理员查询某个学校的所有课程
     * @param schoolDto
     * @return
     */
    @PostMapping("/getCourses")
    @CrossOrigin(origins = "*",maxAge = 3600)
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
    @CrossOrigin(origins = "*",maxAge = 3600)
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
    @CrossOrigin(origins = "*",maxAge = 3600)
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
    @CrossOrigin(origins = "*",maxAge = 3600)
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
    @CrossOrigin(origins = "*",maxAge = 3600)
    @SaCheckRole(type = "manager",value = "normal")
    public Boolean addStudent(@RequestBody StudentDto studentDto){
        return studentService.insertStudent(studentDto);
    }

    /**
     * 学校管理员删除某个学生
     * @param studentDto
     * @return
     */
    @PostMapping("/deleteStudent")
    @CrossOrigin(origins = "*",maxAge = 3600)
    @SaCheckRole(type = "manager",value = "normal")
    public Boolean deleteStudent(@RequestBody StudentDto studentDto){
        return studentService.deleteStudentById(studentDto);
    }
}
