package com.simsapi.service;

import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.TableResult;

import java.util.List;

public interface StudentService {
    TableResult<StudentModel> selectAllStudent(StudentDto studentDto);
}
