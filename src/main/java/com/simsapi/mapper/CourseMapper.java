package com.simsapi.mapper;

import com.simsapi.model.CourseModel;
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
}
