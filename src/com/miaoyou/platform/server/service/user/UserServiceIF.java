/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miaoyou.platform.server.service.user;

import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;

/**
 *
 * @author 305027939
 */
public interface UserServiceIF {
    
    public UserAll findUserAll(Integer id);
    
    public Usertb findUser(Integer id);
    
    public CommFindEntity<UserAll> findAllUsers(Pager page,String conditionSql);
    
    public CommFindEntity<UserAll> findAllUsers(Pager page);
    
    public int saveUser(Usertb user);
    
    public int deleteUser(Integer userId);
    
    public int updateUser(Usertb user);
    
}
