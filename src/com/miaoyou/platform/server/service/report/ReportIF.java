package com.miaoyou.platform.server.service.report;

import com.miaoyou.platform.server.entity.child.ReportTelDpEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;


public interface ReportIF {

	public CommFindEntity<ReportTelDpEntity> findPlanTelDpReport(int departmentId,String startDate,String endDate);
	
	public CommFindEntity<ReportTelDpEntity> findSurveyTelDpReport(long surveyId,int departmentId,String startDate,String endDate);

	public CommFindEntity<ReportTelDpEntity> findPlanSmsDpReport(int departmentId,String startDate,String endDate);
}
