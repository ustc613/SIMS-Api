package com.simsapi.mapper;

import com.simsapi.model.SchoolModel;
import com.simsapi.model.dto.SchoolDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SchoolMapper {
    /**
     * 根据姓名查出来id，用于插入学生
     * @param schoolname
     * @return
     */
    Integer selectSchoolId(String schoolname);

    /**
     * super管理员查询所有学校
     * @return
     */
    List<SchoolModel> getAllSchool();

    /**
     * super管理员插入学校
     * @param schoolDto
     * @return
     */
    Boolean insertSchool(SchoolDto schoolDto);
}
