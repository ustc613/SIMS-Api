package com.simsapi.mapper;

import com.simsapi.model.CourseModel;
import com.simsapi.model.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    /**
     * 学校管理员查询所有课程
     * @param schoolid
     * @return
     */
    List<CourseModel> selectAllCoruse(Integer schoolid);

    Boolean insertCourseForManager(CourseDto courseDto);

    /**
     * 更新课程信息
     * @param courseDto
     * @return
     */
    Boolean updateCourse(CourseDto courseDto);
}
