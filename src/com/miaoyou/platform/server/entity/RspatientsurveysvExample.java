package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.List;

public class RspatientsurveysvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RspatientsurveysvExample() {
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

        public Criteria andSurverydetailNameIsNull() {
            addCriterion("surverydetail_name is null");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameIsNotNull() {
            addCriterion("surverydetail_name is not null");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameEqualTo(String value) {
            addCriterion("surverydetail_name =", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameNotEqualTo(String value) {
            addCriterion("surverydetail_name <>", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameGreaterThan(String value) {
            addCriterion("surverydetail_name >", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("surverydetail_name >=", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameLessThan(String value) {
            addCriterion("surverydetail_name <", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameLessThanOrEqualTo(String value) {
            addCriterion("surverydetail_name <=", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameLike(String value) {
            addCriterion("surverydetail_name like", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameNotLike(String value) {
            addCriterion("surverydetail_name not like", value, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameIn(List<String> values) {
            addCriterion("surverydetail_name in", values, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameNotIn(List<String> values) {
            addCriterion("surverydetail_name not in", values, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameBetween(String value1, String value2) {
            addCriterion("surverydetail_name between", value1, value2, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailNameNotBetween(String value1, String value2) {
            addCriterion("surverydetail_name not between", value1, value2, "surverydetailName");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerIsNull() {
            addCriterion("surverydetail_answer is null");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerIsNotNull() {
            addCriterion("surverydetail_answer is not null");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerEqualTo(String value) {
            addCriterion("surverydetail_answer =", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerNotEqualTo(String value) {
            addCriterion("surverydetail_answer <>", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerGreaterThan(String value) {
            addCriterion("surverydetail_answer >", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("surverydetail_answer >=", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerLessThan(String value) {
            addCriterion("surverydetail_answer <", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerLessThanOrEqualTo(String value) {
            addCriterion("surverydetail_answer <=", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerLike(String value) {
            addCriterion("surverydetail_answer like", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerNotLike(String value) {
            addCriterion("surverydetail_answer not like", value, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerIn(List<String> values) {
            addCriterion("surverydetail_answer in", values, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerNotIn(List<String> values) {
            addCriterion("surverydetail_answer not in", values, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerBetween(String value1, String value2) {
            addCriterion("surverydetail_answer between", value1, value2, "surverydetailAnswer");
            return (Criteria) this;
        }

        public Criteria andSurverydetailAnswerNotBetween(String value1, String value2) {
            addCriterion("surverydetail_answer not between", value1, value2, "surverydetailAnswer");
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