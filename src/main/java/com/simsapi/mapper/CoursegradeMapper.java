package com.simsapi.mapper;

import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CoursegradeMapper {
    List<CoursegradeModel> selectGradeForStudent(StudentDto studentDto);
}
