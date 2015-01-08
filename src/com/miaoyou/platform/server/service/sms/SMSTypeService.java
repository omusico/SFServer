package com.miaoyou.platform.server.service.sms;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Smstypetb;
import com.miaoyou.platform.server.entity.SmstypetbExample;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.SmstypetbMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SMSTypeService implements SMSTypeServiceIF {
	private static final Log log = LogFactory.getLog(SMSTypeService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SmstypetbMapper smstypetbMapper;

	@Override
	public Smstypetb findDataByKey(Long id) {
		log.info("findDataByKey:" + id);
		return smstypetbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Smstypetb> findAll(Pager page, String conditionSql) {
		log.info("findAll:" + conditionSql);
		CommFindEntity<Smstypetb> result = new CommFindEntity<Smstypetb>();

		SmstypetbExample example = new SmstypetbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			example.createCriteria().addConditionSql(conditionSql);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = smstypetbMapper.countByExample(example);
		page.setCount(count);
		result.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("smstype_id DESC");

		List<Smstypetb> lsAll = smstypetbMapper.selectByExample(example);
		result.setResult(lsAll);

		return result;
	}

	@Override
	public int saveData(Smstypetb bean) {
		log.info("saveData:" + bean.getSmstypeName());

		long key = pkgeneratorService.getPrimaryKey("smstypetb", "smstype_id");
		bean.setSmstypeId(key);

		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSmstypeName());
		bean.setZujima(zujima);
		bean.setCreatedate(new Date());

		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails sessionuser = (CommUserDetails) principal;
				UserAll session = sessionuser.getUserSessionEntity();
				if (session != null) {
					bean.setCreateperson(session.getUserName());
				}
			}
		}

		return smstypetbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		return smstypetbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateData(Smstypetb bean) {
		log.info("updateData:" + bean.getSmstypeId());
		bean.setUpdatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSmstypeName());
		bean.setZujima(zujima);
		
		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails user = (CommUserDetails) principal;
				UserAll session = user.getUserSessionEntity();
				if (session != null) {
					bean.setUpdateperson(session.getUserName());
				}
			}
		}
		return smstypetbMapper.updateByPrimaryKeySelective(bean);
	}

}
