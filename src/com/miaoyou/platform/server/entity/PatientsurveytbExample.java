package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientsurveytbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public PatientsurveytbExample() {
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

        public Criteria andPatientsurveyIdIsNull() {
            addCriterion("patientsurvey_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdIsNotNull() {
            addCriterion("patientsurvey_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdEqualTo(Long value) {
            addCriterion("patientsurvey_id =", value, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdNotEqualTo(Long value) {
            addCriterion("patientsurvey_id <>", value, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdGreaterThan(Long value) {
            addCriterion("patientsurvey_id >", value, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patientsurvey_id >=", value, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdLessThan(Long value) {
            addCriterion("patientsurvey_id <", value, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdLessThanOrEqualTo(Long value) {
            addCriterion("patientsurvey_id <=", value, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdIn(List<Long> values) {
            addCriterion("patientsurvey_id in", values, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdNotIn(List<Long> values) {
            addCriterion("patientsurvey_id not in", values, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdBetween(Long value1, Long value2) {
            addCriterion("patientsurvey_id between", value1, value2, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andPatientsurveyIdNotBetween(Long value1, Long value2) {
            addCriterion("patientsurvey_id not between", value1, value2, "patientsurveyId");
            return (Criteria) this;
        }

        public Criteria andSurveryNameIsNull() {
            addCriterion("survery_name is null");
            return (Criteria) this;
        }

        public Criteria andSurveryNameIsNotNull() {
            addCriterion("survery_name is not null");
            return (Criteria) this;
        }

        public Criteria andSurveryNameEqualTo(String value) {
            addCriterion("survery_name =", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameNotEqualTo(String value) {
            addCriterion("survery_name <>", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameGreaterThan(String value) {
            addCriterion("survery_name >", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameGreaterThanOrEqualTo(String value) {
            addCriterion("survery_name >=", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameLessThan(String value) {
            addCriterion("survery_name <", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameLessThanOrEqualTo(String value) {
            addCriterion("survery_name <=", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameLike(String value) {
            addCriterion("survery_name like", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameNotLike(String value) {
            addCriterion("survery_name not like", value, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameIn(List<String> values) {
            addCriterion("survery_name in", values, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameNotIn(List<String> values) {
            addCriterion("survery_name not in", values, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameBetween(String value1, String value2) {
            addCriterion("survery_name between", value1, value2, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryNameNotBetween(String value1, String value2) {
            addCriterion("survery_name not between", value1, value2, "surveryName");
            return (Criteria) this;
        }

        public Criteria andSurveryIdIsNull() {
            addCriterion("survery_id is null");
            return (Criteria) this;
        }

        public Criteria andSurveryIdIsNotNull() {
            addCriterion("survery_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurveryIdEqualTo(Long value) {
            addCriterion("survery_id =", value, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdNotEqualTo(Long value) {
            addCriterion("survery_id <>", value, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdGreaterThan(Long value) {
            addCriterion("survery_id >", value, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("survery_id >=", value, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdLessThan(Long value) {
            addCriterion("survery_id <", value, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdLessThanOrEqualTo(Long value) {
            addCriterion("survery_id <=", value, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdIn(List<Long> values) {
            addCriterion("survery_id in", values, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdNotIn(List<Long> values) {
            addCriterion("survery_id not in", values, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdBetween(Long value1, Long value2) {
            addCriterion("survery_id between", value1, value2, "surveryId");
            return (Criteria) this;
        }

        public Criteria andSurveryIdNotBetween(Long value1, Long value2) {
            addCriterion("survery_id not between", value1, value2, "surveryId");
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

        public Criteria andCalltimeIsNull() {
            addCriterion("calltime is null");
            return (Criteria) this;
        }

        public Criteria andCalltimeIsNotNull() {
            addCriterion("calltime is not null");
            return (Criteria) this;
        }

        public Criteria andCalltimeEqualTo(Long value) {
            addCriterion("calltime =", value, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeNotEqualTo(Long value) {
            addCriterion("calltime <>", value, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeGreaterThan(Long value) {
            addCriterion("calltime >", value, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeGreaterThanOrEqualTo(Long value) {
            addCriterion("calltime >=", value, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeLessThan(Long value) {
            addCriterion("calltime <", value, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeLessThanOrEqualTo(Long value) {
            addCriterion("calltime <=", value, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeIn(List<Long> values) {
            addCriterion("calltime in", values, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeNotIn(List<Long> values) {
            addCriterion("calltime not in", values, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeBetween(Long value1, Long value2) {
            addCriterion("calltime between", value1, value2, "calltime");
            return (Criteria) this;
        }

        public Criteria andCalltimeNotBetween(Long value1, Long value2) {
            addCriterion("calltime not between", value1, value2, "calltime");
            return (Criteria) this;
        }

        public Criteria andDialphoneIsNull() {
            addCriterion("dialphone is null");
            return (Criteria) this;
        }

        public Criteria andDialphoneIsNotNull() {
            addCriterion("dialphone is not null");
            return (Criteria) this;
        }

        public Criteria andDialphoneEqualTo(String value) {
            addCriterion("dialphone =", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneNotEqualTo(String value) {
            addCriterion("dialphone <>", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneGreaterThan(String value) {
            addCriterion("dialphone >", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneGreaterThanOrEqualTo(String value) {
            addCriterion("dialphone >=", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneLessThan(String value) {
            addCriterion("dialphone <", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneLessThanOrEqualTo(String value) {
            addCriterion("dialphone <=", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneLike(String value) {
            addCriterion("dialphone like", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneNotLike(String value) {
            addCriterion("dialphone not like", value, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneIn(List<String> values) {
            addCriterion("dialphone in", values, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneNotIn(List<String> values) {
            addCriterion("dialphone not in", values, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneBetween(String value1, String value2) {
            addCriterion("dialphone between", value1, value2, "dialphone");
            return (Criteria) this;
        }

        public Criteria andDialphoneNotBetween(String value1, String value2) {
            addCriterion("dialphone not between", value1, value2, "dialphone");
            return (Criteria) this;
        }

        public Criteria andRecordfileIsNull() {
            addCriterion("recordfile is null");
            return (Criteria) this;
        }

        public Criteria andRecordfileIsNotNull() {
            addCriterion("recordfile is not null");
            return (Criteria) this;
        }

        public Criteria andRecordfileEqualTo(String value) {
            addCriterion("recordfile =", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileNotEqualTo(String value) {
            addCriterion("recordfile <>", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileGreaterThan(String value) {
            addCriterion("recordfile >", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileGreaterThanOrEqualTo(String value) {
            addCriterion("recordfile >=", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileLessThan(String value) {
            addCriterion("recordfile <", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileLessThanOrEqualTo(String value) {
            addCriterion("recordfile <=", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileLike(String value) {
            addCriterion("recordfile like", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileNotLike(String value) {
            addCriterion("recordfile not like", value, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileIn(List<String> values) {
            addCriterion("recordfile in", values, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileNotIn(List<String> values) {
            addCriterion("recordfile not in", values, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileBetween(String value1, String value2) {
            addCriterion("recordfile between", value1, value2, "recordfile");
            return (Criteria) this;
        }

        public Criteria andRecordfileNotBetween(String value1, String value2) {
            addCriterion("recordfile not between", value1, value2, "recordfile");
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

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Long value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Long value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Long value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Long value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Long> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Long> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Long value1, Long value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
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