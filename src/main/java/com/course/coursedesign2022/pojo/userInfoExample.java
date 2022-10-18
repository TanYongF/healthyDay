package com.course.coursedesign2022.pojo;

import java.util.ArrayList;
import java.util.List;

public class userInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public userInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGrowscoreIsNull() {
            addCriterion("growScore is null");
            return (Criteria) this;
        }

        public Criteria andGrowscoreIsNotNull() {
            addCriterion("growScore is not null");
            return (Criteria) this;
        }

        public Criteria andGrowscoreEqualTo(Integer value) {
            addCriterion("growScore =", value, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreNotEqualTo(Integer value) {
            addCriterion("growScore <>", value, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreGreaterThan(Integer value) {
            addCriterion("growScore >", value, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("growScore >=", value, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreLessThan(Integer value) {
            addCriterion("growScore <", value, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreLessThanOrEqualTo(Integer value) {
            addCriterion("growScore <=", value, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreIn(List<Integer> values) {
            addCriterion("growScore in", values, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreNotIn(List<Integer> values) {
            addCriterion("growScore not in", values, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreBetween(Integer value1, Integer value2) {
            addCriterion("growScore between", value1, value2, "growscore");
            return (Criteria) this;
        }

        public Criteria andGrowscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("growScore not between", value1, value2, "growscore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreIsNull() {
            addCriterion("exchangeScore is null");
            return (Criteria) this;
        }

        public Criteria andExchangescoreIsNotNull() {
            addCriterion("exchangeScore is not null");
            return (Criteria) this;
        }

        public Criteria andExchangescoreEqualTo(Integer value) {
            addCriterion("exchangeScore =", value, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreNotEqualTo(Integer value) {
            addCriterion("exchangeScore <>", value, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreGreaterThan(Integer value) {
            addCriterion("exchangeScore >", value, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchangeScore >=", value, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreLessThan(Integer value) {
            addCriterion("exchangeScore <", value, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreLessThanOrEqualTo(Integer value) {
            addCriterion("exchangeScore <=", value, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreIn(List<Integer> values) {
            addCriterion("exchangeScore in", values, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreNotIn(List<Integer> values) {
            addCriterion("exchangeScore not in", values, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreBetween(Integer value1, Integer value2) {
            addCriterion("exchangeScore between", value1, value2, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andExchangescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("exchangeScore not between", value1, value2, "exchangescore");
            return (Criteria) this;
        }

        public Criteria andScoretotalIsNull() {
            addCriterion("scoreTotal is null");
            return (Criteria) this;
        }

        public Criteria andScoretotalIsNotNull() {
            addCriterion("scoreTotal is not null");
            return (Criteria) this;
        }

        public Criteria andScoretotalEqualTo(Integer value) {
            addCriterion("scoreTotal =", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalNotEqualTo(Integer value) {
            addCriterion("scoreTotal <>", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalGreaterThan(Integer value) {
            addCriterion("scoreTotal >", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoreTotal >=", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalLessThan(Integer value) {
            addCriterion("scoreTotal <", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalLessThanOrEqualTo(Integer value) {
            addCriterion("scoreTotal <=", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalIn(List<Integer> values) {
            addCriterion("scoreTotal in", values, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalNotIn(List<Integer> values) {
            addCriterion("scoreTotal not in", values, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalBetween(Integer value1, Integer value2) {
            addCriterion("scoreTotal between", value1, value2, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalNotBetween(Integer value1, Integer value2) {
            addCriterion("scoreTotal not between", value1, value2, "scoretotal");
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