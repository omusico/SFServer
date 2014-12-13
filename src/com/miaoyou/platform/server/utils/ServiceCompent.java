/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miaoyou.platform.server.utils;

/**
 *
 * @author 305027939
 */
public class ServiceCompent {

    public Object createBusinessObject(Class classType) {
        return BeanFactory.instance().createBean(classType);
    }
    
        public Object createBusinessObject(String beanName) {
        return BeanFactory.instance().createBean(beanName);
    }
}
