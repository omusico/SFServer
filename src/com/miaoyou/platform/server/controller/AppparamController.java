
package com.miaoyou.platform.server.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.Appparamtb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.CommServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 *
 * @author 305027939
 */
@Controller
@RequestMapping("/appparam/*")
public class AppparamController {

  private static final Log log = LogFactory.getLog(AppparamController.class);
    @Autowired
    @Qualifier("appparamService")
    private CommServiceIF<Appparamtb, Integer> appparamService;

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public @ResponseBody
    Appparamtb findDataByKey(@PathVariable Integer id) {
        log.debug("AppparamtbController,findDataByKey:" + id);
        return appparamService.findDataByKey(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "")
    public @ResponseBody
    CommFindEntity<Appparamtb> findAll(
            @RequestParam(value = "psi", defaultValue = "1") int startIndex,
            @RequestParam(value = "pst", defaultValue = "20") int perPage,
            @RequestParam(value = "type", defaultValue = "") String type,  
            @RequestParam(value = "key", defaultValue = "") String key) {
        log.debug("AppparamtbController,getAllUser.startIndex:" + startIndex + ",perPage:" + perPage);
        Pager pager = new Pager(startIndex, perPage);
        
        //构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
        StringBuilder sb = new StringBuilder();
        String andSplit = " and ";
        if(!type.trim().equals("")){
        	sb.append("appparam_type").append(" = ").append("\""+type+"\"").append(andSplit);
        }
        if(!key.trim().equals("")){
        	sb.append("(appparam_name").append(" = ").append("\"%"+key+"%\"").append(" or ").append("zujima").append(" like ").append("\""+key+"%\")").append(andSplit);
        }
       
        if(sb.length()>andSplit.length()){
        	sb.delete((sb.length()-andSplit.length()), sb.length()-1);
        }
        log.debug("sql:"+sb);
        
        return appparamService.findAll(pager, sb.toString());
    }

    @RequestMapping(method = RequestMethod.POST, value = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Appparamtb> saveData(@RequestBody Appparamtb bean) {
        log.debug("AppparamtbController,saveData:" + bean.getAppparamName());
        ComResponse<Appparamtb> comResponse = new ComResponse<Appparamtb>();
        try {
            int result = appparamService.saveData(bean);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
            comResponse.setResponseEntity(bean);
        } catch (Exception e) {
            log.equals(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage(e.getMessage());
        }
        log.debug("AppparamtbController,saveData:" + comResponse.getResponseStatus());
        return comResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Appparamtb> deleteDataByKey(@PathVariable Integer id) {
        log.debug("AppparamtbController,deleteDataByKey:" + id);
        ComResponse<Appparamtb> comResponse = new ComResponse<Appparamtb>();
        try {
            int result = appparamService.deleteDataByKey(id);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
        } catch (Exception e) {
            log.equals(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage(e.getMessage());
        }
        log.debug("AppparamtbController,deleteDataByKey:" + comResponse.getResponseStatus());
        return comResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Appparamtb> updateData(@RequestBody Appparamtb bean) {
        log.debug("AppparamtbController,updateData:" + bean.getAppparamId());
        ComResponse<Appparamtb> comResponse = new ComResponse<Appparamtb>();
        try {
            int result = appparamService.updateData(bean);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
            comResponse.setResponseEntity(bean);
        } catch (Exception e) {
            log.equals(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage(e.getMessage());
        }
        log.debug("AppparamtbController,updateData:" + comResponse.getResponseStatus());
        return comResponse;
    }
}
