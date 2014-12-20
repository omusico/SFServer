package com.miaoyou.platform.server.service.survey;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.RssvsvdtbExample;
import com.miaoyou.platform.server.entity.RssvsvdtbKey;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.RssvsvdtbMapper;
import com.miaoyou.platform.server.utils.Pager;

@Service
public class SurveyModelService implements SurveyModelServiceIF{
	 public static BeanCopier copier = BeanCopier.create(Surveytb.class, SurveyModelEntity.class, false);
	private static final Log log = LogFactory.getLog(SurveyService.class);

	@Resource
	SurveyServiceIF surveyService;
	
	@Resource
	SurveyDtServiceIF surveyDtService;
	
	@Resource
	RssvsvdtbMapper rssvsvdtbMapper;
	
	@Override
	public SurveyModelEntity findModelAll(Pager page, Long surveryId) {
		log.info("try to find survey model");
		RssvsvdtbExample example = new RssvsvdtbExample();
		example.createCriteria().andSurveryIdEqualTo(surveryId);

		SurveyModelEntity modelEntity = new SurveyModelEntity();
		CommFindEntity<SurveyDetailtb> surveyArray = new CommFindEntity<SurveyDetailtb>();
		List<SurveyDetailtb> lsdt = new ArrayList<>();
		surveyArray.setResult(lsdt);
		
		// 必须先设置count数，再设置limtStart/limitEnd
		int count = rssvsvdtbMapper.countByExample(example);
		log.info("findAll count:" + count);
		surveyArray.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("surverydetail_id ASC");
		
		//首先查询出问卷基本信息
		Surveytb surveytb = surveyService.findDataByKey(surveryId);
		copier.copy(surveytb, modelEntity, null);
		
		List<RssvsvdtbKey> rs = rssvsvdtbMapper.selectByExample(example);
		
		if(rs!=null){
			
			for(RssvsvdtbKey key:rs){
				long detailId = key.getSurverydetailId();
				SurveyDetailtb surveyDetail = surveyDtService.findDataByKey(detailId);
				lsdt.add(surveyDetail);
			}
		}
		
		modelEntity.setSurveyArray(surveyArray);
		return modelEntity;
	}

	@Override
	public int deleteSurveyModelQuestion(SurveyDetailtb surveyDetailtb,Long surveryId) {
		log.info("deleteSurveyQuestion:"+surveyDetailtb.getSurverydetailId()+",for "+surveryId);
		
		RssvsvdtbKey key = new RssvsvdtbKey();
		key.setSurverydetailId(surveyDetailtb.getSurverydetailId());
		key.setSurveryId(surveryId);
		return rssvsvdtbMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int saveSurveyModelQuestion(SurveyDetailtb surveyDetailtb,Long surveryId) {
		log.info("addSurveyQuestion:"+surveyDetailtb.getSurverydetailId()+",for "+surveryId);
		RssvsvdtbKey key = new RssvsvdtbKey();
		key.setSurverydetailId(surveyDetailtb.getSurverydetailId());
		key.setSurveryId(surveryId);
		return rssvsvdtbMapper.insertSelective(key);
	}

	@Override
	public int updateSurveyModelDefaultAnwser(SurveyDetailtb surveyDetailtb,Long surveryId) {
		log.info("updateSurveyDefaultAnwser:"+surveyDetailtb.getSurverydetailId()+",for "+surveryId);
		
		
		return 0;
	}

}
