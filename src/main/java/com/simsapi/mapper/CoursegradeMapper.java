package com.simsapi.mapper;

import com.simsapi.model.CoursegradeModel;
import com.simsapi.model.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CoursegradeMapper {
    /**
     * 查询学生个人信息页的成绩
     * @param studentDto
     * @return
     */
    List<CoursegradeModel> selectGradeForStudent(StudentDto studentDto);

}
