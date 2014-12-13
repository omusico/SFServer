/*
 * 2014 Chengdu JunChen Technology
 */

package com.miaoyou.platform.server.service.user;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;

/**
 *
 * @author 305027939
 */
public interface DepartmentServiceIF {
    
    public int saveDepartment(Departmenttb departmenttb);
    
    public int updateDepartment(Departmenttb departmenttb);
    
    public int deleteDepartment(Integer userId);
    
    public CommFindEntity<Departmenttb> findDepartments();
    
    public CommFindEntity<Departmenttb> findDepartments(Pager page, String conditionSql);    
    
    public Departmenttb findDepartmentById(Integer id);
    
}
