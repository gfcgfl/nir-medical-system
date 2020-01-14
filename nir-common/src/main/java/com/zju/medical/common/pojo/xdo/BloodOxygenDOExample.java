package com.zju.medical.common.pojo.xdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BloodOxygenDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BloodOxygenDOExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDataPath1IsNull() {
            addCriterion("data_path1 is null");
            return (Criteria) this;
        }

        public Criteria andDataPath1IsNotNull() {
            addCriterion("data_path1 is not null");
            return (Criteria) this;
        }

        public Criteria andDataPath1EqualTo(String value) {
            addCriterion("data_path1 =", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1NotEqualTo(String value) {
            addCriterion("data_path1 <>", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1GreaterThan(String value) {
            addCriterion("data_path1 >", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1GreaterThanOrEqualTo(String value) {
            addCriterion("data_path1 >=", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1LessThan(String value) {
            addCriterion("data_path1 <", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1LessThanOrEqualTo(String value) {
            addCriterion("data_path1 <=", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1Like(String value) {
            addCriterion("data_path1 like", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1NotLike(String value) {
            addCriterion("data_path1 not like", value, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1In(List<String> values) {
            addCriterion("data_path1 in", values, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1NotIn(List<String> values) {
            addCriterion("data_path1 not in", values, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1Between(String value1, String value2) {
            addCriterion("data_path1 between", value1, value2, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath1NotBetween(String value1, String value2) {
            addCriterion("data_path1 not between", value1, value2, "dataPath1");
            return (Criteria) this;
        }

        public Criteria andDataPath2IsNull() {
            addCriterion("data_path2 is null");
            return (Criteria) this;
        }

        public Criteria andDataPath2IsNotNull() {
            addCriterion("data_path2 is not null");
            return (Criteria) this;
        }

        public Criteria andDataPath2EqualTo(String value) {
            addCriterion("data_path2 =", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2NotEqualTo(String value) {
            addCriterion("data_path2 <>", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2GreaterThan(String value) {
            addCriterion("data_path2 >", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2GreaterThanOrEqualTo(String value) {
            addCriterion("data_path2 >=", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2LessThan(String value) {
            addCriterion("data_path2 <", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2LessThanOrEqualTo(String value) {
            addCriterion("data_path2 <=", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2Like(String value) {
            addCriterion("data_path2 like", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2NotLike(String value) {
            addCriterion("data_path2 not like", value, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2In(List<String> values) {
            addCriterion("data_path2 in", values, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2NotIn(List<String> values) {
            addCriterion("data_path2 not in", values, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2Between(String value1, String value2) {
            addCriterion("data_path2 between", value1, value2, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath2NotBetween(String value1, String value2) {
            addCriterion("data_path2 not between", value1, value2, "dataPath2");
            return (Criteria) this;
        }

        public Criteria andDataPath3IsNull() {
            addCriterion("data_path3 is null");
            return (Criteria) this;
        }

        public Criteria andDataPath3IsNotNull() {
            addCriterion("data_path3 is not null");
            return (Criteria) this;
        }

        public Criteria andDataPath3EqualTo(String value) {
            addCriterion("data_path3 =", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3NotEqualTo(String value) {
            addCriterion("data_path3 <>", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3GreaterThan(String value) {
            addCriterion("data_path3 >", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3GreaterThanOrEqualTo(String value) {
            addCriterion("data_path3 >=", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3LessThan(String value) {
            addCriterion("data_path3 <", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3LessThanOrEqualTo(String value) {
            addCriterion("data_path3 <=", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3Like(String value) {
            addCriterion("data_path3 like", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3NotLike(String value) {
            addCriterion("data_path3 not like", value, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3In(List<String> values) {
            addCriterion("data_path3 in", values, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3NotIn(List<String> values) {
            addCriterion("data_path3 not in", values, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3Between(String value1, String value2) {
            addCriterion("data_path3 between", value1, value2, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath3NotBetween(String value1, String value2) {
            addCriterion("data_path3 not between", value1, value2, "dataPath3");
            return (Criteria) this;
        }

        public Criteria andDataPath4IsNull() {
            addCriterion("data_path4 is null");
            return (Criteria) this;
        }

        public Criteria andDataPath4IsNotNull() {
            addCriterion("data_path4 is not null");
            return (Criteria) this;
        }

        public Criteria andDataPath4EqualTo(String value) {
            addCriterion("data_path4 =", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4NotEqualTo(String value) {
            addCriterion("data_path4 <>", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4GreaterThan(String value) {
            addCriterion("data_path4 >", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4GreaterThanOrEqualTo(String value) {
            addCriterion("data_path4 >=", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4LessThan(String value) {
            addCriterion("data_path4 <", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4LessThanOrEqualTo(String value) {
            addCriterion("data_path4 <=", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4Like(String value) {
            addCriterion("data_path4 like", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4NotLike(String value) {
            addCriterion("data_path4 not like", value, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4In(List<String> values) {
            addCriterion("data_path4 in", values, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4NotIn(List<String> values) {
            addCriterion("data_path4 not in", values, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4Between(String value1, String value2) {
            addCriterion("data_path4 between", value1, value2, "dataPath4");
            return (Criteria) this;
        }

        public Criteria andDataPath4NotBetween(String value1, String value2) {
            addCriterion("data_path4 not between", value1, value2, "dataPath4");
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