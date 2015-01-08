package com.miaoyou.platform.server.service.sms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Smstb;
import com.miaoyou.platform.server.entity.SmstbExample;
import com.miaoyou.platform.server.entity.Smstypetb;
import com.miaoyou.platform.server.entity.child.SMSAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.SmstbMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SMSService implements SMSServiceIF {

	private static final Log log = LogFactory.getLog(SMSService.class);
	public static BeanCopier copier = BeanCopier.create(Smstb.class,
			SMSAll.class, false);
	@Resource
	SmstbMapper smstbMapper;

	@Resource
	SMSTypeServiceIF sMSTypeService;
	
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	
	@Override
	public SMSAll findDataByKey(Long id) {
		log.info("findDataByKey:" + id);
		SMSAll all = new SMSAll();
		Smstb smstb = smstbMapper.selectByPrimaryKey(id);
		if (smstb != null) {
			copier.copy(smstb, all, null);
			if (smstb.getSmstypeId() != null && smstb.getSmstypeId() > 0) {
				Smstypetb smstype = sMSTypeService.findDataByKey(smstb
						.getSmstypeId());
				all.setSmstypetb(smstype);
			}
		}
		return all;
	}

	@Override
	public CommFindEntity<SMSAll> findAll(Pager page, String conditionSql) {
		log.info("findAll:" + conditionSql);
		CommFindEntity<SMSAll> result = new CommFindEntity<SMSAll>();
		List<SMSAll> lsArray = new ArrayList<>();
		result.setResult(lsArray);

		SmstbExample example = new SmstbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			example.createCriteria().addConditionSql(conditionSql);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = smstbMapper.countByExample(example);
		page.setCount(count);
		result.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("sms_id DESC");

		List<Smstb> lsAll = smstbMapper.selectByExample(example);
		if (lsAll != null) {
			for (Smstb smstb : lsAll) {
				SMSAll smsall = new SMSAll();
				copier.copy(smstb, smsall, null);
				if (smstb.getSmstypeId() != null && smstb.getSmstypeId() > 0) {
					Smstypetb smstype = sMSTypeService.findDataByKey(smstb
							.getSmstypeId());
					smsall.setSmstypetb(smstype);
				}
				lsArray.add(smsall);
			}
		}

		return result;
	}

	@Override
	public int saveData(SMSAll bean) {
		log.info("SMSAll:" + bean.getSmsName());
		
		long key = pkgeneratorService.getPrimaryKey("smstb",
				"sms_id");
		bean.setSmsId(key);
		
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSmsName());
		bean.setZujima(zujima);
		bean.setCreatedate(new Date());

		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails sessionuser = (CommUserDetails) principal;
				UserAll session = sessionuser.getUserSessionEntity();
				if (session != null) {
					bean.setCreateperson(session.getUserName());
				}
			}
		}
		
		
		return smstbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		return smstbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateData(SMSAll bean) {
		log.info("updateData:" + bean.getSmsId());
		bean.setUpdatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSmsName());
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
		return smstbMapper.updateByPrimaryKeySelective(bean);
	}

}
