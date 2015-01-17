package com.miaoyou.platform.server.service.plan;

import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.PlanHisAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.CommServiceIF;

public interface SFPlanHisServiceIF extends CommServiceIF<PlanHisAll,Long>{
	public CommFindEntity<Surveytb> findSurveyByPlanIdForCalling(int status,Long planId);
	public CommFindEntity<Surveytb> findSurveyByPlanId(Long planId);
	public int saveDataForPatientSurvey(Long planId,Long surveryId);
	public int deleteDataByKeyForPatientSurvey(Long planId,Long surveryId);
}
