package com.simsapi.controller;

import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.StudentPersonalResult;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查看学生信息得到所有学生信息
     * @param studentDto
     * @return TableResult<StudentModel>
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    @ResponseBody
    public TableResult<StudentModel> getAllStudent(@RequestBody StudentDto studentDto){
        return studentService.selectAllStudent(studentDto);
    }

    /**
     * 学生登录，只能查看自己的信息
     * @param studentDto
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "/student/personal",method = RequestMethod.POST)
    @ResponseBody
    public StudentPersonalResult<StudentModel, CoursegradeModel> getStudent(@RequestBody StudentDto studentDto){
        return studentService.selectPersonStudent(studentDto);
    }
}
