package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfplansmsHistorytbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SfplansmsHistorytbExample() {
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

        public Criteria andSmsplanIdIsNull() {
            addCriterion("smsplan_id is null");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdIsNotNull() {
            addCriterion("smsplan_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdEqualTo(Long value) {
            addCriterion("smsplan_id =", value, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdNotEqualTo(Long value) {
            addCriterion("smsplan_id <>", value, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdGreaterThan(Long value) {
            addCriterion("smsplan_id >", value, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("smsplan_id >=", value, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdLessThan(Long value) {
            addCriterion("smsplan_id <", value, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdLessThanOrEqualTo(Long value) {
            addCriterion("smsplan_id <=", value, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdIn(List<Long> values) {
            addCriterion("smsplan_id in", values, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdNotIn(List<Long> values) {
            addCriterion("smsplan_id not in", values, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdBetween(Long value1, Long value2) {
            addCriterion("smsplan_id between", value1, value2, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andSmsplanIdNotBetween(Long value1, Long value2) {
            addCriterion("smsplan_id not between", value1, value2, "smsplanId");
            return (Criteria) this;
        }

        public Criteria andPatientidIsNull() {
            addCriterion("patientid is null");
            return (Criteria) this;
        }

        public Criteria andPatientidIsNotNull() {
            addCriterion("patientid is not null");
            return (Criteria) this;
        }

        public Criteria andPatientidEqualTo(Long value) {
            addCriterion("patientid =", value, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidNotEqualTo(Long value) {
            addCriterion("patientid <>", value, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidGreaterThan(Long value) {
            addCriterion("patientid >", value, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidGreaterThanOrEqualTo(Long value) {
            addCriterion("patientid >=", value, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidLessThan(Long value) {
            addCriterion("patientid <", value, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidLessThanOrEqualTo(Long value) {
            addCriterion("patientid <=", value, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidIn(List<Long> values) {
            addCriterion("patientid in", values, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidNotIn(List<Long> values) {
            addCriterion("patientid not in", values, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidBetween(Long value1, Long value2) {
            addCriterion("patientid between", value1, value2, "patientid");
            return (Criteria) this;
        }

        public Criteria andPatientidNotBetween(Long value1, Long value2) {
            addCriterion("patientid not between", value1, value2, "patientid");
            return (Criteria) this;
        }

        public Criteria andSmscontextIsNull() {
            addCriterion("smscontext is null");
            return (Criteria) this;
        }

        public Criteria andSmscontextIsNotNull() {
            addCriterion("smscontext is not null");
            return (Criteria) this;
        }

        public Criteria andSmscontextEqualTo(String value) {
            addCriterion("smscontext =", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextNotEqualTo(String value) {
            addCriterion("smscontext <>", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextGreaterThan(String value) {
            addCriterion("smscontext >", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextGreaterThanOrEqualTo(String value) {
            addCriterion("smscontext >=", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextLessThan(String value) {
            addCriterion("smscontext <", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextLessThanOrEqualTo(String value) {
            addCriterion("smscontext <=", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextLike(String value) {
            addCriterion("smscontext like", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextNotLike(String value) {
            addCriterion("smscontext not like", value, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextIn(List<String> values) {
            addCriterion("smscontext in", values, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextNotIn(List<String> values) {
            addCriterion("smscontext not in", values, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextBetween(String value1, String value2) {
            addCriterion("smscontext between", value1, value2, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmscontextNotBetween(String value1, String value2) {
            addCriterion("smscontext not between", value1, value2, "smscontext");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameIsNull() {
            addCriterion("smstype_name is null");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameIsNotNull() {
            addCriterion("smstype_name is not null");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameEqualTo(String value) {
            addCriterion("smstype_name =", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameNotEqualTo(String value) {
            addCriterion("smstype_name <>", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameGreaterThan(String value) {
            addCriterion("smstype_name >", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("smstype_name >=", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameLessThan(String value) {
            addCriterion("smstype_name <", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameLessThanOrEqualTo(String value) {
            addCriterion("smstype_name <=", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameLike(String value) {
            addCriterion("smstype_name like", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameNotLike(String value) {
            addCriterion("smstype_name not like", value, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameIn(List<String> values) {
            addCriterion("smstype_name in", values, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameNotIn(List<String> values) {
            addCriterion("smstype_name not in", values, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameBetween(String value1, String value2) {
            addCriterion("smstype_name between", value1, value2, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andSmstypeNameNotBetween(String value1, String value2) {
            addCriterion("smstype_name not between", value1, value2, "smstypeName");
            return (Criteria) this;
        }

        public Criteria andPlantypeIsNull() {
            addCriterion("plantype is null");
            return (Criteria) this;
        }

        public Criteria andPlantypeIsNotNull() {
            addCriterion("plantype is not null");
            return (Criteria) this;
        }

        public Criteria andPlantypeEqualTo(Integer value) {
            addCriterion("plantype =", value, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeNotEqualTo(Integer value) {
            addCriterion("plantype <>", value, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeGreaterThan(Integer value) {
            addCriterion("plantype >", value, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("plantype >=", value, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeLessThan(Integer value) {
            addCriterion("plantype <", value, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeLessThanOrEqualTo(Integer value) {
            addCriterion("plantype <=", value, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeIn(List<Integer> values) {
            addCriterion("plantype in", values, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeNotIn(List<Integer> values) {
            addCriterion("plantype not in", values, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeBetween(Integer value1, Integer value2) {
            addCriterion("plantype between", value1, value2, "plantype");
            return (Criteria) this;
        }

        public Criteria andPlantypeNotBetween(Integer value1, Integer value2) {
            addCriterion("plantype not between", value1, value2, "plantype");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPlanfreqIsNull() {
            addCriterion("planfreq is null");
            return (Criteria) this;
        }

        public Criteria andPlanfreqIsNotNull() {
            addCriterion("planfreq is not null");
            return (Criteria) this;
        }

        public Criteria andPlanfreqEqualTo(Integer value) {
            addCriterion("planfreq =", value, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqNotEqualTo(Integer value) {
            addCriterion("planfreq <>", value, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqGreaterThan(Integer value) {
            addCriterion("planfreq >", value, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqGreaterThanOrEqualTo(Integer value) {
            addCriterion("planfreq >=", value, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqLessThan(Integer value) {
            addCriterion("planfreq <", value, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqLessThanOrEqualTo(Integer value) {
            addCriterion("planfreq <=", value, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqIn(List<Integer> values) {
            addCriterion("planfreq in", values, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqNotIn(List<Integer> values) {
            addCriterion("planfreq not in", values, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqBetween(Integer value1, Integer value2) {
            addCriterion("planfreq between", value1, value2, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlanfreqNotBetween(Integer value1, Integer value2) {
            addCriterion("planfreq not between", value1, value2, "planfreq");
            return (Criteria) this;
        }

        public Criteria andPlannumberIsNull() {
            addCriterion("plannumber is null");
            return (Criteria) this;
        }

        public Criteria andPlannumberIsNotNull() {
            addCriterion("plannumber is not null");
            return (Criteria) this;
        }

        public Criteria andPlannumberEqualTo(Integer value) {
            addCriterion("plannumber =", value, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberNotEqualTo(Integer value) {
            addCriterion("plannumber <>", value, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberGreaterThan(Integer value) {
            addCriterion("plannumber >", value, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("plannumber >=", value, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberLessThan(Integer value) {
            addCriterion("plannumber <", value, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberLessThanOrEqualTo(Integer value) {
            addCriterion("plannumber <=", value, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberIn(List<Integer> values) {
            addCriterion("plannumber in", values, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberNotIn(List<Integer> values) {
            addCriterion("plannumber not in", values, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberBetween(Integer value1, Integer value2) {
            addCriterion("plannumber between", value1, value2, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannumberNotBetween(Integer value1, Integer value2) {
            addCriterion("plannumber not between", value1, value2, "plannumber");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeIsNull() {
            addCriterion("plannexttime is null");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeIsNotNull() {
            addCriterion("plannexttime is not null");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeEqualTo(Date value) {
            addCriterion("plannexttime =", value, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeNotEqualTo(Date value) {
            addCriterion("plannexttime <>", value, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeGreaterThan(Date value) {
            addCriterion("plannexttime >", value, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plannexttime >=", value, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeLessThan(Date value) {
            addCriterion("plannexttime <", value, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeLessThanOrEqualTo(Date value) {
            addCriterion("plannexttime <=", value, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeIn(List<Date> values) {
            addCriterion("plannexttime in", values, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeNotIn(List<Date> values) {
            addCriterion("plannexttime not in", values, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeBetween(Date value1, Date value2) {
            addCriterion("plannexttime between", value1, value2, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andPlannexttimeNotBetween(Date value1, Date value2) {
            addCriterion("plannexttime not between", value1, value2, "plannexttime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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