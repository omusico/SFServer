/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service.log;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Logtb;
import com.miaoyou.platform.server.entity.LogtbExample;
import com.miaoyou.platform.server.entity.LogtbExample.Criteria;
import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.LogtbMapper;
import com.miaoyou.platform.server.utils.Pager;

/**
 *
 * @author li
 */
@Service
public class LogService implements LogIF {

    private static final Log log = LogFactory.getLog(LogService.class);

    private Timestamp startDateTime, endDateTime;

    @Resource
    private LogtbMapper logMapper;

    /**
     * save the log
     *
     * @param operateContent
     * @return
     */
    @Override
    public int saveLog(String operateContent) {
        String username = "";
        String userDepartment = "";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal
                != null) {
            if (principal instanceof CommUserDetails) {
                CommUserDetails user = (CommUserDetails) principal;
                UserAll session = user.getUserSessionEntity();
                Departmenttb departmenttb = session.getDepartmenttb();
                if (session != null) {
                    log.info("username is" + session.getUserName() + " fount.");
                } else {
                    log.error("user is not exist.");
                }
                if (departmenttb != null) {
                    log.info("the department of user," + departmenttb.getDepartmentName() + "fount");
                } else {
                    log.error("the department of user is not exist");
                }
                username = session.getUserName();
                userDepartment = departmenttb.getDepartmentName();
            } else {
                log.error(" principal is not a  UserDetails object!");
                return -1;
            }
        } else {
            log.error("principal is null!");
            return -1;
        }
        Logtb newLog = new Logtb();

        newLog.setContent(operateContent);

        newLog.setUserDepartment(userDepartment);

        newLog.setOperateName(username);
        return logMapper.insertSelective(newLog);

    }

    @Override
    public CommFindEntity<Logtb> findAll(Pager page, String conditionSql, String startDate, String endDate) {
        LogtbExample example = new LogtbExample();
        CommFindEntity<Logtb> allData = new CommFindEntity<Logtb>();
        Criteria cra = example.createCriteria();

        if (conditionSql != null && !conditionSql.trim().equals("")) {
            cra = cra.addConditionSql(conditionSql);

        }
        if (startDate != null && !startDate.trim().equals("")) {

            startDateTime = Timestamp.valueOf(startDate);
            cra = cra.andOperateDateGreaterThanOrEqualTo(startDateTime);
        }
        if (endDate != null && !endDate.trim().equals("")) {

            endDateTime = Timestamp.valueOf(endDate);
            cra.andOperateDateLessThanOrEqualTo(endDateTime);
        }

        int count = logMapper.countByExample(example);
        log.debug("found log total:" + count);
        page.setCount(count);
        example.setLimitStart(page.getStartDataIndex());
        example.setLimitEnd(page.getPageSize());

        example.setOrderByClause("operate_date DESC");

        List<Logtb> results = logMapper.selectByExample(example);
        allData.setCount(count);
        allData.setResult(results);
        return allData;

    }

}
