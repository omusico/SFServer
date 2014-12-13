/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Roletb;
import com.miaoyou.platform.server.entity.RoletbExample;
import com.miaoyou.platform.server.entity.RoletbExample.Criteria;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.RoletbMapper;

/**
 *
 * @author 305027939
 */
@Service
public class RolesService implements RolesServiceIF {

    private static final Log log = LogFactory.getLog(RolesService.class);
    @Resource
    RoletbMapper mappper;

    @Override
    public int saveUserRoles(Roletb roles) {
        log.debug("insert user roles:" + roles.getRoleName());
        return mappper.insert(roles);
    }

    @Override
    public int deleteUserRoles(Integer roles) {
        log.debug("delete user roles:" + roles);
        return mappper.deleteByPrimaryKey(roles);
    }
    
    
    @Override
    public int deleteUserRoles(String roleName) {
        log.debug("delete user roles:" + roleName);
        RoletbExample example = new RoletbExample();
        example.createCriteria().andRoleNameEqualTo(roleName);
        return mappper.deleteByExample(example);
    }

    @Override
    public int updateUserRoles(Roletb newRoles) {
    	log.debug("updated user roles:" + newRoles.getRoleName());
        return mappper.updateByPrimaryKeySelective(newRoles);
    }

    @Override
    public CommFindEntity<Roletb> findUsersRoles(Roletb roles) {
    	
    	CommFindEntity<Roletb> array = new CommFindEntity<>();
    	
    	RoletbExample example = new RoletbExample();
        Criteria c = example.createCriteria();
            if (roles.getRoleName() != null && !roles.getRoleName().equals("")) {
                c.andRoleNameEqualTo(roles.getRoleName());
            }
            
            if (roles.getRoleId() != null && roles.getRoleId()>0) {
                c.andRoleIdEqualTo(roles.getRoleId());
            }
            
            if (roles.getRoleScope() != null && !roles.getRoleScope().equals("")) {
            	c.andRoleScopeLike("%"+roles.getRoleScope()+"%");
            }
        List<Roletb> result = mappper.selectByExample(example);
        if (log.isDebugEnabled()) {
            for (Roletb d : result) {
                log.debug("find user roles:" + d.getRoleName());
            }
        }
        return array;
    }

	@Override
	public Roletb findUsersRoles(Integer roleId) {
		log.debug("search user roles:" + roleId);
		return mappper.selectByPrimaryKey(roleId);
	}

}
