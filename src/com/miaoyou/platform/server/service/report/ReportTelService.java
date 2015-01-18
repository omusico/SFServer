package com.miaoyou.platform.server.service.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.DepartmenttbExample;
import com.miaoyou.platform.server.entity.DepartmenttbExample.Criteria;
import com.miaoyou.platform.server.entity.PatientsurveytbExample;
import com.miaoyou.platform.server.entity.SfplanHistorytbExample;
import com.miaoyou.platform.server.entity.SfplansmsHistorytbExample;
import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.UsertbExample;
import com.miaoyou.platform.server.entity.child.ReportTelDpEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.DepartmenttbMapper;
import com.miaoyou.platform.server.mapper.PatientsurveytbMapper;
import com.miaoyou.platform.server.mapper.SfplanHistorytbMapper;
import com.miaoyou.platform.server.mapper.SfplansmsHistorytbMapper;
import com.miaoyou.platform.server.mapper.UsertbMapper;
import com.miaoyou.platform.server.utils.Arith;
import com.miaoyou.platform.server.utils.DateHelper;

@Service
public class ReportTelService implements ReportIF {

	private static final Log log = LogFactory.getLog(ReportTelService.class);
	@Resource
	DepartmenttbMapper departmenttbMapper;
	
	@Resource
	SfplanHistorytbMapper sfplanHistorytbMapper;
	
    @Resource
    private UsertbMapper userMapper;
    
	@Resource
	PatientsurveytbMapper patientsurveytbMapper;
	
	@Resource
	SfplansmsHistorytbMapper sfplansmsHistorytbMapper;
	
