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
     * @param
     * @return
     */
    List<ManagerModel> selectAllManagers();

    /**
     * 查询所有管理员数量
     * @return
     */
    Integer selectCount();

    /**
     * 为登录查询用户的id
     * 需要username、password相匹配
     * @param managerDto
     * @return
     */
    Integer selectIdForLogin(ManagerDto managerDto);


    /**
     *
     * @param id id即loginid 设计时两者相同
     * @return 0：普通管理员 1：超级管理员
     */
    Integer selectRole(Integer id);

    /**
     * 根据管理员id查询schoolid，用于管理员的后续查询
     * @param id
     * @return
     */
    Integer selectSchoolid(Integer id);

    /**
     * super插入学校管理员
     * @param managerDto
     * @return
     */
    Boolean insertManager(ManagerDto managerDto);
}
