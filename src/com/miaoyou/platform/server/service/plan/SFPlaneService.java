package com.miaoyou.platform.server.service.plan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.RsplantelsvExample;
import com.miaoyou.platform.server.entity.RsplantelsvKey;
import com.miaoyou.platform.server.entity.Sfplantb;
import com.miaoyou.platform.server.entity.SfplantbExample;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.RsplantelsvMapper;
import com.miaoyou.platform.server.mapper.SfplantbMapper;
import com.miaoyou.platform.server.service.diagnosis.DiagnosisSurveyServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SFPlaneService implements SFPlaneServiceIF{
	private static final Log log = LogFactory.getLog(SFPlaneService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SfplantbMapper sfplantbMapper;
	
	@Resource
	RsplantelsvMapper rsplantelsvMapper;
	
	@Resource
	DiagnosisSurveyServiceIF diagnosisSurveyService;
	
	@Override
	public Sfplantb findDataByKey(Long id) {
		log.info("find data:" + id);
		return sfplantbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Sfplantb> findAll(Pager page, String conditionSql) {
		CommFindEntity<Sfplantb> result = new CommFindEntity<Sfplantb>();
		SfplantbExample example = new SfplantbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		}else{
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = sfplantbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("plan_id DESC");

		List<Sfplantb> ls = sfplantbMapper.selectByExample(example);
		result.setResult(ls);
		return result;
	}

	@Override
	public int saveData(Sfplantb bean) {
		log.info("saveData:" + bean.getPlanname());
		long key = pkgeneratorService.getPrimaryKey("sfplantb",
				"plan_id");
		bean.setPlanId(key);
		
		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());
		
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getPlanname());
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

		return sfplantbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		Sfplantb tb = sfplantbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return sfplantbMapper.updateByPrimaryKeySelective(tb);
	}

	@Override
	public int updateData(Sfplantb bean) {
		log.info("updateData:" + bean.getPlanname());
		bean.setUpdatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getPlanname());
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
		return sfplantbMapper.updateByPrimaryKeySelective(bean);
	}

	@Override
	public CommFindEntity<Surveytb> findSurveyByDns(Long planId) {
		log.info("getSurveyByDns:"+planId);
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		List<Surveytb> surveryArray = new ArrayList<>();
		result.setResult(surveryArray);
		
		RsplantelsvExample example =new RsplantelsvExample();
		example.createCriteria().andPlanIdEqualTo(planId);
		List<RsplantelsvKey> plantelKey = rsplantelsvMapper.selectByExample(example);
		if(plantelKey!=null){
			for(RsplantelsvKey key:plantelKey){
				CommFindEntity<Surveytb> array=diagnosisSurveyService.findSurvey(key.getDiagnosisId());
				result.setCount(result.getCount()+array.getCount());
				surveryArray.addAll(array.getResult());
			}
		}
		
		return result;
	}

}
