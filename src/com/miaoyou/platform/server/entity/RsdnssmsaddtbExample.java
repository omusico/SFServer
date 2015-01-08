package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.List;

public class RsdnssmsaddtbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RsdnssmsaddtbExample() {
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

        public Criteria andDiagnosisIdIsNull() {
            addCriterion("diagnosis_id is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdIsNotNull() {
            addCriterion("diagnosis_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdEqualTo(Long value) {
            addCriterion("diagnosis_id =", value, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdNotEqualTo(Long value) {
            addCriterion("diagnosis_id <>", value, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdGreaterThan(Long value) {
            addCriterion("diagnosis_id >", value, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdGreaterThanOrEqualTo(Long value) {
            addCriterion("diagnosis_id >=", value, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdLessThan(Long value) {
            addCriterion("diagnosis_id <", value, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdLessThanOrEqualTo(Long value) {
            addCriterion("diagnosis_id <=", value, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdIn(List<Long> values) {
            addCriterion("diagnosis_id in", values, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdNotIn(List<Long> values) {
            addCriterion("diagnosis_id not in", values, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdBetween(Long value1, Long value2) {
            addCriterion("diagnosis_id between", value1, value2, "diagnosisId");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIdNotBetween(Long value1, Long value2) {
            addCriterion("diagnosis_id not between", value1, value2, "diagnosisId");
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