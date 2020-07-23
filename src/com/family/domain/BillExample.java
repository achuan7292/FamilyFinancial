package com.family.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillExample() {
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

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBKindsIsNull() {
            addCriterion("b_kinds is null");
            return (Criteria) this;
        }

        public Criteria andBKindsIsNotNull() {
            addCriterion("b_kinds is not null");
            return (Criteria) this;
        }

        public Criteria andBKindsEqualTo(Integer value) {
            addCriterion("b_kinds =", value, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsNotEqualTo(Integer value) {
            addCriterion("b_kinds <>", value, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsGreaterThan(Integer value) {
            addCriterion("b_kinds >", value, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_kinds >=", value, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsLessThan(Integer value) {
            addCriterion("b_kinds <", value, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsLessThanOrEqualTo(Integer value) {
            addCriterion("b_kinds <=", value, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsIn(List<Integer> values) {
            addCriterion("b_kinds in", values, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsNotIn(List<Integer> values) {
            addCriterion("b_kinds not in", values, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsBetween(Integer value1, Integer value2) {
            addCriterion("b_kinds between", value1, value2, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBKindsNotBetween(Integer value1, Integer value2) {
            addCriterion("b_kinds not between", value1, value2, "bKinds");
            return (Criteria) this;
        }

        public Criteria andBDescIsNull() {
            addCriterion("b_desc is null");
            return (Criteria) this;
        }

        public Criteria andBDescIsNotNull() {
            addCriterion("b_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBDescEqualTo(String value) {
            addCriterion("b_desc =", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescNotEqualTo(String value) {
            addCriterion("b_desc <>", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescGreaterThan(String value) {
            addCriterion("b_desc >", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescGreaterThanOrEqualTo(String value) {
            addCriterion("b_desc >=", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescLessThan(String value) {
            addCriterion("b_desc <", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescLessThanOrEqualTo(String value) {
            addCriterion("b_desc <=", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescLike(String value) {
            addCriterion("b_desc like", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescNotLike(String value) {
            addCriterion("b_desc not like", value, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescIn(List<String> values) {
            addCriterion("b_desc in", values, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescNotIn(List<String> values) {
            addCriterion("b_desc not in", values, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescBetween(String value1, String value2) {
            addCriterion("b_desc between", value1, value2, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDescNotBetween(String value1, String value2) {
            addCriterion("b_desc not between", value1, value2, "bDesc");
            return (Criteria) this;
        }

        public Criteria andBDateIsNull() {
            addCriterion("b_date is null");
            return (Criteria) this;
        }

        public Criteria andBDateIsNotNull() {
            addCriterion("b_date is not null");
            return (Criteria) this;
        }

        public Criteria andBDateEqualTo(Date value) {
            addCriterionForJDBCDate("b_date =", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_date <>", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateGreaterThan(Date value) {
            addCriterionForJDBCDate("b_date >", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_date >=", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateLessThan(Date value) {
            addCriterionForJDBCDate("b_date <", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_date <=", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateIn(List<Date> values) {
            addCriterionForJDBCDate("b_date in", values, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_date not in", values, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_date between", value1, value2, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_date not between", value1, value2, "bDate");
            return (Criteria) this;
        }

        public Criteria andBMoneyIsNull() {
            addCriterion("b_money is null");
            return (Criteria) this;
        }

        public Criteria andBMoneyIsNotNull() {
            addCriterion("b_money is not null");
            return (Criteria) this;
        }

        public Criteria andBMoneyEqualTo(Double value) {
            addCriterion("b_money =", value, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyNotEqualTo(Double value) {
            addCriterion("b_money <>", value, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyGreaterThan(Double value) {
            addCriterion("b_money >", value, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("b_money >=", value, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyLessThan(Double value) {
            addCriterion("b_money <", value, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyLessThanOrEqualTo(Double value) {
            addCriterion("b_money <=", value, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyIn(List<Double> values) {
            addCriterion("b_money in", values, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyNotIn(List<Double> values) {
            addCriterion("b_money not in", values, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyBetween(Double value1, Double value2) {
            addCriterion("b_money between", value1, value2, "bMoney");
            return (Criteria) this;
        }

        public Criteria andBMoneyNotBetween(Double value1, Double value2) {
            addCriterion("b_money not between", value1, value2, "bMoney");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andBNumberIsNull() {
            addCriterion("b_number is null");
            return (Criteria) this;
        }

        public Criteria andBNumberIsNotNull() {
            addCriterion("b_number is not null");
            return (Criteria) this;
        }

        public Criteria andBNumberEqualTo(String value) {
            addCriterion("b_number =", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberNotEqualTo(String value) {
            addCriterion("b_number <>", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberGreaterThan(String value) {
            addCriterion("b_number >", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberGreaterThanOrEqualTo(String value) {
            addCriterion("b_number >=", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberLessThan(String value) {
            addCriterion("b_number <", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberLessThanOrEqualTo(String value) {
            addCriterion("b_number <=", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberLike(String value) {
            addCriterion("b_number like", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberNotLike(String value) {
            addCriterion("b_number not like", value, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberIn(List<String> values) {
            addCriterion("b_number in", values, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberNotIn(List<String> values) {
            addCriterion("b_number not in", values, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberBetween(String value1, String value2) {
            addCriterion("b_number between", value1, value2, "bNumber");
            return (Criteria) this;
        }

        public Criteria andBNumberNotBetween(String value1, String value2) {
            addCriterion("b_number not between", value1, value2, "bNumber");
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