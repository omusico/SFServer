package com.miaoyou.platform.server.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RecordcaseopdtbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupby;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RecordcaseopdtbExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRecordcaseidIsNull() {
            addCriterion("recordcaseid is null");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidIsNotNull() {
            addCriterion("recordcaseid is not null");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidEqualTo(Long value) {
            addCriterion("recordcaseid =", value, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidNotEqualTo(Long value) {
            addCriterion("recordcaseid <>", value, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidGreaterThan(Long value) {
            addCriterion("recordcaseid >", value, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidGreaterThanOrEqualTo(Long value) {
            addCriterion("recordcaseid >=", value, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidLessThan(Long value) {
            addCriterion("recordcaseid <", value, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidLessThanOrEqualTo(Long value) {
            addCriterion("recordcaseid <=", value, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidIn(List<Long> values) {
            addCriterion("recordcaseid in", values, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidNotIn(List<Long> values) {
            addCriterion("recordcaseid not in", values, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidBetween(Long value1, Long value2) {
            addCriterion("recordcaseid between", value1, value2, "recordcaseid");
            return (Criteria) this;
        }

        public Criteria andRecordcaseidNotBetween(Long value1, Long value2) {
            addCriterion("recordcaseid not between", value1, value2, "recordcaseid");
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

        public Criteria andKeshiIsNull() {
            addCriterion("keshi is null");
            return (Criteria) this;
        }

        public Criteria andKeshiIsNotNull() {
            addCriterion("keshi is not null");
            return (Criteria) this;
        }

        public Criteria andKeshiEqualTo(String value) {
            addCriterion("keshi =", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotEqualTo(String value) {
            addCriterion("keshi <>", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiGreaterThan(String value) {
            addCriterion("keshi >", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiGreaterThanOrEqualTo(String value) {
            addCriterion("keshi >=", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiLessThan(String value) {
            addCriterion("keshi <", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiLessThanOrEqualTo(String value) {
            addCriterion("keshi <=", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiLike(String value) {
            addCriterion("keshi like", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotLike(String value) {
            addCriterion("keshi not like", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiIn(List<String> values) {
            addCriterion("keshi in", values, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotIn(List<String> values) {
            addCriterion("keshi not in", values, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiBetween(String value1, String value2) {
            addCriterion("keshi between", value1, value2, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotBetween(String value1, String value2) {
            addCriterion("keshi not between", value1, value2, "keshi");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoIsNull() {
            addCriterion("menzhenhao is null");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoIsNotNull() {
            addCriterion("menzhenhao is not null");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoEqualTo(String value) {
            addCriterion("menzhenhao =", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoNotEqualTo(String value) {
            addCriterion("menzhenhao <>", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoGreaterThan(String value) {
            addCriterion("menzhenhao >", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoGreaterThanOrEqualTo(String value) {
            addCriterion("menzhenhao >=", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoLessThan(String value) {
            addCriterion("menzhenhao <", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoLessThanOrEqualTo(String value) {
            addCriterion("menzhenhao <=", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoLike(String value) {
            addCriterion("menzhenhao like", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoNotLike(String value) {
            addCriterion("menzhenhao not like", value, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoIn(List<String> values) {
            addCriterion("menzhenhao in", values, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoNotIn(List<String> values) {
            addCriterion("menzhenhao not in", values, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoBetween(String value1, String value2) {
            addCriterion("menzhenhao between", value1, value2, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenhaoNotBetween(String value1, String value2) {
            addCriterion("menzhenhao not between", value1, value2, "menzhenhao");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiIsNull() {
            addCriterion("menzhenriqi is null");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiIsNotNull() {
            addCriterion("menzhenriqi is not null");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiEqualTo(Date value) {
            addCriterionForJDBCDate("menzhenriqi =", value, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiNotEqualTo(Date value) {
            addCriterionForJDBCDate("menzhenriqi <>", value, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiGreaterThan(Date value) {
            addCriterionForJDBCDate("menzhenriqi >", value, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("menzhenriqi >=", value, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiLessThan(Date value) {
            addCriterionForJDBCDate("menzhenriqi <", value, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("menzhenriqi <=", value, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiIn(List<Date> values) {
            addCriterionForJDBCDate("menzhenriqi in", values, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiNotIn(List<Date> values) {
            addCriterionForJDBCDate("menzhenriqi not in", values, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("menzhenriqi between", value1, value2, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenriqiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("menzhenriqi not between", value1, value2, "menzhenriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanIsNull() {
            addCriterion("menzhenzhengduan is null");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanIsNotNull() {
            addCriterion("menzhenzhengduan is not null");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanEqualTo(String value) {
            addCriterion("menzhenzhengduan =", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanNotEqualTo(String value) {
            addCriterion("menzhenzhengduan <>", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanGreaterThan(String value) {
            addCriterion("menzhenzhengduan >", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanGreaterThanOrEqualTo(String value) {
            addCriterion("menzhenzhengduan >=", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanLessThan(String value) {
            addCriterion("menzhenzhengduan <", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanLessThanOrEqualTo(String value) {
            addCriterion("menzhenzhengduan <=", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanLike(String value) {
            addCriterion("menzhenzhengduan like", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanNotLike(String value) {
            addCriterion("menzhenzhengduan not like", value, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanIn(List<String> values) {
            addCriterion("menzhenzhengduan in", values, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanNotIn(List<String> values) {
            addCriterion("menzhenzhengduan not in", values, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanBetween(String value1, String value2) {
            addCriterion("menzhenzhengduan between", value1, value2, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andMenzhenzhengduanNotBetween(String value1, String value2) {
            addCriterion("menzhenzhengduan not between", value1, value2, "menzhenzhengduan");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiIsNull() {
            addCriterion("chuyuanriqi is null");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiIsNotNull() {
            addCriterion("chuyuanriqi is not null");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiEqualTo(Date value) {
            addCriterion("chuyuanriqi =", value, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiNotEqualTo(Date value) {
            addCriterion("chuyuanriqi <>", value, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiGreaterThan(Date value) {
            addCriterion("chuyuanriqi >", value, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiGreaterThanOrEqualTo(Date value) {
            addCriterion("chuyuanriqi >=", value, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiLessThan(Date value) {
            addCriterion("chuyuanriqi <", value, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiLessThanOrEqualTo(Date value) {
            addCriterion("chuyuanriqi <=", value, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiIn(List<Date> values) {
            addCriterion("chuyuanriqi in", values, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiNotIn(List<Date> values) {
            addCriterion("chuyuanriqi not in", values, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiBetween(Date value1, Date value2) {
            addCriterion("chuyuanriqi between", value1, value2, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andChuyuanriqiNotBetween(Date value1, Date value2) {
            addCriterion("chuyuanriqi not between", value1, value2, "chuyuanriqi");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengIsNull() {
            addCriterion("menzhenyisheng is null");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengIsNotNull() {
            addCriterion("menzhenyisheng is not null");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengEqualTo(String value) {
            addCriterion("menzhenyisheng =", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengNotEqualTo(String value) {
            addCriterion("menzhenyisheng <>", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengGreaterThan(String value) {
            addCriterion("menzhenyisheng >", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengGreaterThanOrEqualTo(String value) {
            addCriterion("menzhenyisheng >=", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengLessThan(String value) {
            addCriterion("menzhenyisheng <", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengLessThanOrEqualTo(String value) {
            addCriterion("menzhenyisheng <=", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengLike(String value) {
            addCriterion("menzhenyisheng like", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengNotLike(String value) {
            addCriterion("menzhenyisheng not like", value, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengIn(List<String> values) {
            addCriterion("menzhenyisheng in", values, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengNotIn(List<String> values) {
            addCriterion("menzhenyisheng not in", values, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengBetween(String value1, String value2) {
            addCriterion("menzhenyisheng between", value1, value2, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andMenzhenyishengNotBetween(String value1, String value2) {
            addCriterion("menzhenyisheng not between", value1, value2, "menzhenyisheng");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiIsNull() {
            addCriterion("bingliezhuangtai is null");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiIsNotNull() {
            addCriterion("bingliezhuangtai is not null");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiEqualTo(String value) {
            addCriterion("bingliezhuangtai =", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiNotEqualTo(String value) {
            addCriterion("bingliezhuangtai <>", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiGreaterThan(String value) {
            addCriterion("bingliezhuangtai >", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiGreaterThanOrEqualTo(String value) {
            addCriterion("bingliezhuangtai >=", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiLessThan(String value) {
            addCriterion("bingliezhuangtai <", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiLessThanOrEqualTo(String value) {
            addCriterion("bingliezhuangtai <=", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiLike(String value) {
            addCriterion("bingliezhuangtai like", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiNotLike(String value) {
            addCriterion("bingliezhuangtai not like", value, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiIn(List<String> values) {
            addCriterion("bingliezhuangtai in", values, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiNotIn(List<String> values) {
            addCriterion("bingliezhuangtai not in", values, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiBetween(String value1, String value2) {
            addCriterion("bingliezhuangtai between", value1, value2, "bingliezhuangtai");
            return (Criteria) this;
        }

        public Criteria andBingliezhuangtaiNotBetween(String value1, String value2) {
            addCriterion("bingliezhuangtai not between", value1, value2, "bingliezhuangtai");
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