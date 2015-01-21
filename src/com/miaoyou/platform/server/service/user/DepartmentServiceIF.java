/*
 * 2014 Chengdu JunChen Technology
 */

package com.miaoyou.platform.server.service.user;

import com.miaoyou.platform.server.entity.child.DepartmentAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;

/**
 *
 * @author 305027939
 */
public interface DepartmentServiceIF {
    
    public int saveDepartment(DepartmentAll departmenttb);
    
    public int updateDepartment(DepartmentAll departmenttb);
    
    public int deleteDepartment(Integer userId);
    
    public CommFindEntity<DepartmentAll> findDepartments();
    
    public CommFindEntity<DepartmentAll> findDepartments(Pager page, String conditionSql);    
    
    public DepartmentAll findDepartmentById(Integer id);
    
}
