package com.simsapi.controller;

import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
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
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    @ResponseBody
    public TableResult<StudentModel> getAllStudent(@RequestBody StudentDto studentDto){
        return studentService.selectAllStudent(studentDto);
    }
}
