package com.miaoyou.platform.server.service.survey;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.SurveyDetailtbExample;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.SurveyDetailtbMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SurveyDtService implements SurveyDtServiceIF{
	private static final Log log = LogFactory.getLog(SurveyDtService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SurveyDetailtbMapper surveyDetailtbMapper;
	
	@Override
	public SurveyDetailtb findDataByKey(Long id) {
		log.info("find data:" + id);
		return surveyDetailtbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<SurveyDetailtb> findAll(Pager page, String conditionSql) {
		CommFindEntity<SurveyDetailtb> result = new CommFindEntity<SurveyDetailtb>();
		SurveyDetailtbExample example = new SurveyDetailtbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		}else{
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = surveyDetailtbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("surverydetail_id DESC");

		List<SurveyDetailtb> ls = surveyDetailtbMapper.selectByExample(example);
		result.setResult(ls);
		return result;
	}

	@Override
	public int saveData(SurveyDetailtb bean) {
		log.info("saveData:" + bean.getSurverydetailName());
		long key = pkgeneratorService.getPrimaryKey("surveyDetailtb",
				"surveyDetailtb_id");
		bean.setSurverydetailId(key);
		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSurverydetailName());
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

		return surveyDetailtbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		SurveyDetailtb tb = surveyDetailtbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return surveyDetailtbMapper.updateByPrimaryKeySelective(tb);
	}

	@Override
	public int updateData(SurveyDetailtb bean) {
		log.info("updateData:" + bean.getSurverydetailId());
		bean.setUpdatedate(new Date());
		
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSurverydetailName());
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
		return surveyDetailtbMapper.updateByPrimaryKeySelective(bean);
	}

}
