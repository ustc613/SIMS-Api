package com.simsapi.mapper;

import com.simsapi.model.StudentModel;
import com.simsapi.model.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    /**
     * 教育局管理员查看所有学生信息
     * @param studentDto
     * @return
     */
    List<StudentModel> selectAllStudent(StudentDto studentDto);

    /**
     * 教育局查询的所有学生信息的数量
     * @param studentDto
     * @return
     */
    Integer selectCount(StudentDto studentDto);

    List<StudentModel> selectPersonStudent(StudentDto studentDto);

}