	@Override
	public CommFindEntity<ReportTelDpEntity> findPlanTelDpReport(
			int departmentId, String startDate, String endDate) {
		log.info("findTelDpReport,departmentId:"+departmentId+",startDate:"+startDate+",endDate:"+endDate);
		CommFindEntity<ReportTelDpEntity> result = new CommFindEntity<ReportTelDpEntity>();
		List<ReportTelDpEntity> reportLs = new ArrayList<>();
		result.setResult(reportLs);
		
		DepartmenttbExample dpExample = new DepartmenttbExample();
		Criteria crite = dpExample.createCriteria();
		if(departmentId>0){
			crite.andDepartmentIdEqualTo(departmentId);
		}
		
		List<Departmenttb> dpLs = departmenttbMapper.selectByExample(dpExample);
		if(dpLs!=null){
			for(Departmenttb depart:dpLs){
				ReportTelDpEntity report = new ReportTelDpEntity();
				//得到科室
				report.setDepartmenttb(depart);
				
				int departInt = depart.getDepartmentId();
				UsertbExample example = new UsertbExample();
				example.createCriteria().andDepartmentIdEqualTo(departInt);
				List<Usertb> userLs = userMapper.selectByExample(example);
				if(userLs!=null){
					List<Integer> userArray = new ArrayList<>();
					for(Usertb user:userLs){
						userArray.add(user.getUserId());
					}
					if(userArray.size()<=0){
						continue;
					}
					SfplanHistorytbExample sfplanFinishexample = new SfplanHistorytbExample();
					com.miaoyou.platform.server.entity.SfplanHistorytbExample.Criteria finishedCri = sfplanFinishexample.createCriteria();
					finishedCri.andUserIdIn(userArray).andStatusEqualTo(1);
					if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						finishedCri.andUpdatedateBetween(startd, endD);
					}else if(endDate!=null&&!endDate.trim().equals("")){
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						finishedCri.andUpdatedateLessThanOrEqualTo(endD);
					}else if(startDate!=null&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						finishedCri.andUpdatedateGreaterThanOrEqualTo(startd);
					}
					
                   int finishedCount = sfplanHistorytbMapper.countByExample(sfplanFinishexample);
					
					SfplanHistorytbExample sfplanOverdueexample = new SfplanHistorytbExample();
					com.miaoyou.platform.server.entity.SfplanHistorytbExample.Criteria overdueCri = sfplanOverdueexample.createCriteria();
					overdueCri.andUserIdIn(userArray).andStatusEqualTo(3);
					if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						overdueCri.andUpdatedateBetween(startd, endD);
					}else if(endDate!=null&&!endDate.trim().equals("")){
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						overdueCri.andUpdatedateLessThanOrEqualTo(endD);
					}else if(startDate!=null&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						overdueCri.andUpdatedateGreaterThanOrEqualTo(startd);
					}
					
					int overdueCount = sfplanHistorytbMapper.countByExample(sfplanOverdueexample);
					
					SfplanHistorytbExample sfplanCancelexample = new SfplanHistorytbExample();
					com.miaoyou.platform.server.entity.SfplanHistorytbExample.Criteria cancelCri = sfplanCancelexample.createCriteria();
					cancelCri.andUserIdIn(userArray).andStatusEqualTo(2);
					if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						cancelCri.andUpdatedateBetween(startd, endD);
					}else if(endDate!=null&&!endDate.trim().equals("")){
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						cancelCri.andUpdatedateLessThanOrEqualTo(endD);
					}else if(startDate!=null&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						cancelCri.andUpdatedateGreaterThanOrEqualTo(startd);
					}
					int cancelCount = sfplanHistorytbMapper.countByExample(sfplanCancelexample);
					
					
					int count = cancelCount+finishedCount+overdueCount;
					log.debug(depart.getDepartmentName()+" count:"+count+",finished:"+finishedCount+",cancelCount:"+cancelCount+",overdueCount:"+overdueCount);
					report.setCancel(cancelCount);
					report.setFinishActual(finishedCount);
					report.setOverdue(overdueCount);
					report.setFinishPlan(count);
					
					double finishedPercent = count==0?0:Arith.decimal((double)finishedCount*100/count,2);
					double cancelPercent = count==0?0:Arith.decimal((double)cancelCount*100/count,2);
					double overduePercent = count==0?0:Arith.decimal((double)overdueCount*100/count,2);
					
					report.setCancelPercent(cancelPercent+"%");
					report.setFinishActualPercent(finishedPercent+"%");
					report.setOverduePercent(overduePercent+"%");
					
					reportLs.add(report);
					
				}
				
			}
		}
		result.setCount(reportLs.size());
		return result;
	}

	@Override
	public CommFindEntity<ReportTelDpEntity> findSurveyTelDpReport(
			long surveyId, int departmentId, String startDate, String endDate) {
		log.info("findSurveyTelDpReport,departmentId:"+departmentId+",startDate:"+startDate+",endDate:"+endDate+",surveyId:"+surveyId);
		CommFindEntity<ReportTelDpEntity> result = new CommFindEntity<ReportTelDpEntity>();
		List<ReportTelDpEntity> reportLs = new ArrayList<>();
		result.setResult(reportLs);
		
		DepartmenttbExample dpExample = new DepartmenttbExample();
		Criteria crite = dpExample.createCriteria();
		if(departmentId>0){
			crite.andDepartmentIdEqualTo(departmentId);
		}
		
		List<Departmenttb> dpLs = departmenttbMapper.selectByExample(dpExample);
		if(dpLs!=null){
			for(Departmenttb depart:dpLs){
				ReportTelDpEntity report = new ReportTelDpEntity();
				//得到科室
				report.setDepartmenttb(depart);
				
				int departInt = depart.getDepartmentId();
				
				PatientsurveytbExample finishedSurve = new PatientsurveytbExample();
				com.miaoyou.platform.server.entity.PatientsurveytbExample.Criteria finishedctri = finishedSurve.createCriteria();
				finishedctri.andDepartmentIdEqualTo(departInt).andStatusEqualTo(1);
				if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
					Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
					Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
					finishedctri.andUpdatedateBetween(startd, endD);
				}else if(endDate!=null&&!endDate.trim().equals("")){
					Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
					finishedctri.andUpdatedateLessThanOrEqualTo(endD);
				}else if(startDate!=null&&!startDate.trim().equals("")){
					Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
					finishedctri.andUpdatedateGreaterThanOrEqualTo(startd);
				}
				if(surveyId>0){
					finishedctri.andSurveryIdEqualTo(surveyId);
				}
				int  finishedCount= patientsurveytbMapper.countByExample(finishedSurve);
				
				PatientsurveytbExample cancelSurveExample = new PatientsurveytbExample();
				com.miaoyou.platform.server.entity.PatientsurveytbExample.Criteria cancelSurveCrit = cancelSurveExample.createCriteria();
				cancelSurveCrit.andDepartmentIdEqualTo(departInt).andStatusEqualTo(2);
				if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
					Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
					Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
					cancelSurveCrit.andUpdatedateBetween(startd, endD);
				}else if(endDate!=null&&!endDate.trim().equals("")){
					Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
					cancelSurveCrit.andUpdatedateLessThanOrEqualTo(endD);
				}else if(startDate!=null&&!startDate.trim().equals("")){
					Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
					cancelSurveCrit.andUpdatedateGreaterThanOrEqualTo(startd);
				}
				if(surveyId>0){
					cancelSurveCrit.andSurveryIdEqualTo(surveyId);
				}
				int  cancelCount= patientsurveytbMapper.countByExample(cancelSurveExample);
				

				PatientsurveytbExample overdueSurveExample = new PatientsurveytbExample();
				com.miaoyou.platform.server.entity.PatientsurveytbExample.Criteria overdueSurveCrit = overdueSurveExample.createCriteria();
				overdueSurveCrit.andDepartmentIdEqualTo(departInt).andStatusEqualTo(3);
				if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
					Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
					Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
					overdueSurveCrit.andUpdatedateBetween(startd, endD);
				}else if(endDate!=null&&!endDate.trim().equals("")){
					Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
					overdueSurveCrit.andUpdatedateLessThanOrEqualTo(endD);
				}else if(startDate!=null&&!startDate.trim().equals("")){
					Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
					overdueSurveCrit.andUpdatedateGreaterThanOrEqualTo(startd);
				}
				if(surveyId>0){
					overdueSurveCrit.andSurveryIdEqualTo(surveyId);
				}
				int  overdueCount= patientsurveytbMapper.countByExample(overdueSurveExample);
				
					int count = cancelCount+finishedCount+overdueCount;
					log.debug(depart.getDepartmentName()+" count:"+count+",finished:"+finishedCount+",cancelCount:"+cancelCount+",overdueCount:"+overdueCount);
					report.setCancel(cancelCount);
					report.setFinishActual(finishedCount);
					report.setOverdue(overdueCount);
					report.setFinishPlan(count);
					
					double finishedPercent = count==0?0:Arith.decimal((double)finishedCount*100/count,2);
					double cancelPercent = count==0?0:Arith.decimal((double)cancelCount*100/count,2);
					double overduePercent = count==0?0:Arith.decimal((double)overdueCount*100/count,2);
					
					report.setCancelPercent(cancelPercent+"%");
					report.setFinishActualPercent(finishedPercent+"%");
					report.setOverduePercent(overduePercent+"%");
					
					reportLs.add(report);
					
				}
				
			}
		result.setCount(reportLs.size());
		return result;
	}

	@Override
	public CommFindEntity<ReportTelDpEntity> findPlanSmsDpReport(
			int departmentId, String startDate, String endDate) {
		log.info("findPlanSmsDpReport,departmentId:"+departmentId+",startDate:"+startDate+",endDate:"+endDate);
		CommFindEntity<ReportTelDpEntity> result = new CommFindEntity<ReportTelDpEntity>();
		List<ReportTelDpEntity> reportLs = new ArrayList<>();
		result.setResult(reportLs);
		
		DepartmenttbExample dpExample = new DepartmenttbExample();
		Criteria crite = dpExample.createCriteria();
		if(departmentId>0){
			crite.andDepartmentIdEqualTo(departmentId);
		}
		
		List<Departmenttb> dpLs = departmenttbMapper.selectByExample(dpExample);
		if(dpLs!=null){
			for(Departmenttb depart:dpLs){
				ReportTelDpEntity report = new ReportTelDpEntity();
				//得到科室
				report.setDepartmenttb(depart);
				
				int departInt = depart.getDepartmentId();
				UsertbExample example = new UsertbExample();
				example.createCriteria().andDepartmentIdEqualTo(departInt);
				List<Usertb> userLs = userMapper.selectByExample(example);
				if(userLs!=null){
					List<Integer> userArray = new ArrayList<>();
					for(Usertb user:userLs){
						userArray.add(user.getUserId());
					}
					if(userArray.size()<=0){
						continue;
					}
					
					SfplansmsHistorytbExample sfplanFinishexample = new SfplansmsHistorytbExample();
					com.miaoyou.platform.server.entity.SfplansmsHistorytbExample.Criteria finishedCri = sfplanFinishexample.createCriteria();
					finishedCri.andUserIdIn(userArray).andStatusEqualTo(1);
					if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						finishedCri.andUpdatedateBetween(startd, endD);
					}else if(endDate!=null&&!endDate.trim().equals("")){
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						finishedCri.andUpdatedateLessThanOrEqualTo(endD);
					}else if(startDate!=null&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						finishedCri.andUpdatedateGreaterThanOrEqualTo(startd);
					}
					
                   int finishedCount = sfplansmsHistorytbMapper.countByExample(sfplanFinishexample);
					
                   SfplansmsHistorytbExample sfplanOverdueexample = new SfplansmsHistorytbExample();
					com.miaoyou.platform.server.entity.SfplansmsHistorytbExample.Criteria overdueCri = sfplanOverdueexample.createCriteria();
					overdueCri.andUserIdIn(userArray).andStatusEqualTo(3);
					if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						overdueCri.andUpdatedateBetween(startd, endD);
					}else if(endDate!=null&&!endDate.trim().equals("")){
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						overdueCri.andUpdatedateLessThanOrEqualTo(endD);
					}else if(startDate!=null&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						overdueCri.andUpdatedateGreaterThanOrEqualTo(startd);
					}
					
					int overdueCount = sfplansmsHistorytbMapper.countByExample(sfplanOverdueexample);
					
					SfplansmsHistorytbExample sfplanCancelexample = new SfplansmsHistorytbExample();
					com.miaoyou.platform.server.entity.SfplansmsHistorytbExample.Criteria cancelCri = sfplanCancelexample.createCriteria();
					cancelCri.andUserIdIn(userArray).andStatusEqualTo(2);
					if(startDate!=null&&endDate!=null&&!endDate.trim().equals("")&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						cancelCri.andUpdatedateBetween(startd, endD);
					}else if(endDate!=null&&!endDate.trim().equals("")){
						Date endD = DateHelper.getStringtoDate(endDate, "yyyy-MM-dd");
						cancelCri.andUpdatedateLessThanOrEqualTo(endD);
					}else if(startDate!=null&&!startDate.trim().equals("")){
						Date startd = DateHelper.getStringtoDate(startDate, "yyyy-MM-dd");
						cancelCri.andUpdatedateGreaterThanOrEqualTo(startd);
					}
					int cancelCount = sfplansmsHistorytbMapper.countByExample(sfplanCancelexample);
					
					
					int count = cancelCount+finishedCount+overdueCount;
					log.debug(depart.getDepartmentName()+" count:"+count+",finished:"+finishedCount+",cancelCount:"+cancelCount+",overdueCount:"+overdueCount);
					report.setCancel(cancelCount);
					report.setFinishActual(finishedCount);
					report.setOverdue(overdueCount);
					report.setFinishPlan(count);
					
					double finishedPercent = count==0?0:Arith.decimal((double)finishedCount*100/count,2);
					double cancelPercent = count==0?0:Arith.decimal((double)cancelCount*100/count,2);
					double overduePercent = count==0?0:Arith.decimal((double)overdueCount*100/count,2);
					
					report.setCancelPercent(cancelPercent+"%");
					report.setFinishActualPercent(finishedPercent+"%");
					report.setOverduePercent(overduePercent+"%");
					
					reportLs.add(report);
					
				}
				
			}
		}
		result.setCount(reportLs.size());
		return result;
	}

}
