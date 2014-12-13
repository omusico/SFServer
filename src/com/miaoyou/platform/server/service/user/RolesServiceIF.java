/*
 * 2014 Chengdu JunChen Technology
 */

package com.miaoyou.platform.server.service.user;

import com.miaoyou.platform.server.entity.Roletb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;

/**
 *
 * @author 305027939
 */
public interface RolesServiceIF {
    
    public int saveUserRoles(Roletb roles);
    
    public int deleteUserRoles(Integer roles);
    
    public int deleteUserRoles(String roleName);
    
    public int updateUserRoles(Roletb newRoles);
    
    public CommFindEntity<Roletb> findUsersRoles(Roletb roles);
    
    public Roletb findUsersRoles(Integer roleId);
    
}
