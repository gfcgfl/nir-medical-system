package com.zju.medical.common.pojo.xdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StroopTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StroopTaskDOExample() {
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

        public Criteria andAStroopMisIsNull() {
            addCriterion("a_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andAStroopMisIsNotNull() {
            addCriterion("a_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andAStroopMisEqualTo(Integer value) {
            addCriterion("a_stroop_mis =", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisNotEqualTo(Integer value) {
            addCriterion("a_stroop_mis <>", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisGreaterThan(Integer value) {
            addCriterion("a_stroop_mis >", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_mis >=", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisLessThan(Integer value) {
            addCriterion("a_stroop_mis <", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_mis <=", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisIn(List<Integer> values) {
            addCriterion("a_stroop_mis in", values, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisNotIn(List<Integer> values) {
            addCriterion("a_stroop_mis not in", values, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_mis between", value1, value2, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_mis not between", value1, value2, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeIsNull() {
            addCriterion("a_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeIsNotNull() {
            addCriterion("a_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeEqualTo(Integer value) {
            addCriterion("a_stroop_time =", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeNotEqualTo(Integer value) {
            addCriterion("a_stroop_time <>", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeGreaterThan(Integer value) {
            addCriterion("a_stroop_time >", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_time >=", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeLessThan(Integer value) {
            addCriterion("a_stroop_time <", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_time <=", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeIn(List<Integer> values) {
            addCriterion("a_stroop_time in", values, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeNotIn(List<Integer> values) {
            addCriterion("a_stroop_time not in", values, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_time between", value1, value2, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_time not between", value1, value2, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopStartIsNull() {
            addCriterion("a_stroop_start is null");
            return (Criteria) this;
        }

        public Criteria andAStroopStartIsNotNull() {
            addCriterion("a_stroop_start is not null");
            return (Criteria) this;
        }

        public Criteria andAStroopStartEqualTo(String value) {
            addCriterion("a_stroop_start =", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartNotEqualTo(String value) {
            addCriterion("a_stroop_start <>", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartGreaterThan(String value) {
            addCriterion("a_stroop_start >", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartGreaterThanOrEqualTo(String value) {
            addCriterion("a_stroop_start >=", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartLessThan(String value) {
            addCriterion("a_stroop_start <", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartLessThanOrEqualTo(String value) {
            addCriterion("a_stroop_start <=", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartLike(String value) {
            addCriterion("a_stroop_start like", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartNotLike(String value) {
            addCriterion("a_stroop_start not like", value, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartIn(List<String> values) {
            addCriterion("a_stroop_start in", values, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartNotIn(List<String> values) {
            addCriterion("a_stroop_start not in", values, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartBetween(String value1, String value2) {
            addCriterion("a_stroop_start between", value1, value2, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopStartNotBetween(String value1, String value2) {
            addCriterion("a_stroop_start not between", value1, value2, "aStroopStart");
            return (Criteria) this;
        }

        public Criteria andAStroopEndIsNull() {
            addCriterion("a_stroop_end is null");
            return (Criteria) this;
        }

        public Criteria andAStroopEndIsNotNull() {
            addCriterion("a_stroop_end is not null");
            return (Criteria) this;
        }

        public Criteria andAStroopEndEqualTo(String value) {
            addCriterion("a_stroop_end =", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndNotEqualTo(String value) {
            addCriterion("a_stroop_end <>", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndGreaterThan(String value) {
            addCriterion("a_stroop_end >", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndGreaterThanOrEqualTo(String value) {
            addCriterion("a_stroop_end >=", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndLessThan(String value) {
            addCriterion("a_stroop_end <", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndLessThanOrEqualTo(String value) {
            addCriterion("a_stroop_end <=", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndLike(String value) {
            addCriterion("a_stroop_end like", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndNotLike(String value) {
            addCriterion("a_stroop_end not like", value, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndIn(List<String> values) {
            addCriterion("a_stroop_end in", values, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndNotIn(List<String> values) {
            addCriterion("a_stroop_end not in", values, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndBetween(String value1, String value2) {
            addCriterion("a_stroop_end between", value1, value2, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andAStroopEndNotBetween(String value1, String value2) {
            addCriterion("a_stroop_end not between", value1, value2, "aStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopMisIsNull() {
            addCriterion("b_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andBStroopMisIsNotNull() {
            addCriterion("b_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andBStroopMisEqualTo(Integer value) {
            addCriterion("b_stroop_mis =", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisNotEqualTo(Integer value) {
            addCriterion("b_stroop_mis <>", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisGreaterThan(Integer value) {
            addCriterion("b_stroop_mis >", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_mis >=", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisLessThan(Integer value) {
            addCriterion("b_stroop_mis <", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_mis <=", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisIn(List<Integer> values) {
            addCriterion("b_stroop_mis in", values, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisNotIn(List<Integer> values) {
            addCriterion("b_stroop_mis not in", values, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_mis between", value1, value2, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_mis not between", value1, value2, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeIsNull() {
            addCriterion("b_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeIsNotNull() {
            addCriterion("b_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeEqualTo(Integer value) {
            addCriterion("b_stroop_time =", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeNotEqualTo(Integer value) {
            addCriterion("b_stroop_time <>", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeGreaterThan(Integer value) {
            addCriterion("b_stroop_time >", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_time >=", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeLessThan(Integer value) {
            addCriterion("b_stroop_time <", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_time <=", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeIn(List<Integer> values) {
            addCriterion("b_stroop_time in", values, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeNotIn(List<Integer> values) {
            addCriterion("b_stroop_time not in", values, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_time between", value1, value2, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_time not between", value1, value2, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopStartIsNull() {
            addCriterion("b_stroop_start is null");
            return (Criteria) this;
        }

        public Criteria andBStroopStartIsNotNull() {
            addCriterion("b_stroop_start is not null");
            return (Criteria) this;
        }

        public Criteria andBStroopStartEqualTo(String value) {
            addCriterion("b_stroop_start =", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartNotEqualTo(String value) {
            addCriterion("b_stroop_start <>", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartGreaterThan(String value) {
            addCriterion("b_stroop_start >", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartGreaterThanOrEqualTo(String value) {
            addCriterion("b_stroop_start >=", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartLessThan(String value) {
            addCriterion("b_stroop_start <", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartLessThanOrEqualTo(String value) {
            addCriterion("b_stroop_start <=", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartLike(String value) {
            addCriterion("b_stroop_start like", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartNotLike(String value) {
            addCriterion("b_stroop_start not like", value, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartIn(List<String> values) {
            addCriterion("b_stroop_start in", values, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartNotIn(List<String> values) {
            addCriterion("b_stroop_start not in", values, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartBetween(String value1, String value2) {
            addCriterion("b_stroop_start between", value1, value2, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopStartNotBetween(String value1, String value2) {
            addCriterion("b_stroop_start not between", value1, value2, "bStroopStart");
            return (Criteria) this;
        }

        public Criteria andBStroopEndIsNull() {
            addCriterion("b_stroop_end is null");
            return (Criteria) this;
        }

        public Criteria andBStroopEndIsNotNull() {
            addCriterion("b_stroop_end is not null");
            return (Criteria) this;
        }

        public Criteria andBStroopEndEqualTo(String value) {
            addCriterion("b_stroop_end =", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndNotEqualTo(String value) {
            addCriterion("b_stroop_end <>", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndGreaterThan(String value) {
            addCriterion("b_stroop_end >", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndGreaterThanOrEqualTo(String value) {
            addCriterion("b_stroop_end >=", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndLessThan(String value) {
            addCriterion("b_stroop_end <", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndLessThanOrEqualTo(String value) {
            addCriterion("b_stroop_end <=", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndLike(String value) {
            addCriterion("b_stroop_end like", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndNotLike(String value) {
            addCriterion("b_stroop_end not like", value, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndIn(List<String> values) {
            addCriterion("b_stroop_end in", values, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndNotIn(List<String> values) {
            addCriterion("b_stroop_end not in", values, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndBetween(String value1, String value2) {
            addCriterion("b_stroop_end between", value1, value2, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andBStroopEndNotBetween(String value1, String value2) {
            addCriterion("b_stroop_end not between", value1, value2, "bStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopMisIsNull() {
            addCriterion("c_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andCStroopMisIsNotNull() {
            addCriterion("c_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andCStroopMisEqualTo(Integer value) {
            addCriterion("c_stroop_mis =", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisNotEqualTo(Integer value) {
            addCriterion("c_stroop_mis <>", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisGreaterThan(Integer value) {
            addCriterion("c_stroop_mis >", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_mis >=", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisLessThan(Integer value) {
            addCriterion("c_stroop_mis <", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_mis <=", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisIn(List<Integer> values) {
            addCriterion("c_stroop_mis in", values, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisNotIn(List<Integer> values) {
            addCriterion("c_stroop_mis not in", values, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_mis between", value1, value2, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_mis not between", value1, value2, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeIsNull() {
            addCriterion("c_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeIsNotNull() {
            addCriterion("c_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeEqualTo(Integer value) {
            addCriterion("c_stroop_time =", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeNotEqualTo(Integer value) {
            addCriterion("c_stroop_time <>", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeGreaterThan(Integer value) {
            addCriterion("c_stroop_time >", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_time >=", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeLessThan(Integer value) {
            addCriterion("c_stroop_time <", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_time <=", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeIn(List<Integer> values) {
            addCriterion("c_stroop_time in", values, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeNotIn(List<Integer> values) {
            addCriterion("c_stroop_time not in", values, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_time between", value1, value2, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_time not between", value1, value2, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopStartIsNull() {
            addCriterion("c_stroop_start is null");
            return (Criteria) this;
        }

        public Criteria andCStroopStartIsNotNull() {
            addCriterion("c_stroop_start is not null");
            return (Criteria) this;
        }

        public Criteria andCStroopStartEqualTo(String value) {
            addCriterion("c_stroop_start =", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartNotEqualTo(String value) {
            addCriterion("c_stroop_start <>", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartGreaterThan(String value) {
            addCriterion("c_stroop_start >", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartGreaterThanOrEqualTo(String value) {
            addCriterion("c_stroop_start >=", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartLessThan(String value) {
            addCriterion("c_stroop_start <", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartLessThanOrEqualTo(String value) {
            addCriterion("c_stroop_start <=", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartLike(String value) {
            addCriterion("c_stroop_start like", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartNotLike(String value) {
            addCriterion("c_stroop_start not like", value, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartIn(List<String> values) {
            addCriterion("c_stroop_start in", values, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartNotIn(List<String> values) {
            addCriterion("c_stroop_start not in", values, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartBetween(String value1, String value2) {
            addCriterion("c_stroop_start between", value1, value2, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopStartNotBetween(String value1, String value2) {
            addCriterion("c_stroop_start not between", value1, value2, "cStroopStart");
            return (Criteria) this;
        }

        public Criteria andCStroopEndIsNull() {
            addCriterion("c_stroop_end is null");
            return (Criteria) this;
        }

        public Criteria andCStroopEndIsNotNull() {
            addCriterion("c_stroop_end is not null");
            return (Criteria) this;
        }

        public Criteria andCStroopEndEqualTo(String value) {
            addCriterion("c_stroop_end =", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndNotEqualTo(String value) {
            addCriterion("c_stroop_end <>", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndGreaterThan(String value) {
            addCriterion("c_stroop_end >", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndGreaterThanOrEqualTo(String value) {
            addCriterion("c_stroop_end >=", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndLessThan(String value) {
            addCriterion("c_stroop_end <", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndLessThanOrEqualTo(String value) {
            addCriterion("c_stroop_end <=", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndLike(String value) {
            addCriterion("c_stroop_end like", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndNotLike(String value) {
            addCriterion("c_stroop_end not like", value, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndIn(List<String> values) {
            addCriterion("c_stroop_end in", values, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndNotIn(List<String> values) {
            addCriterion("c_stroop_end not in", values, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndBetween(String value1, String value2) {
            addCriterion("c_stroop_end between", value1, value2, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andCStroopEndNotBetween(String value1, String value2) {
            addCriterion("c_stroop_end not between", value1, value2, "cStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopMisIsNull() {
            addCriterion("d_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andDStroopMisIsNotNull() {
            addCriterion("d_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andDStroopMisEqualTo(Integer value) {
            addCriterion("d_stroop_mis =", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisNotEqualTo(Integer value) {
            addCriterion("d_stroop_mis <>", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisGreaterThan(Integer value) {
            addCriterion("d_stroop_mis >", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_mis >=", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisLessThan(Integer value) {
            addCriterion("d_stroop_mis <", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_mis <=", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisIn(List<Integer> values) {
            addCriterion("d_stroop_mis in", values, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisNotIn(List<Integer> values) {
            addCriterion("d_stroop_mis not in", values, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_mis between", value1, value2, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_mis not between", value1, value2, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeIsNull() {
            addCriterion("d_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeIsNotNull() {
            addCriterion("d_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeEqualTo(Integer value) {
            addCriterion("d_stroop_time =", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeNotEqualTo(Integer value) {
            addCriterion("d_stroop_time <>", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeGreaterThan(Integer value) {
            addCriterion("d_stroop_time >", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_time >=", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeLessThan(Integer value) {
            addCriterion("d_stroop_time <", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_time <=", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeIn(List<Integer> values) {
            addCriterion("d_stroop_time in", values, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeNotIn(List<Integer> values) {
            addCriterion("d_stroop_time not in", values, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_time between", value1, value2, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_time not between", value1, value2, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopStartIsNull() {
            addCriterion("d_stroop_start is null");
            return (Criteria) this;
        }

        public Criteria andDStroopStartIsNotNull() {
            addCriterion("d_stroop_start is not null");
            return (Criteria) this;
        }

        public Criteria andDStroopStartEqualTo(String value) {
            addCriterion("d_stroop_start =", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartNotEqualTo(String value) {
            addCriterion("d_stroop_start <>", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartGreaterThan(String value) {
            addCriterion("d_stroop_start >", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartGreaterThanOrEqualTo(String value) {
            addCriterion("d_stroop_start >=", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartLessThan(String value) {
            addCriterion("d_stroop_start <", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartLessThanOrEqualTo(String value) {
            addCriterion("d_stroop_start <=", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartLike(String value) {
            addCriterion("d_stroop_start like", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartNotLike(String value) {
            addCriterion("d_stroop_start not like", value, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartIn(List<String> values) {
            addCriterion("d_stroop_start in", values, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartNotIn(List<String> values) {
            addCriterion("d_stroop_start not in", values, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartBetween(String value1, String value2) {
            addCriterion("d_stroop_start between", value1, value2, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopStartNotBetween(String value1, String value2) {
            addCriterion("d_stroop_start not between", value1, value2, "dStroopStart");
            return (Criteria) this;
        }

        public Criteria andDStroopEndIsNull() {
            addCriterion("d_stroop_end is null");
            return (Criteria) this;
        }

        public Criteria andDStroopEndIsNotNull() {
            addCriterion("d_stroop_end is not null");
            return (Criteria) this;
        }

        public Criteria andDStroopEndEqualTo(String value) {
            addCriterion("d_stroop_end =", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndNotEqualTo(String value) {
            addCriterion("d_stroop_end <>", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndGreaterThan(String value) {
            addCriterion("d_stroop_end >", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndGreaterThanOrEqualTo(String value) {
            addCriterion("d_stroop_end >=", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndLessThan(String value) {
            addCriterion("d_stroop_end <", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndLessThanOrEqualTo(String value) {
            addCriterion("d_stroop_end <=", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndLike(String value) {
            addCriterion("d_stroop_end like", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndNotLike(String value) {
            addCriterion("d_stroop_end not like", value, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndIn(List<String> values) {
            addCriterion("d_stroop_end in", values, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndNotIn(List<String> values) {
            addCriterion("d_stroop_end not in", values, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndBetween(String value1, String value2) {
            addCriterion("d_stroop_end between", value1, value2, "dStroopEnd");
            return (Criteria) this;
        }

        public Criteria andDStroopEndNotBetween(String value1, String value2) {
            addCriterion("d_stroop_end not between", value1, value2, "dStroopEnd");
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