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
import com.miaoyou.platform.server.utils.Pager;

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
	public CommFindEntity<Roletb> findUsersRoles(Pager page) {

		CommFindEntity<Roletb> array = new CommFindEntity<>();

		RoletbExample example = new RoletbExample();

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = mappper.countByExample(example);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("role_id DESC");

		List<Roletb> result = mappper.selectByExample(example);
		if (log.isDebugEnabled()) {
			for (Roletb d : result) {
				log.debug("find user roles:" + d.getRoleName());
			}
		}
		array.setCount(count);
		array.setResult(result);
		return array;
	}

	@Override
	public CommFindEntity<Roletb> findUsersRoles(Pager page, String conditionSql) {

		CommFindEntity<Roletb> array = new CommFindEntity<>();

		RoletbExample example = new RoletbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			example.createCriteria().addConditionSql(conditionSql);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = mappper.countByExample(example);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("role_id DESC");

		List<Roletb> result = mappper.selectByExample(example);
		if (log.isDebugEnabled()) {
			for (Roletb d : result) {
				log.debug("find user roles:" + d.getRoleName());
			}
		}
		array.setCount(count);
		array.setResult(result);
		return array;
	}

	@Override
	public Roletb findUsersRoles(Integer roleId) {
		log.debug("search user roles:" + roleId);
		return mappper.selectByPrimaryKey(roleId);
	}

}
