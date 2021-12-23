package com.simsapi.mapper;

import com.simsapi.model.ManagerModel;
import com.simsapi.model.dto.ManagerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {
    /**
     * 分页查询所有管理员信息
     * @param managerDto
     * @return
     */
    List<ManagerModel> selectAllManagers(ManagerDto managerDto);

    /**
     * 查询所有管理员数量
     * @return
     */
    Integer selectCount();


    /**
     *
     * @param id id即loginid 设计时两者相同
     * @return 0：普通管理员 1：超级管理员
     */
    Integer selectRole(Integer id);
}
