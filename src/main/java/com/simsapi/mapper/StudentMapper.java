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
     * 学生登录并查询学生的id
     * @param studentDto
     * @return
     */
    Integer selectIdForLogin(StudentDto studentDto);

    /**
     * 教育局管理员查看所有学生信息
     * @param studentDto
     * @return
     */
    List<StudentModel> selectAllStudent(StudentDto studentDto);

    /**
     * 教育局查询的所有学生信息的数量(用于返回总数）但是暂时没啥用了
     * @param studentDto
     * @return
     */
    Integer selectCount(StudentDto studentDto);

    /**
     * 查询学生个人信息
     * @param studentDto
     * @return
     */
    List<StudentModel> selectPersonStudent(StudentDto studentDto);

    /**
     * 学校管理员获得的所有学生信息
     * @param studentDto
     * @return
     */
    List<StudentModel> selectForManager0(StudentDto studentDto);

    /**
     * 学校管理员增加学生
     * @param studentDto
     * @return
     */
    Boolean insertStudent(StudentDto studentDto);

    /**
     * 学校管理员删除学生
     * @param id
     * @return
     */
    Boolean deleteStudentById(Integer id);
}
