package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmstbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SmstbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setGroupby(String groupby) {
        this.groupby=groupby;
    }

    public String getGroupby() {
        return groupby;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSmsIdIsNull() {
            addCriterion("sms_id is null");
            return (Criteria) this;
        }

        public Criteria andSmsIdIsNotNull() {
            addCriterion("sms_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmsIdEqualTo(Long value) {
            addCriterion("sms_id =", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotEqualTo(Long value) {
            addCriterion("sms_id <>", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdGreaterThan(Long value) {
            addCriterion("sms_id >", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sms_id >=", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdLessThan(Long value) {
            addCriterion("sms_id <", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdLessThanOrEqualTo(Long value) {
            addCriterion("sms_id <=", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdIn(List<Long> values) {
            addCriterion("sms_id in", values, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotIn(List<Long> values) {
            addCriterion("sms_id not in", values, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdBetween(Long value1, Long value2) {
            addCriterion("sms_id between", value1, value2, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotBetween(Long value1, Long value2) {
            addCriterion("sms_id not between", value1, value2, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdIsNull() {
            addCriterion("smstype_id is null");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdIsNotNull() {
            addCriterion("smstype_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdEqualTo(Long value) {
            addCriterion("smstype_id =", value, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdNotEqualTo(Long value) {
            addCriterion("smstype_id <>", value, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdGreaterThan(Long value) {
            addCriterion("smstype_id >", value, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("smstype_id >=", value, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdLessThan(Long value) {
            addCriterion("smstype_id <", value, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdLessThanOrEqualTo(Long value) {
            addCriterion("smstype_id <=", value, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdIn(List<Long> values) {
            addCriterion("smstype_id in", values, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdNotIn(List<Long> values) {
            addCriterion("smstype_id not in", values, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdBetween(Long value1, Long value2) {
            addCriterion("smstype_id between", value1, value2, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmstypeIdNotBetween(Long value1, Long value2) {
            addCriterion("smstype_id not between", value1, value2, "smstypeId");
            return (Criteria) this;
        }

        public Criteria andSmsNameIsNull() {
            addCriterion("sms_name is null");
            return (Criteria) this;
        }

        public Criteria andSmsNameIsNotNull() {
            addCriterion("sms_name is not null");
            return (Criteria) this;
        }

        public Criteria andSmsNameEqualTo(String value) {
            addCriterion("sms_name =", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameNotEqualTo(String value) {
            addCriterion("sms_name <>", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameGreaterThan(String value) {
            addCriterion("sms_name >", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameGreaterThanOrEqualTo(String value) {
            addCriterion("sms_name >=", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameLessThan(String value) {
            addCriterion("sms_name <", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameLessThanOrEqualTo(String value) {
            addCriterion("sms_name <=", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameLike(String value) {
            addCriterion("sms_name like", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameNotLike(String value) {
            addCriterion("sms_name not like", value, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameIn(List<String> values) {
            addCriterion("sms_name in", values, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameNotIn(List<String> values) {
            addCriterion("sms_name not in", values, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameBetween(String value1, String value2) {
            addCriterion("sms_name between", value1, value2, "smsName");
            return (Criteria) this;
        }

        public Criteria andSmsNameNotBetween(String value1, String value2) {
            addCriterion("sms_name not between", value1, value2, "smsName");
            return (Criteria) this;
        }

        public Criteria andZujimaIsNull() {
            addCriterion("zujima is null");
            return (Criteria) this;
        }

        public Criteria andZujimaIsNotNull() {
            addCriterion("zujima is not null");
            return (Criteria) this;
        }

        public Criteria andZujimaEqualTo(String value) {
            addCriterion("zujima =", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaNotEqualTo(String value) {
            addCriterion("zujima <>", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaGreaterThan(String value) {
            addCriterion("zujima >", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaGreaterThanOrEqualTo(String value) {
            addCriterion("zujima >=", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaLessThan(String value) {
            addCriterion("zujima <", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaLessThanOrEqualTo(String value) {
            addCriterion("zujima <=", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaLike(String value) {
            addCriterion("zujima like", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaNotLike(String value) {
            addCriterion("zujima not like", value, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaIn(List<String> values) {
            addCriterion("zujima in", values, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaNotIn(List<String> values) {
            addCriterion("zujima not in", values, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaBetween(String value1, String value2) {
            addCriterion("zujima between", value1, value2, "zujima");
            return (Criteria) this;
        }

        public Criteria andZujimaNotBetween(String value1, String value2) {
            addCriterion("zujima not between", value1, value2, "zujima");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatepersonIsNull() {
            addCriterion("createperson is null");
            return (Criteria) this;
        }

        public Criteria andCreatepersonIsNotNull() {
            addCriterion("createperson is not null");
            return (Criteria) this;
        }

        public Criteria andCreatepersonEqualTo(String value) {
            addCriterion("createperson =", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonNotEqualTo(String value) {
            addCriterion("createperson <>", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonGreaterThan(String value) {
            addCriterion("createperson >", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonGreaterThanOrEqualTo(String value) {
            addCriterion("createperson >=", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonLessThan(String value) {
            addCriterion("createperson <", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonLessThanOrEqualTo(String value) {
            addCriterion("createperson <=", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonLike(String value) {
            addCriterion("createperson like", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonNotLike(String value) {
            addCriterion("createperson not like", value, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonIn(List<String> values) {
            addCriterion("createperson in", values, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonNotIn(List<String> values) {
            addCriterion("createperson not in", values, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonBetween(String value1, String value2) {
            addCriterion("createperson between", value1, value2, "createperson");
            return (Criteria) this;
        }

        public Criteria andCreatepersonNotBetween(String value1, String value2) {
            addCriterion("createperson not between", value1, value2, "createperson");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updatedate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterion("updatedate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterion("updatedate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterion("updatedate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("updatedate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterion("updatedate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterion("updatedate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterion("updatedate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterion("updatedate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterion("updatedate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterion("updatedate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonIsNull() {
            addCriterion("updateperson is null");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonIsNotNull() {
            addCriterion("updateperson is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonEqualTo(String value) {
            addCriterion("updateperson =", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonNotEqualTo(String value) {
            addCriterion("updateperson <>", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonGreaterThan(String value) {
            addCriterion("updateperson >", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonGreaterThanOrEqualTo(String value) {
            addCriterion("updateperson >=", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonLessThan(String value) {
            addCriterion("updateperson <", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonLessThanOrEqualTo(String value) {
            addCriterion("updateperson <=", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonLike(String value) {
            addCriterion("updateperson like", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonNotLike(String value) {
            addCriterion("updateperson not like", value, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonIn(List<String> values) {
            addCriterion("updateperson in", values, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonNotIn(List<String> values) {
            addCriterion("updateperson not in", values, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonBetween(String value1, String value2) {
            addCriterion("updateperson between", value1, value2, "updateperson");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonNotBetween(String value1, String value2) {
            addCriterion("updateperson not between", value1, value2, "updateperson");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("ext2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("ext2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("ext2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("ext2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("ext2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("ext2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("ext2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("ext2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("ext2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("ext2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("ext2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("ext2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("ext2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("ext3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("ext3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("ext3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("ext3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("ext3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("ext3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("ext3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("ext3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("ext3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("ext3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("ext3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("ext3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("ext3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("ext3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria addConditionSql(String addConditionSql) {
            addCriterion(addConditionSql);
            return this;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}