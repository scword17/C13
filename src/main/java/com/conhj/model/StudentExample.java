package com.conhj.model;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andSnoIsNull() {
            addCriterion("Sno is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("Sno is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(String value) {
            addCriterion("Sno =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(String value) {
            addCriterion("Sno <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(String value) {
            addCriterion("Sno >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(String value) {
            addCriterion("Sno >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(String value) {
            addCriterion("Sno <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(String value) {
            addCriterion("Sno <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLike(String value) {
            addCriterion("Sno like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotLike(String value) {
            addCriterion("Sno not like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<String> values) {
            addCriterion("Sno in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<String> values) {
            addCriterion("Sno not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(String value1, String value2) {
            addCriterion("Sno between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(String value1, String value2) {
            addCriterion("Sno not between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("Sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("Sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("Sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("Sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("Sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("Sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("Sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("Sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("Sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("Sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("Sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("Sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("Sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("Sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("Sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("Sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("Sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("Sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("Sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("Sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("Sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("Sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("Sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("Sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("Sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("Sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("Sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("Sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSageIsNull() {
            addCriterion("Sage is null");
            return (Criteria) this;
        }

        public Criteria andSageIsNotNull() {
            addCriterion("Sage is not null");
            return (Criteria) this;
        }

        public Criteria andSageEqualTo(Short value) {
            addCriterion("Sage =", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageNotEqualTo(Short value) {
            addCriterion("Sage <>", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageGreaterThan(Short value) {
            addCriterion("Sage >", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageGreaterThanOrEqualTo(Short value) {
            addCriterion("Sage >=", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageLessThan(Short value) {
            addCriterion("Sage <", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageLessThanOrEqualTo(Short value) {
            addCriterion("Sage <=", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageIn(List<Short> values) {
            addCriterion("Sage in", values, "sage");
            return (Criteria) this;
        }

        public Criteria andSageNotIn(List<Short> values) {
            addCriterion("Sage not in", values, "sage");
            return (Criteria) this;
        }

        public Criteria andSageBetween(Short value1, Short value2) {
            addCriterion("Sage between", value1, value2, "sage");
            return (Criteria) this;
        }

        public Criteria andSageNotBetween(Short value1, Short value2) {
            addCriterion("Sage not between", value1, value2, "sage");
            return (Criteria) this;
        }

        public Criteria andSdeptIsNull() {
            addCriterion("Sdept is null");
            return (Criteria) this;
        }

        public Criteria andSdeptIsNotNull() {
            addCriterion("Sdept is not null");
            return (Criteria) this;
        }

        public Criteria andSdeptEqualTo(String value) {
            addCriterion("Sdept =", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptNotEqualTo(String value) {
            addCriterion("Sdept <>", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptGreaterThan(String value) {
            addCriterion("Sdept >", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptGreaterThanOrEqualTo(String value) {
            addCriterion("Sdept >=", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptLessThan(String value) {
            addCriterion("Sdept <", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptLessThanOrEqualTo(String value) {
            addCriterion("Sdept <=", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptLike(String value) {
            addCriterion("Sdept like", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptNotLike(String value) {
            addCriterion("Sdept not like", value, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptIn(List<String> values) {
            addCriterion("Sdept in", values, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptNotIn(List<String> values) {
            addCriterion("Sdept not in", values, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptBetween(String value1, String value2) {
            addCriterion("Sdept between", value1, value2, "sdept");
            return (Criteria) this;
        }

        public Criteria andSdeptNotBetween(String value1, String value2) {
            addCriterion("Sdept not between", value1, value2, "sdept");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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