package com.miaoyou.platform.server.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.DepartmenttbExample;
import com.miaoyou.platform.server.entity.child.DepartmentAll;
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
	public static BeanCopier copier = BeanCopier.create(Departmenttb.class,
			DepartmentAll.class, false);
	@Resource
	DepartmenttbMapper departmenttbMapper;

	@Resource
	UserServiceIF userService;

	@Override
	public int saveDepartment(DepartmentAll departmenttb) {
		log.debug("insert departmenttb:" + departmenttb.getDepartmentName());
		departmenttb.setDeleteFlag(0);
		departmenttb.setCreatedate(new Date());

		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(departmenttb
				.getDepartmentName());
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
	public int updateDepartment(DepartmentAll departmenttb) {
		log.debug("update departmenttb:" + departmenttb.getDepartmentName());
		departmenttb.setUpdatedate(new Date());
		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(departmenttb
				.getDepartmentName());
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
	public CommFindEntity<DepartmentAll> findDepartments(Pager page,
			String conditionSql) {
		DepartmenttbExample example = new DepartmenttbExample();
		CommFindEntity<DepartmentAll> allEntity = new CommFindEntity<DepartmentAll>();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			example.createCriteria().addConditionSql(conditionSql);
		} else {
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		int count = departmenttbMapper.countByExample(example);

		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		example.setOrderByClause("department_id DESC");

		List<Departmenttb> result = departmenttbMapper.selectByExample(example);

		List<DepartmentAll> dpAllArray = new ArrayList<>();
		for (Departmenttb depart : result) {
			DepartmentAll dpAll = new DepartmentAll();

			copier.copy(depart, dpAll, null);

			if (depart.getParentId() != null && depart.getParentId() > 0) {
				DepartmentAll parentBean = findDepartmentById(depart
						.getParentId());
				dpAll.setParentDp(parentBean);
			}

			dpAllArray.add(dpAll);
		}

		allEntity.setCount(count);
		allEntity.setResult(dpAllArray);
		return allEntity;
	}

	@Override
	public CommFindEntity<DepartmentAll> findDepartments() {
		DepartmenttbExample example = new DepartmenttbExample();
		example.createCriteria().andDeleteFlagEqualTo(0);
		CommFindEntity<DepartmentAll> allEntity = new CommFindEntity<>();
		int count = departmenttbMapper.countByExample(example);
		allEntity.setCount(count);
		example.setOrderByClause("department_id DESC");
		List<Departmenttb> result = departmenttbMapper.selectByExample(example);

		List<DepartmentAll> dpAllArray = new ArrayList<>();
		for (Departmenttb depart : result) {
			DepartmentAll dpAll = new DepartmentAll();

			copier.copy(depart, dpAll, null);

			if (depart.getParentId() != null && depart.getParentId() > 0) {
				DepartmentAll parentBean = findDepartmentById(depart
						.getParentId());
				dpAll.setParentDp(parentBean);
			}

			dpAllArray.add(dpAll);
		}

		allEntity.setResult(dpAllArray);
		return allEntity;
	}

	@Override
	public DepartmentAll findDepartmentById(Integer id) {
		DepartmenttbExample example = new DepartmenttbExample();
		example.createCriteria().andDepartmentIdEqualTo(id);
		log.debug("findDepartmentById:" + id);

		Departmenttb dpbean = departmenttbMapper.selectByPrimaryKey(id);
		DepartmentAll dpAll = new DepartmentAll();
		if (dpbean != null) {
			
			copier.copy(dpbean, dpAll, null);
			if (dpbean.getParentId() != null && dpbean.getParentId() > 0) {
				DepartmentAll parentBean = findDepartmentById(dpbean
						.getParentId());
				dpAll.setParentDp(parentBean);
			}
		}
		return dpAll;
	}

}
