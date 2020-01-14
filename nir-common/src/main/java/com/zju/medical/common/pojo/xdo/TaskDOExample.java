package com.zju.medical.common.pojo.xdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskDOExample() {
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

        public Criteria andReySiScoreIsNull() {
            addCriterion("rey_si_score is null");
            return (Criteria) this;
        }

        public Criteria andReySiScoreIsNotNull() {
            addCriterion("rey_si_score is not null");
            return (Criteria) this;
        }

        public Criteria andReySiScoreEqualTo(Integer value) {
            addCriterion("rey_si_score =", value, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreNotEqualTo(Integer value) {
            addCriterion("rey_si_score <>", value, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreGreaterThan(Integer value) {
            addCriterion("rey_si_score >", value, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("rey_si_score >=", value, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreLessThan(Integer value) {
            addCriterion("rey_si_score <", value, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreLessThanOrEqualTo(Integer value) {
            addCriterion("rey_si_score <=", value, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreIn(List<Integer> values) {
            addCriterion("rey_si_score in", values, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreNotIn(List<Integer> values) {
            addCriterion("rey_si_score not in", values, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreBetween(Integer value1, Integer value2) {
            addCriterion("rey_si_score between", value1, value2, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReySiScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("rey_si_score not between", value1, value2, "reySiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreIsNull() {
            addCriterion("rey_di_score is null");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreIsNotNull() {
            addCriterion("rey_di_score is not null");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreEqualTo(Integer value) {
            addCriterion("rey_di_score =", value, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreNotEqualTo(Integer value) {
            addCriterion("rey_di_score <>", value, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreGreaterThan(Integer value) {
            addCriterion("rey_di_score >", value, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("rey_di_score >=", value, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreLessThan(Integer value) {
            addCriterion("rey_di_score <", value, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreLessThanOrEqualTo(Integer value) {
            addCriterion("rey_di_score <=", value, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreIn(List<Integer> values) {
            addCriterion("rey_di_score in", values, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreNotIn(List<Integer> values) {
            addCriterion("rey_di_score not in", values, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreBetween(Integer value1, Integer value2) {
            addCriterion("rey_di_score between", value1, value2, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReyDiScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("rey_di_score not between", value1, value2, "reyDiScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreIsNull() {
            addCriterion("rey_sd_score is null");
            return (Criteria) this;
        }

        public Criteria andReySdScoreIsNotNull() {
            addCriterion("rey_sd_score is not null");
            return (Criteria) this;
        }

        public Criteria andReySdScoreEqualTo(Integer value) {
            addCriterion("rey_sd_score =", value, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreNotEqualTo(Integer value) {
            addCriterion("rey_sd_score <>", value, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreGreaterThan(Integer value) {
            addCriterion("rey_sd_score >", value, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("rey_sd_score >=", value, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreLessThan(Integer value) {
            addCriterion("rey_sd_score <", value, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreLessThanOrEqualTo(Integer value) {
            addCriterion("rey_sd_score <=", value, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreIn(List<Integer> values) {
            addCriterion("rey_sd_score in", values, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreNotIn(List<Integer> values) {
            addCriterion("rey_sd_score not in", values, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreBetween(Integer value1, Integer value2) {
            addCriterion("rey_sd_score between", value1, value2, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReySdScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("rey_sd_score not between", value1, value2, "reySdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreIsNull() {
            addCriterion("rey_dd_score is null");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreIsNotNull() {
            addCriterion("rey_dd_score is not null");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreEqualTo(Integer value) {
            addCriterion("rey_dd_score =", value, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreNotEqualTo(Integer value) {
            addCriterion("rey_dd_score <>", value, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreGreaterThan(Integer value) {
            addCriterion("rey_dd_score >", value, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("rey_dd_score >=", value, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreLessThan(Integer value) {
            addCriterion("rey_dd_score <", value, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreLessThanOrEqualTo(Integer value) {
            addCriterion("rey_dd_score <=", value, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreIn(List<Integer> values) {
            addCriterion("rey_dd_score in", values, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreNotIn(List<Integer> values) {
            addCriterion("rey_dd_score not in", values, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreBetween(Integer value1, Integer value2) {
            addCriterion("rey_dd_score between", value1, value2, "reyDdScore");
            return (Criteria) this;
        }

        public Criteria andReyDdScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("rey_dd_score not between", value1, value2, "reyDdScore");
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

        public Criteria andStroopTimeAIsNull() {
            addCriterion("stroop_time_a is null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeAIsNotNull() {
            addCriterion("stroop_time_a is not null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeAEqualTo(Integer value) {
            addCriterion("stroop_time_a =", value, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeANotEqualTo(Integer value) {
            addCriterion("stroop_time_a <>", value, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeAGreaterThan(Integer value) {
            addCriterion("stroop_time_a >", value, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeAGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_a >=", value, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeALessThan(Integer value) {
            addCriterion("stroop_time_a <", value, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeALessThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_a <=", value, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeAIn(List<Integer> values) {
            addCriterion("stroop_time_a in", values, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeANotIn(List<Integer> values) {
            addCriterion("stroop_time_a not in", values, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeABetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_a between", value1, value2, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeANotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_a not between", value1, value2, "stroopTimeA");
            return (Criteria) this;
        }

        public Criteria andStroopMisAIsNull() {
            addCriterion("stroop_mis_a is null");
            return (Criteria) this;
        }

        public Criteria andStroopMisAIsNotNull() {
            addCriterion("stroop_mis_a is not null");
            return (Criteria) this;
        }

        public Criteria andStroopMisAEqualTo(Integer value) {
            addCriterion("stroop_mis_a =", value, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisANotEqualTo(Integer value) {
            addCriterion("stroop_mis_a <>", value, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisAGreaterThan(Integer value) {
            addCriterion("stroop_mis_a >", value, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisAGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_a >=", value, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisALessThan(Integer value) {
            addCriterion("stroop_mis_a <", value, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisALessThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_a <=", value, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisAIn(List<Integer> values) {
            addCriterion("stroop_mis_a in", values, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisANotIn(List<Integer> values) {
            addCriterion("stroop_mis_a not in", values, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisABetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_a between", value1, value2, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopMisANotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_a not between", value1, value2, "stroopMisA");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBIsNull() {
            addCriterion("stroop_time_b is null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBIsNotNull() {
            addCriterion("stroop_time_b is not null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBEqualTo(Integer value) {
            addCriterion("stroop_time_b =", value, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBNotEqualTo(Integer value) {
            addCriterion("stroop_time_b <>", value, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBGreaterThan(Integer value) {
            addCriterion("stroop_time_b >", value, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_b >=", value, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBLessThan(Integer value) {
            addCriterion("stroop_time_b <", value, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBLessThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_b <=", value, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBIn(List<Integer> values) {
            addCriterion("stroop_time_b in", values, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBNotIn(List<Integer> values) {
            addCriterion("stroop_time_b not in", values, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBBetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_b between", value1, value2, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeBNotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_b not between", value1, value2, "stroopTimeB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBIsNull() {
            addCriterion("stroop_mis_b is null");
            return (Criteria) this;
        }

        public Criteria andStroopMisBIsNotNull() {
            addCriterion("stroop_mis_b is not null");
            return (Criteria) this;
        }

        public Criteria andStroopMisBEqualTo(Integer value) {
            addCriterion("stroop_mis_b =", value, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBNotEqualTo(Integer value) {
            addCriterion("stroop_mis_b <>", value, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBGreaterThan(Integer value) {
            addCriterion("stroop_mis_b >", value, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_b >=", value, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBLessThan(Integer value) {
            addCriterion("stroop_mis_b <", value, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBLessThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_b <=", value, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBIn(List<Integer> values) {
            addCriterion("stroop_mis_b in", values, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBNotIn(List<Integer> values) {
            addCriterion("stroop_mis_b not in", values, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBBetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_b between", value1, value2, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopMisBNotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_b not between", value1, value2, "stroopMisB");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCIsNull() {
            addCriterion("stroop_time_c is null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCIsNotNull() {
            addCriterion("stroop_time_c is not null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCEqualTo(Integer value) {
            addCriterion("stroop_time_c =", value, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCNotEqualTo(Integer value) {
            addCriterion("stroop_time_c <>", value, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCGreaterThan(Integer value) {
            addCriterion("stroop_time_c >", value, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_c >=", value, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCLessThan(Integer value) {
            addCriterion("stroop_time_c <", value, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCLessThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_c <=", value, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCIn(List<Integer> values) {
            addCriterion("stroop_time_c in", values, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCNotIn(List<Integer> values) {
            addCriterion("stroop_time_c not in", values, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCBetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_c between", value1, value2, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeCNotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_c not between", value1, value2, "stroopTimeC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCIsNull() {
            addCriterion("stroop_mis_c is null");
            return (Criteria) this;
        }

        public Criteria andStroopMisCIsNotNull() {
            addCriterion("stroop_mis_c is not null");
            return (Criteria) this;
        }

        public Criteria andStroopMisCEqualTo(Integer value) {
            addCriterion("stroop_mis_c =", value, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCNotEqualTo(Integer value) {
            addCriterion("stroop_mis_c <>", value, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCGreaterThan(Integer value) {
            addCriterion("stroop_mis_c >", value, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_c >=", value, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCLessThan(Integer value) {
            addCriterion("stroop_mis_c <", value, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCLessThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_c <=", value, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCIn(List<Integer> values) {
            addCriterion("stroop_mis_c in", values, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCNotIn(List<Integer> values) {
            addCriterion("stroop_mis_c not in", values, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCBetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_c between", value1, value2, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopMisCNotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_c not between", value1, value2, "stroopMisC");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDIsNull() {
            addCriterion("stroop_time_d is null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDIsNotNull() {
            addCriterion("stroop_time_d is not null");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDEqualTo(Integer value) {
            addCriterion("stroop_time_d =", value, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDNotEqualTo(Integer value) {
            addCriterion("stroop_time_d <>", value, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDGreaterThan(Integer value) {
            addCriterion("stroop_time_d >", value, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_d >=", value, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDLessThan(Integer value) {
            addCriterion("stroop_time_d <", value, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDLessThanOrEqualTo(Integer value) {
            addCriterion("stroop_time_d <=", value, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDIn(List<Integer> values) {
            addCriterion("stroop_time_d in", values, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDNotIn(List<Integer> values) {
            addCriterion("stroop_time_d not in", values, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDBetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_d between", value1, value2, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopTimeDNotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_time_d not between", value1, value2, "stroopTimeD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDIsNull() {
            addCriterion("stroop_mis_d is null");
            return (Criteria) this;
        }

        public Criteria andStroopMisDIsNotNull() {
            addCriterion("stroop_mis_d is not null");
            return (Criteria) this;
        }

        public Criteria andStroopMisDEqualTo(Integer value) {
            addCriterion("stroop_mis_d =", value, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDNotEqualTo(Integer value) {
            addCriterion("stroop_mis_d <>", value, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDGreaterThan(Integer value) {
            addCriterion("stroop_mis_d >", value, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_d >=", value, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDLessThan(Integer value) {
            addCriterion("stroop_mis_d <", value, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDLessThanOrEqualTo(Integer value) {
            addCriterion("stroop_mis_d <=", value, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDIn(List<Integer> values) {
            addCriterion("stroop_mis_d in", values, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDNotIn(List<Integer> values) {
            addCriterion("stroop_mis_d not in", values, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDBetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_d between", value1, value2, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andStroopMisDNotBetween(Integer value1, Integer value2) {
            addCriterion("stroop_mis_d not between", value1, value2, "stroopMisD");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreIsNull() {
            addCriterion("snap_parent_score is null");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreIsNotNull() {
            addCriterion("snap_parent_score is not null");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreEqualTo(Integer value) {
            addCriterion("snap_parent_score =", value, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreNotEqualTo(Integer value) {
            addCriterion("snap_parent_score <>", value, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreGreaterThan(Integer value) {
            addCriterion("snap_parent_score >", value, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("snap_parent_score >=", value, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreLessThan(Integer value) {
            addCriterion("snap_parent_score <", value, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreLessThanOrEqualTo(Integer value) {
            addCriterion("snap_parent_score <=", value, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreIn(List<Integer> values) {
            addCriterion("snap_parent_score in", values, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreNotIn(List<Integer> values) {
            addCriterion("snap_parent_score not in", values, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreBetween(Integer value1, Integer value2) {
            addCriterion("snap_parent_score between", value1, value2, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapParentScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("snap_parent_score not between", value1, value2, "snapParentScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreIsNull() {
            addCriterion("snap_teacher_score is null");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreIsNotNull() {
            addCriterion("snap_teacher_score is not null");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreEqualTo(Integer value) {
            addCriterion("snap_teacher_score =", value, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreNotEqualTo(Integer value) {
            addCriterion("snap_teacher_score <>", value, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreGreaterThan(Integer value) {
            addCriterion("snap_teacher_score >", value, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("snap_teacher_score >=", value, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreLessThan(Integer value) {
            addCriterion("snap_teacher_score <", value, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreLessThanOrEqualTo(Integer value) {
            addCriterion("snap_teacher_score <=", value, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreIn(List<Integer> values) {
            addCriterion("snap_teacher_score in", values, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreNotIn(List<Integer> values) {
            addCriterion("snap_teacher_score not in", values, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreBetween(Integer value1, Integer value2) {
            addCriterion("snap_teacher_score between", value1, value2, "snapTeacherScore");
            return (Criteria) this;
        }

        public Criteria andSnapTeacherScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("snap_teacher_score not between", value1, value2, "snapTeacherScore");
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