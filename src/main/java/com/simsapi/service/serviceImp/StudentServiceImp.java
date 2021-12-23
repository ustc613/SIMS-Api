package com.simsapi.service.serviceImp;

import com.simsapi.mapper.SchoolMapper;
import com.simsapi.mapper.StudentMapper;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


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
}
