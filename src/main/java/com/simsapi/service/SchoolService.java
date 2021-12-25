package com.simsapi.service;

import cn.dev33.satoken.util.SaResult;
import com.simsapi.model.SchoolModel;
import com.simsapi.model.dto.SchoolDto;
import com.simsapi.model.res.TableResult;

public interface SchoolService {
    /**
     * super管理员获得所有学校信息
     * @return
     */
    TableResult<SchoolModel> getSchool();

    /**
     * super管理员插入学校
     * @param schoolDto
     * @return
     */
    Boolean insertSchool(SchoolDto schoolDto);

    /**
     * 更新学校信息
     * @param schoolDto
     * @return
     */
    SaResult updateSchool(SchoolDto schoolDto);
}
