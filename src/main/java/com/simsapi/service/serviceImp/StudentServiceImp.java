package com.simsapi.service.serviceImp;

import com.simsapi.mapper.CoursegradeMapper;
import com.simsapi.mapper.SchoolMapper;
import com.simsapi.mapper.StudentMapper;
import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
import com.simsapi.model.res.StudentPersonalResult;
import com.simsapi.model.res.TableResult;
import com.simsapi.service.CoursegradeService;
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
}
