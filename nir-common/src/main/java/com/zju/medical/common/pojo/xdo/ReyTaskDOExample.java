package com.zju.medical.common.pojo.xdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReyTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReyTaskDOExample() {
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

        public Criteria andReyPresentStartIsNull() {
            addCriterion("rey_present_start is null");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartIsNotNull() {
            addCriterion("rey_present_start is not null");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartEqualTo(String value) {
            addCriterion("rey_present_start =", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartNotEqualTo(String value) {
            addCriterion("rey_present_start <>", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartGreaterThan(String value) {
            addCriterion("rey_present_start >", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartGreaterThanOrEqualTo(String value) {
            addCriterion("rey_present_start >=", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartLessThan(String value) {
            addCriterion("rey_present_start <", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartLessThanOrEqualTo(String value) {
            addCriterion("rey_present_start <=", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartLike(String value) {
            addCriterion("rey_present_start like", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartNotLike(String value) {
            addCriterion("rey_present_start not like", value, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartIn(List<String> values) {
            addCriterion("rey_present_start in", values, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartNotIn(List<String> values) {
            addCriterion("rey_present_start not in", values, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartBetween(String value1, String value2) {
            addCriterion("rey_present_start between", value1, value2, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentStartNotBetween(String value1, String value2) {
            addCriterion("rey_present_start not between", value1, value2, "reyPresentStart");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndIsNull() {
            addCriterion("rey_present_end is null");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndIsNotNull() {
            addCriterion("rey_present_end is not null");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndEqualTo(String value) {
            addCriterion("rey_present_end =", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndNotEqualTo(String value) {
            addCriterion("rey_present_end <>", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndGreaterThan(String value) {
            addCriterion("rey_present_end >", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndGreaterThanOrEqualTo(String value) {
            addCriterion("rey_present_end >=", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndLessThan(String value) {
            addCriterion("rey_present_end <", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndLessThanOrEqualTo(String value) {
            addCriterion("rey_present_end <=", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndLike(String value) {
            addCriterion("rey_present_end like", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndNotLike(String value) {
            addCriterion("rey_present_end not like", value, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndIn(List<String> values) {
            addCriterion("rey_present_end in", values, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndNotIn(List<String> values) {
            addCriterion("rey_present_end not in", values, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndBetween(String value1, String value2) {
            addCriterion("rey_present_end between", value1, value2, "reyPresentEnd");
            return (Criteria) this;
        }

        public Criteria andReyPresentEndNotBetween(String value1, String value2) {
            addCriterion("rey_present_end not between", value1, value2, "reyPresentEnd");
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

        public Criteria andReyDelayStartIsNull() {
            addCriterion("rey_delay_start is null");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartIsNotNull() {
            addCriterion("rey_delay_start is not null");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartEqualTo(String value) {
            addCriterion("rey_delay_start =", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartNotEqualTo(String value) {
            addCriterion("rey_delay_start <>", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartGreaterThan(String value) {
            addCriterion("rey_delay_start >", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartGreaterThanOrEqualTo(String value) {
            addCriterion("rey_delay_start >=", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartLessThan(String value) {
            addCriterion("rey_delay_start <", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartLessThanOrEqualTo(String value) {
            addCriterion("rey_delay_start <=", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartLike(String value) {
            addCriterion("rey_delay_start like", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartNotLike(String value) {
            addCriterion("rey_delay_start not like", value, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartIn(List<String> values) {
            addCriterion("rey_delay_start in", values, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartNotIn(List<String> values) {
            addCriterion("rey_delay_start not in", values, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartBetween(String value1, String value2) {
            addCriterion("rey_delay_start between", value1, value2, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayStartNotBetween(String value1, String value2) {
            addCriterion("rey_delay_start not between", value1, value2, "reyDelayStart");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndIsNull() {
            addCriterion("rey_delay_end is null");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndIsNotNull() {
            addCriterion("rey_delay_end is not null");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndEqualTo(String value) {
            addCriterion("rey_delay_end =", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndNotEqualTo(String value) {
            addCriterion("rey_delay_end <>", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndGreaterThan(String value) {
            addCriterion("rey_delay_end >", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndGreaterThanOrEqualTo(String value) {
            addCriterion("rey_delay_end >=", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndLessThan(String value) {
            addCriterion("rey_delay_end <", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndLessThanOrEqualTo(String value) {
            addCriterion("rey_delay_end <=", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndLike(String value) {
            addCriterion("rey_delay_end like", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndNotLike(String value) {
            addCriterion("rey_delay_end not like", value, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndIn(List<String> values) {
            addCriterion("rey_delay_end in", values, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndNotIn(List<String> values) {
            addCriterion("rey_delay_end not in", values, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndBetween(String value1, String value2) {
            addCriterion("rey_delay_end between", value1, value2, "reyDelayEnd");
            return (Criteria) this;
        }

        public Criteria andReyDelayEndNotBetween(String value1, String value2) {
            addCriterion("rey_delay_end not between", value1, value2, "reyDelayEnd");
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