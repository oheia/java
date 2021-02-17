package com.ohei.mybatis.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class MoneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoneyExample() {
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

        public Criteria andBasicIsNull() {
            addCriterion("basic is null");
            return (Criteria) this;
        }

        public Criteria andBasicIsNotNull() {
            addCriterion("basic is not null");
            return (Criteria) this;
        }

        public Criteria andBasicEqualTo(Integer value) {
            addCriterion("basic =", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotEqualTo(Integer value) {
            addCriterion("basic <>", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThan(Integer value) {
            addCriterion("basic >", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThanOrEqualTo(Integer value) {
            addCriterion("basic >=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThan(Integer value) {
            addCriterion("basic <", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThanOrEqualTo(Integer value) {
            addCriterion("basic <=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicIn(List<Integer> values) {
            addCriterion("basic in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotIn(List<Integer> values) {
            addCriterion("basic not in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicBetween(Integer value1, Integer value2) {
            addCriterion("basic between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotBetween(Integer value1, Integer value2) {
            addCriterion("basic not between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(Integer value) {
            addCriterion("reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(Integer value) {
            addCriterion("reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(Integer value) {
            addCriterion("reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(Integer value) {
            addCriterion("reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(Integer value) {
            addCriterion("reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(List<Integer> values) {
            addCriterion("reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(List<Integer> values) {
            addCriterion("reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(Integer value1, Integer value2) {
            addCriterion("reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(Integer value1, Integer value2) {
            addCriterion("reward not between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andPunishmentIsNull() {
            addCriterion("punishment is null");
            return (Criteria) this;
        }

        public Criteria andPunishmentIsNotNull() {
            addCriterion("punishment is not null");
            return (Criteria) this;
        }

        public Criteria andPunishmentEqualTo(Integer value) {
            addCriterion("punishment =", value, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentNotEqualTo(Integer value) {
            addCriterion("punishment <>", value, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentGreaterThan(Integer value) {
            addCriterion("punishment >", value, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("punishment >=", value, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentLessThan(Integer value) {
            addCriterion("punishment <", value, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentLessThanOrEqualTo(Integer value) {
            addCriterion("punishment <=", value, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentIn(List<Integer> values) {
            addCriterion("punishment in", values, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentNotIn(List<Integer> values) {
            addCriterion("punishment not in", values, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentBetween(Integer value1, Integer value2) {
            addCriterion("punishment between", value1, value2, "punishment");
            return (Criteria) this;
        }

        public Criteria andPunishmentNotBetween(Integer value1, Integer value2) {
            addCriterion("punishment not between", value1, value2, "punishment");
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