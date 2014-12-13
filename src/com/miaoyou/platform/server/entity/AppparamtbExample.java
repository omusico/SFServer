package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.List;

public class AppparamtbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public AppparamtbExample() {
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

        public Criteria andAppparamIdIsNull() {
            addCriterion("appparam_id is null");
            return (Criteria) this;
        }

        public Criteria andAppparamIdIsNotNull() {
            addCriterion("appparam_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppparamIdEqualTo(Integer value) {
            addCriterion("appparam_id =", value, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdNotEqualTo(Integer value) {
            addCriterion("appparam_id <>", value, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdGreaterThan(Integer value) {
            addCriterion("appparam_id >", value, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appparam_id >=", value, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdLessThan(Integer value) {
            addCriterion("appparam_id <", value, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdLessThanOrEqualTo(Integer value) {
            addCriterion("appparam_id <=", value, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdIn(List<Integer> values) {
            addCriterion("appparam_id in", values, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdNotIn(List<Integer> values) {
            addCriterion("appparam_id not in", values, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdBetween(Integer value1, Integer value2) {
            addCriterion("appparam_id between", value1, value2, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appparam_id not between", value1, value2, "appparamId");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeIsNull() {
            addCriterion("appparam_type is null");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeIsNotNull() {
            addCriterion("appparam_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeEqualTo(String value) {
            addCriterion("appparam_type =", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeNotEqualTo(String value) {
            addCriterion("appparam_type <>", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeGreaterThan(String value) {
            addCriterion("appparam_type >", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("appparam_type >=", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeLessThan(String value) {
            addCriterion("appparam_type <", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeLessThanOrEqualTo(String value) {
            addCriterion("appparam_type <=", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeLike(String value) {
            addCriterion("appparam_type like", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeNotLike(String value) {
            addCriterion("appparam_type not like", value, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeIn(List<String> values) {
            addCriterion("appparam_type in", values, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeNotIn(List<String> values) {
            addCriterion("appparam_type not in", values, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeBetween(String value1, String value2) {
            addCriterion("appparam_type between", value1, value2, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamTypeNotBetween(String value1, String value2) {
            addCriterion("appparam_type not between", value1, value2, "appparamType");
            return (Criteria) this;
        }

        public Criteria andAppparamNameIsNull() {
            addCriterion("appparam_name is null");
            return (Criteria) this;
        }

        public Criteria andAppparamNameIsNotNull() {
            addCriterion("appparam_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppparamNameEqualTo(String value) {
            addCriterion("appparam_name =", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameNotEqualTo(String value) {
            addCriterion("appparam_name <>", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameGreaterThan(String value) {
            addCriterion("appparam_name >", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameGreaterThanOrEqualTo(String value) {
            addCriterion("appparam_name >=", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameLessThan(String value) {
            addCriterion("appparam_name <", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameLessThanOrEqualTo(String value) {
            addCriterion("appparam_name <=", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameLike(String value) {
            addCriterion("appparam_name like", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameNotLike(String value) {
            addCriterion("appparam_name not like", value, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameIn(List<String> values) {
            addCriterion("appparam_name in", values, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameNotIn(List<String> values) {
            addCriterion("appparam_name not in", values, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameBetween(String value1, String value2) {
            addCriterion("appparam_name between", value1, value2, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamNameNotBetween(String value1, String value2) {
            addCriterion("appparam_name not between", value1, value2, "appparamName");
            return (Criteria) this;
        }

        public Criteria andAppparamPidIsNull() {
            addCriterion("appparam_pid is null");
            return (Criteria) this;
        }

        public Criteria andAppparamPidIsNotNull() {
            addCriterion("appparam_pid is not null");
            return (Criteria) this;
        }

        public Criteria andAppparamPidEqualTo(Integer value) {
            addCriterion("appparam_pid =", value, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidNotEqualTo(Integer value) {
            addCriterion("appparam_pid <>", value, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidGreaterThan(Integer value) {
            addCriterion("appparam_pid >", value, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("appparam_pid >=", value, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidLessThan(Integer value) {
            addCriterion("appparam_pid <", value, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidLessThanOrEqualTo(Integer value) {
            addCriterion("appparam_pid <=", value, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidIn(List<Integer> values) {
            addCriterion("appparam_pid in", values, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidNotIn(List<Integer> values) {
            addCriterion("appparam_pid not in", values, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidBetween(Integer value1, Integer value2) {
            addCriterion("appparam_pid between", value1, value2, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamPidNotBetween(Integer value1, Integer value2) {
            addCriterion("appparam_pid not between", value1, value2, "appparamPid");
            return (Criteria) this;
        }

        public Criteria andAppparamDescIsNull() {
            addCriterion("appparam_desc is null");
            return (Criteria) this;
        }

        public Criteria andAppparamDescIsNotNull() {
            addCriterion("appparam_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAppparamDescEqualTo(String value) {
            addCriterion("appparam_desc =", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescNotEqualTo(String value) {
            addCriterion("appparam_desc <>", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescGreaterThan(String value) {
            addCriterion("appparam_desc >", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescGreaterThanOrEqualTo(String value) {
            addCriterion("appparam_desc >=", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescLessThan(String value) {
            addCriterion("appparam_desc <", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescLessThanOrEqualTo(String value) {
            addCriterion("appparam_desc <=", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescLike(String value) {
            addCriterion("appparam_desc like", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescNotLike(String value) {
            addCriterion("appparam_desc not like", value, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescIn(List<String> values) {
            addCriterion("appparam_desc in", values, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescNotIn(List<String> values) {
            addCriterion("appparam_desc not in", values, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescBetween(String value1, String value2) {
            addCriterion("appparam_desc between", value1, value2, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andAppparamDescNotBetween(String value1, String value2) {
            addCriterion("appparam_desc not between", value1, value2, "appparamDesc");
            return (Criteria) this;
        }

        public Criteria andSystemparamIsNull() {
            addCriterion("systemparam is null");
            return (Criteria) this;
        }

        public Criteria andSystemparamIsNotNull() {
            addCriterion("systemparam is not null");
            return (Criteria) this;
        }

        public Criteria andSystemparamEqualTo(Integer value) {
            addCriterion("systemparam =", value, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamNotEqualTo(Integer value) {
            addCriterion("systemparam <>", value, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamGreaterThan(Integer value) {
            addCriterion("systemparam >", value, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamGreaterThanOrEqualTo(Integer value) {
            addCriterion("systemparam >=", value, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamLessThan(Integer value) {
            addCriterion("systemparam <", value, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamLessThanOrEqualTo(Integer value) {
            addCriterion("systemparam <=", value, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamIn(List<Integer> values) {
            addCriterion("systemparam in", values, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamNotIn(List<Integer> values) {
            addCriterion("systemparam not in", values, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamBetween(Integer value1, Integer value2) {
            addCriterion("systemparam between", value1, value2, "systemparam");
            return (Criteria) this;
        }

        public Criteria andSystemparamNotBetween(Integer value1, Integer value2) {
            addCriterion("systemparam not between", value1, value2, "systemparam");
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