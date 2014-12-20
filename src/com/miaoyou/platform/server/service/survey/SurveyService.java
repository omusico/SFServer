package com.miaoyou.platform.server.service.survey;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.SurveytbExample;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.SurveytbMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SurveyService implements SurveyServiceIF{
	private static final Log log = LogFactory.getLog(SurveyService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SurveytbMapper surveytbMapper;
	
	@Override
	public Surveytb findDataByKey(Long id) {
		log.info("find data:" + id);
		return surveytbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Surveytb> findAll(Pager page, String conditionSql) {
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		SurveytbExample example = new SurveytbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		}else{
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = surveytbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("survery_id DESC");

		List<Surveytb> ls = surveytbMapper.selectByExample(example);
		result.setResult(ls);
		return result;
	}

	@Override
	public int saveData(Surveytb bean) {
		log.info("saveData:" + bean.getSurveryName());
		long key = pkgeneratorService.getPrimaryKey("surveytb",
				"surveytb_id");
		bean.setSurveryId(key);
		
		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());
		
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSurveryName());
		bean.setZujima(zujima);

		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails user = (CommUserDetails) principal;
				UserAll session = user.getUserSessionEntity();
				if (session != null) {
					bean.setCreateperson(session.getUserName());
				}
			}
		}

		return surveytbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		Surveytb tb = surveytbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return surveytbMapper.updateByPrimaryKeySelective(tb);
	}

	@Override
	public int updateData(Surveytb bean) {
		log.info("updateData:" + bean.getSurveryId());
		bean.setUpdatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSurveryName());
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
		return surveytbMapper.updateByPrimaryKeySelective(bean);
	}

}
