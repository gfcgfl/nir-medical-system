package com.zju.medical.common.pojo.xdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WordTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WordTaskDOExample() {
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

        public Criteria andAWordMisIsNull() {
            addCriterion("a_word_mis is null");
            return (Criteria) this;
        }

        public Criteria andAWordMisIsNotNull() {
            addCriterion("a_word_mis is not null");
            return (Criteria) this;
        }

        public Criteria andAWordMisEqualTo(Integer value) {
            addCriterion("a_word_mis =", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisNotEqualTo(Integer value) {
            addCriterion("a_word_mis <>", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisGreaterThan(Integer value) {
            addCriterion("a_word_mis >", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_word_mis >=", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisLessThan(Integer value) {
            addCriterion("a_word_mis <", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisLessThanOrEqualTo(Integer value) {
            addCriterion("a_word_mis <=", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisIn(List<Integer> values) {
            addCriterion("a_word_mis in", values, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisNotIn(List<Integer> values) {
            addCriterion("a_word_mis not in", values, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisBetween(Integer value1, Integer value2) {
            addCriterion("a_word_mis between", value1, value2, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisNotBetween(Integer value1, Integer value2) {
            addCriterion("a_word_mis not between", value1, value2, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordTimeIsNull() {
            addCriterion("a_word_time is null");
            return (Criteria) this;
        }

        public Criteria andAWordTimeIsNotNull() {
            addCriterion("a_word_time is not null");
            return (Criteria) this;
        }

        public Criteria andAWordTimeEqualTo(Integer value) {
            addCriterion("a_word_time =", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeNotEqualTo(Integer value) {
            addCriterion("a_word_time <>", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeGreaterThan(Integer value) {
            addCriterion("a_word_time >", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_word_time >=", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeLessThan(Integer value) {
            addCriterion("a_word_time <", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeLessThanOrEqualTo(Integer value) {
            addCriterion("a_word_time <=", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeIn(List<Integer> values) {
            addCriterion("a_word_time in", values, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeNotIn(List<Integer> values) {
            addCriterion("a_word_time not in", values, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeBetween(Integer value1, Integer value2) {
            addCriterion("a_word_time between", value1, value2, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("a_word_time not between", value1, value2, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordStartIsNull() {
            addCriterion("a_word_start is null");
            return (Criteria) this;
        }

        public Criteria andAWordStartIsNotNull() {
            addCriterion("a_word_start is not null");
            return (Criteria) this;
        }

        public Criteria andAWordStartEqualTo(String value) {
            addCriterion("a_word_start =", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartNotEqualTo(String value) {
            addCriterion("a_word_start <>", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartGreaterThan(String value) {
            addCriterion("a_word_start >", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartGreaterThanOrEqualTo(String value) {
            addCriterion("a_word_start >=", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartLessThan(String value) {
            addCriterion("a_word_start <", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartLessThanOrEqualTo(String value) {
            addCriterion("a_word_start <=", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartLike(String value) {
            addCriterion("a_word_start like", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartNotLike(String value) {
            addCriterion("a_word_start not like", value, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartIn(List<String> values) {
            addCriterion("a_word_start in", values, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartNotIn(List<String> values) {
            addCriterion("a_word_start not in", values, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartBetween(String value1, String value2) {
            addCriterion("a_word_start between", value1, value2, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordStartNotBetween(String value1, String value2) {
            addCriterion("a_word_start not between", value1, value2, "aWordStart");
            return (Criteria) this;
        }

        public Criteria andAWordEndIsNull() {
            addCriterion("a_word_end is null");
            return (Criteria) this;
        }

        public Criteria andAWordEndIsNotNull() {
            addCriterion("a_word_end is not null");
            return (Criteria) this;
        }

        public Criteria andAWordEndEqualTo(String value) {
            addCriterion("a_word_end =", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndNotEqualTo(String value) {
            addCriterion("a_word_end <>", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndGreaterThan(String value) {
            addCriterion("a_word_end >", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndGreaterThanOrEqualTo(String value) {
            addCriterion("a_word_end >=", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndLessThan(String value) {
            addCriterion("a_word_end <", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndLessThanOrEqualTo(String value) {
            addCriterion("a_word_end <=", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndLike(String value) {
            addCriterion("a_word_end like", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndNotLike(String value) {
            addCriterion("a_word_end not like", value, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndIn(List<String> values) {
            addCriterion("a_word_end in", values, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndNotIn(List<String> values) {
            addCriterion("a_word_end not in", values, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndBetween(String value1, String value2) {
            addCriterion("a_word_end between", value1, value2, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andAWordEndNotBetween(String value1, String value2) {
            addCriterion("a_word_end not between", value1, value2, "aWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordMisIsNull() {
            addCriterion("b_word_mis is null");
            return (Criteria) this;
        }

        public Criteria andBWordMisIsNotNull() {
            addCriterion("b_word_mis is not null");
            return (Criteria) this;
        }

        public Criteria andBWordMisEqualTo(Integer value) {
            addCriterion("b_word_mis =", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisNotEqualTo(Integer value) {
            addCriterion("b_word_mis <>", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisGreaterThan(Integer value) {
            addCriterion("b_word_mis >", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_word_mis >=", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisLessThan(Integer value) {
            addCriterion("b_word_mis <", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisLessThanOrEqualTo(Integer value) {
            addCriterion("b_word_mis <=", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisIn(List<Integer> values) {
            addCriterion("b_word_mis in", values, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisNotIn(List<Integer> values) {
            addCriterion("b_word_mis not in", values, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisBetween(Integer value1, Integer value2) {
            addCriterion("b_word_mis between", value1, value2, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisNotBetween(Integer value1, Integer value2) {
            addCriterion("b_word_mis not between", value1, value2, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordTimeIsNull() {
            addCriterion("b_word_time is null");
            return (Criteria) this;
        }

        public Criteria andBWordTimeIsNotNull() {
            addCriterion("b_word_time is not null");
            return (Criteria) this;
        }

        public Criteria andBWordTimeEqualTo(Integer value) {
            addCriterion("b_word_time =", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeNotEqualTo(Integer value) {
            addCriterion("b_word_time <>", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeGreaterThan(Integer value) {
            addCriterion("b_word_time >", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_word_time >=", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeLessThan(Integer value) {
            addCriterion("b_word_time <", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeLessThanOrEqualTo(Integer value) {
            addCriterion("b_word_time <=", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeIn(List<Integer> values) {
            addCriterion("b_word_time in", values, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeNotIn(List<Integer> values) {
            addCriterion("b_word_time not in", values, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeBetween(Integer value1, Integer value2) {
            addCriterion("b_word_time between", value1, value2, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("b_word_time not between", value1, value2, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordStartIsNull() {
            addCriterion("b_word_start is null");
            return (Criteria) this;
        }

        public Criteria andBWordStartIsNotNull() {
            addCriterion("b_word_start is not null");
            return (Criteria) this;
        }

        public Criteria andBWordStartEqualTo(String value) {
            addCriterion("b_word_start =", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartNotEqualTo(String value) {
            addCriterion("b_word_start <>", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartGreaterThan(String value) {
            addCriterion("b_word_start >", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartGreaterThanOrEqualTo(String value) {
            addCriterion("b_word_start >=", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartLessThan(String value) {
            addCriterion("b_word_start <", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartLessThanOrEqualTo(String value) {
            addCriterion("b_word_start <=", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartLike(String value) {
            addCriterion("b_word_start like", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartNotLike(String value) {
            addCriterion("b_word_start not like", value, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartIn(List<String> values) {
            addCriterion("b_word_start in", values, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartNotIn(List<String> values) {
            addCriterion("b_word_start not in", values, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartBetween(String value1, String value2) {
            addCriterion("b_word_start between", value1, value2, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordStartNotBetween(String value1, String value2) {
            addCriterion("b_word_start not between", value1, value2, "bWordStart");
            return (Criteria) this;
        }

        public Criteria andBWordEndIsNull() {
            addCriterion("b_word_end is null");
            return (Criteria) this;
        }

        public Criteria andBWordEndIsNotNull() {
            addCriterion("b_word_end is not null");
            return (Criteria) this;
        }

        public Criteria andBWordEndEqualTo(String value) {
            addCriterion("b_word_end =", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndNotEqualTo(String value) {
            addCriterion("b_word_end <>", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndGreaterThan(String value) {
            addCriterion("b_word_end >", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndGreaterThanOrEqualTo(String value) {
            addCriterion("b_word_end >=", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndLessThan(String value) {
            addCriterion("b_word_end <", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndLessThanOrEqualTo(String value) {
            addCriterion("b_word_end <=", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndLike(String value) {
            addCriterion("b_word_end like", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndNotLike(String value) {
            addCriterion("b_word_end not like", value, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndIn(List<String> values) {
            addCriterion("b_word_end in", values, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndNotIn(List<String> values) {
            addCriterion("b_word_end not in", values, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndBetween(String value1, String value2) {
            addCriterion("b_word_end between", value1, value2, "bWordEnd");
            return (Criteria) this;
        }

        public Criteria andBWordEndNotBetween(String value1, String value2) {
            addCriterion("b_word_end not between", value1, value2, "bWordEnd");
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