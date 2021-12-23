package com.simsapi.utils;

import java.util.ArrayList;
import java.util.List;

import com.simsapi.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cn.dev33.satoken.stp.StpInterface;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    ManagerMapper managerMapper;
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<String>();

        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     * 两种LoginType(账号体系)：1、学生 2、管理员
     * 管理员账号体系下有两种角色：1普通管理员 2超级管理员
     * 超级管理员:教育局管理员 role字段为1
     * 普通管理员：学校管理员 role字段为0
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> list = new ArrayList<String>();
        if(loginType.equals("manager")){
            //查询数据库判断是不是超级管理员
            int id = Integer.parseInt(loginId.toString());
            Integer role = managerMapper.selectRole(id);
            if (role == 1){
                list.add("super");
            }else {
                list.add("normal");
            }
        } else {
            list.add("student");
        }
        return list;
    }

}

