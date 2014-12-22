package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.List;

public class RsdnssvtbaddExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RsdnssvtbaddExample() {
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

        public Criteria andSurverydetailIdIsNull() {
            addCriterion("surverydetail_id is null");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdIsNotNull() {
            addCriterion("surverydetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdEqualTo(Long value) {
            addCriterion("surverydetail_id =", value, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdNotEqualTo(Long value) {
            addCriterion("surverydetail_id <>", value, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdGreaterThan(Long value) {
            addCriterion("surverydetail_id >", value, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("surverydetail_id >=", value, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdLessThan(Long value) {
            addCriterion("surverydetail_id <", value, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdLessThanOrEqualTo(Long value) {
            addCriterion("surverydetail_id <=", value, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdIn(List<Long> values) {
            addCriterion("surverydetail_id in", values, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdNotIn(List<Long> values) {
            addCriterion("surverydetail_id not in", values, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdBetween(Long value1, Long value2) {
            addCriterion("surverydetail_id between", value1, value2, "surverydetailId");
            return (Criteria) this;
        }

        public Criteria andSurverydetailIdNotBetween(Long value1, Long value2) {
            addCriterion("surverydetail_id not between", value1, value2, "surverydetailId");
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