/*
 * 2014 Chengdu JunChen Technology
 */

package com.miaoyou.platform.server.service.user;

import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;

/**
 *
 * @author 305027939
 */
public interface LoginServiceIF {
    
    public UserAll login(String userName,String passed);
    
}
