package com.miaoyou.platform.server.service.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.DepartmenttbExample;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.DepartmenttbMapper;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

/**
 *
 * @author 305027939
 */
@Service
public class DepartmentService implements DepartmentServiceIF {

	private static final Log log = LogFactory.getLog(DepartmentService.class);
	@Resource
	DepartmenttbMapper departmenttbMapper;

	@Resource
	UserServiceIF userService;

	@Override
	public int saveDepartment(Departmenttb departmenttb) {
		log.debug("insert departmenttb:" + departmenttb.getDepartmentName());
		departmenttb.setDeleteFlag(0);
		departmenttb.setCreatedate(new Date());
		
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(departmenttb.getDepartmentName());
		departmenttb.setZujima(zujima);

		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails user = (CommUserDetails) principal;
				UserAll session = user.getUserSessionEntity();
				if (session != null) {
					departmenttb.setCreateperson(session.getUserName());
				}
			}
		}
		return departmenttbMapper.insertSelective(departmenttb);
	}

	@Override
	public int updateDepartment(Departmenttb departmenttb) {
		log.debug("update departmenttb:" + departmenttb.getDepartmentName());
		departmenttb.setUpdatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(departmenttb.getDepartmentName());
		departmenttb.setZujima(zujima);
		
		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails user = (CommUserDetails) principal;
				UserAll session = user.getUserSessionEntity();
				if (session != null) {
					departmenttb.setUpdateperson(session.getUserName());
				}
			}
		}
		return departmenttbMapper.updateByPrimaryKey(departmenttb);
	}

	@Override
	public int deleteDepartment(Integer userId) {
		log.debug("delete departmenttb:" + userId);
		Departmenttb depart = departmenttbMapper.selectByPrimaryKey(userId);
		depart.setDeleteFlag(1);

		return departmenttbMapper.updateByPrimaryKeySelective(depart);
	}

	@Override
	public CommFindEntity<Departmenttb> findDepartments(Pager page,
			String conditionSql) {
		DepartmenttbExample example = new DepartmenttbExample();
		CommFindEntity<Departmenttb> allEntity = new CommFindEntity<Departmenttb>();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			example.createCriteria().addConditionSql(conditionSql);
		}else{
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		int count = departmenttbMapper.countByExample(example);

		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		example.setOrderByClause("department_id DESC");

		List<Departmenttb> result = departmenttbMapper.selectByExample(example);

		allEntity.setCount(count);
		allEntity.setResult(result);
		return allEntity;
	}

	@Override
	public CommFindEntity<Departmenttb> findDepartments() {
		DepartmenttbExample example = new DepartmenttbExample();
		example.createCriteria().andDeleteFlagEqualTo(0);
		CommFindEntity<Departmenttb> allEntity = new CommFindEntity<>();
		int count = departmenttbMapper.countByExample(example);
		allEntity.setCount(count);
		example.setOrderByClause("department_id DESC");
		List<Departmenttb> result = departmenttbMapper.selectByExample(example);
		allEntity.setResult(result);
		return allEntity;
	}

	@Override
	public Departmenttb findDepartmentById(Integer id) {
		DepartmenttbExample example = new DepartmenttbExample();
		example.createCriteria().andDepartmentIdEqualTo(id);
		log.debug("findDepartmentById:" + id);
		return departmenttbMapper.selectByPrimaryKey(id);
	}

}
