/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miaoyou.platform.server.service.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.UsertbExample;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.UsertbMapper;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.ToolHelper;

/**
 *
 * @author 305027939
 */
@Service
public class UserService implements UserServiceIF {

    public static BeanCopier copier = BeanCopier.create(Usertb.class, UserAll.class, false);
    private static final Log log = LogFactory.getLog(UserService.class);
    @Resource
    private UsertbMapper mapper;
    @Resource
    private RolesServiceIF roleIF;

    @Resource
    DepartmentServiceIF departmentService;

    @Override
    public Usertb findUser(Integer id) {
        UsertbExample userExample = new UsertbExample();
        userExample.createCriteria().andUserIdEqualTo(id);
        List<Usertb> users = mapper.selectByExample(userExample);
        for (Usertb u : users) {
            log.debug("found user:" + u.getUserName());
        }
 
        if(users == null || users.size() <= 0) {
            return null;
        }else {
            Usertb u = users.get(0);
            u.setUserPassword(new String(ToolHelper.decryptBASE64(u.getUserPassword().getBytes())));
            return u;
        }
    }

    @Override
    public UserAll findUserAll(Integer id) {

        Usertb users = mapper.selectByPrimaryKey(id);
        UserAll all = new UserAll();
        if (users != null) {
            log.debug("found user:" + users.getUserName());
            copier.copy(users, all, null);
            if (users.getDepartmentId() != null) {
                all.setDepartmenttb((departmentService.findDepartmentById(users.getDepartmentId())));
            }
            all.setUserPassword(new String(ToolHelper.decryptBASE64(users.getUserPassword().getBytes())));
        }
        return all;
    }

    @Override
    public CommFindEntity<UserAll> findAllUsers(Pager page, String conditionSql) {
        UsertbExample exam = new UsertbExample();
        CommFindEntity<UserAll> findEntity = new CommFindEntity();
        exam.createCriteria().addConditionSql(conditionSql);

        //必须先设置count数，再设置limtStart/limitEnd
        int count = mapper.countByExample(exam);
        page.setCount(count);
        exam.setLimitStart(page.getStartDataIndex());
        exam.setLimitEnd(page.getPageSize());
        //排序
        exam.setOrderByClause("user_id DESC");

        //查询数据库
        List<Usertb> users = mapper.selectByExample(exam);

        List<UserAll> usersAll = new ArrayList<UserAll>();

        for (Usertb user : users) {
            UserAll userAll = new UserAll();
            copier.copy(user, userAll, null);
            log.debug("found user:" + user.getUserName());
            if (user.getDepartmentId() != null) {
                userAll.setDepartmenttb(departmentService.findDepartmentById(user.getDepartmentId()));
            }
            userAll.setUserPassword(new String(ToolHelper.decryptBASE64(user.getUserPassword().getBytes())));
            usersAll.add(userAll);
        }

        findEntity.setCount(count);
        findEntity.setResult(usersAll);

        return findEntity;
    }

    @Override
    public CommFindEntity<UserAll> findAllUsers(Pager page) {
        UsertbExample exam = new UsertbExample();
        exam.createCriteria().andDeleteFlagEqualTo(0);
        
        CommFindEntity<UserAll> findEntity = new CommFindEntity<UserAll>();
        //必须先设置count数，再设置limtStart/limitEnd
        int count = mapper.countByExample(exam);
        page.setCount(count);
        exam.setLimitStart(page.getStartDataIndex());
        exam.setLimitEnd(page.getPageSize());

        //排序
        exam.setOrderByClause("user_id DESC");

        //查询数据库
        List<Usertb> users = mapper.selectByExample(exam);
        List<UserAll> usersAll = new ArrayList<UserAll>();

        for (Usertb user : users) {
            UserAll userAll = new UserAll();
            copier.copy(user, userAll, null);
            log.debug("found user:" + user.getUserName());
            if (user.getDepartmentId() != null) {
                userAll.setDepartmenttb(departmentService.findDepartmentById(user.getDepartmentId()));
            }
            userAll.setUserPassword(new String(ToolHelper.decryptBASE64(user.getUserPassword().getBytes())));
            usersAll.add(userAll);
        }

        findEntity.setCount(count);
        findEntity.setResult(usersAll);

        return findEntity;
    }

    @Override
    public int saveUser(Usertb user) {
        log.debug("insert user:" + user.getUserName());
        user.setUserPassword(new String(ToolHelper.encryptBASE64(user.getUserPassword().getBytes())));
        return mapper.insertSelective(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        log.debug("delete user:" + userId);
        Usertb usertb = mapper.selectByPrimaryKey(userId);
        usertb.setDeleteFlag(1);
        return mapper.updateByPrimaryKeySelective(usertb);
    }

    @Override
    public int updateUser(Usertb user) {
        user.setUserPassword(new String(ToolHelper.encryptBASE64(user.getUserPassword().getBytes())));
        log.debug("update user:" + user.getUserId());
        return mapper.updateByPrimaryKeySelective(user);
    }

}
