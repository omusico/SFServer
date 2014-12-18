package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.List;

public class DiagnosistbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public DiagnosistbExample() {
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

        public Criteria andDiagnosisNameIsNull() {
            addCriterion("diagnosis_name is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameIsNotNull() {
            addCriterion("diagnosis_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameEqualTo(String value) {
            addCriterion("diagnosis_name =", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotEqualTo(String value) {
            addCriterion("diagnosis_name <>", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameGreaterThan(String value) {
            addCriterion("diagnosis_name >", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameGreaterThanOrEqualTo(String value) {
            addCriterion("diagnosis_name >=", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameLessThan(String value) {
            addCriterion("diagnosis_name <", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameLessThanOrEqualTo(String value) {
            addCriterion("diagnosis_name <=", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameLike(String value) {
            addCriterion("diagnosis_name like", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotLike(String value) {
            addCriterion("diagnosis_name not like", value, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameIn(List<String> values) {
            addCriterion("diagnosis_name in", values, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotIn(List<String> values) {
            addCriterion("diagnosis_name not in", values, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameBetween(String value1, String value2) {
            addCriterion("diagnosis_name between", value1, value2, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNameNotBetween(String value1, String value2) {
            addCriterion("diagnosis_name not between", value1, value2, "diagnosisName");
            return (Criteria) this;
        }

        public Criteria andSuitabledpIsNull() {
            addCriterion("suitabledp is null");
            return (Criteria) this;
        }

        public Criteria andSuitabledpIsNotNull() {
            addCriterion("suitabledp is not null");
            return (Criteria) this;
        }

        public Criteria andSuitabledpEqualTo(String value) {
            addCriterion("suitabledp =", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpNotEqualTo(String value) {
            addCriterion("suitabledp <>", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpGreaterThan(String value) {
            addCriterion("suitabledp >", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpGreaterThanOrEqualTo(String value) {
            addCriterion("suitabledp >=", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpLessThan(String value) {
            addCriterion("suitabledp <", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpLessThanOrEqualTo(String value) {
            addCriterion("suitabledp <=", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpLike(String value) {
            addCriterion("suitabledp like", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpNotLike(String value) {
            addCriterion("suitabledp not like", value, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpIn(List<String> values) {
            addCriterion("suitabledp in", values, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpNotIn(List<String> values) {
            addCriterion("suitabledp not in", values, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpBetween(String value1, String value2) {
            addCriterion("suitabledp between", value1, value2, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andSuitabledpNotBetween(String value1, String value2) {
            addCriterion("suitabledp not between", value1, value2, "suitabledp");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkIsNull() {
            addCriterion("department_remark is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkIsNotNull() {
            addCriterion("department_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkEqualTo(String value) {
            addCriterion("department_remark =", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkNotEqualTo(String value) {
            addCriterion("department_remark <>", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkGreaterThan(String value) {
            addCriterion("department_remark >", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("department_remark >=", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkLessThan(String value) {
            addCriterion("department_remark <", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkLessThanOrEqualTo(String value) {
            addCriterion("department_remark <=", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkLike(String value) {
            addCriterion("department_remark like", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkNotLike(String value) {
            addCriterion("department_remark not like", value, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkIn(List<String> values) {
            addCriterion("department_remark in", values, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkNotIn(List<String> values) {
            addCriterion("department_remark not in", values, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkBetween(String value1, String value2) {
            addCriterion("department_remark between", value1, value2, "departmentRemark");
            return (Criteria) this;
        }

        public Criteria andDepartmentRemarkNotBetween(String value1, String value2) {
            addCriterion("department_remark not between", value1, value2, "departmentRemark");
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