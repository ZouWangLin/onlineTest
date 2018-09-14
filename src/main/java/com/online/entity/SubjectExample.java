package com.online.entity;

import java.util.ArrayList;
import java.util.List;

public class SubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectExample() {
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

        public Criteria andSubjectidIsNull() {
            addCriterion("subjectId is null");
            return (Criteria) this;
        }

        public Criteria andSubjectidIsNotNull() {
            addCriterion("subjectId is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectidEqualTo(Integer value) {
            addCriterion("subjectId =", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotEqualTo(Integer value) {
            addCriterion("subjectId <>", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThan(Integer value) {
            addCriterion("subjectId >", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("subjectId >=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThan(Integer value) {
            addCriterion("subjectId <", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThanOrEqualTo(Integer value) {
            addCriterion("subjectId <=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidIn(List<Integer> values) {
            addCriterion("subjectId in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotIn(List<Integer> values) {
            addCriterion("subjectId not in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidBetween(Integer value1, Integer value2) {
            addCriterion("subjectId between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("subjectId not between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleIsNull() {
            addCriterion("subjectTitle is null");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleIsNotNull() {
            addCriterion("subjectTitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleEqualTo(String value) {
            addCriterion("subjectTitle =", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleNotEqualTo(String value) {
            addCriterion("subjectTitle <>", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleGreaterThan(String value) {
            addCriterion("subjectTitle >", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleGreaterThanOrEqualTo(String value) {
            addCriterion("subjectTitle >=", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleLessThan(String value) {
            addCriterion("subjectTitle <", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleLessThanOrEqualTo(String value) {
            addCriterion("subjectTitle <=", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleLike(String value) {
            addCriterion("subjectTitle like", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleNotLike(String value) {
            addCriterion("subjectTitle not like", value, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleIn(List<String> values) {
            addCriterion("subjectTitle in", values, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleNotIn(List<String> values) {
            addCriterion("subjectTitle not in", values, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleBetween(String value1, String value2) {
            addCriterion("subjectTitle between", value1, value2, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjecttitleNotBetween(String value1, String value2) {
            addCriterion("subjectTitle not between", value1, value2, "subjecttitle");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaIsNull() {
            addCriterion("subjectOptionA is null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaIsNotNull() {
            addCriterion("subjectOptionA is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaEqualTo(String value) {
            addCriterion("subjectOptionA =", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaNotEqualTo(String value) {
            addCriterion("subjectOptionA <>", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaGreaterThan(String value) {
            addCriterion("subjectOptionA >", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaGreaterThanOrEqualTo(String value) {
            addCriterion("subjectOptionA >=", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaLessThan(String value) {
            addCriterion("subjectOptionA <", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaLessThanOrEqualTo(String value) {
            addCriterion("subjectOptionA <=", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaLike(String value) {
            addCriterion("subjectOptionA like", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaNotLike(String value) {
            addCriterion("subjectOptionA not like", value, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaIn(List<String> values) {
            addCriterion("subjectOptionA in", values, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaNotIn(List<String> values) {
            addCriterion("subjectOptionA not in", values, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaBetween(String value1, String value2) {
            addCriterion("subjectOptionA between", value1, value2, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionaNotBetween(String value1, String value2) {
            addCriterion("subjectOptionA not between", value1, value2, "subjectoptiona");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbIsNull() {
            addCriterion("subjectOptionB is null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbIsNotNull() {
            addCriterion("subjectOptionB is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbEqualTo(String value) {
            addCriterion("subjectOptionB =", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbNotEqualTo(String value) {
            addCriterion("subjectOptionB <>", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbGreaterThan(String value) {
            addCriterion("subjectOptionB >", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbGreaterThanOrEqualTo(String value) {
            addCriterion("subjectOptionB >=", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbLessThan(String value) {
            addCriterion("subjectOptionB <", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbLessThanOrEqualTo(String value) {
            addCriterion("subjectOptionB <=", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbLike(String value) {
            addCriterion("subjectOptionB like", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbNotLike(String value) {
            addCriterion("subjectOptionB not like", value, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbIn(List<String> values) {
            addCriterion("subjectOptionB in", values, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbNotIn(List<String> values) {
            addCriterion("subjectOptionB not in", values, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbBetween(String value1, String value2) {
            addCriterion("subjectOptionB between", value1, value2, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptionbNotBetween(String value1, String value2) {
            addCriterion("subjectOptionB not between", value1, value2, "subjectoptionb");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncIsNull() {
            addCriterion("subjectOptionC is null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncIsNotNull() {
            addCriterion("subjectOptionC is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncEqualTo(String value) {
            addCriterion("subjectOptionC =", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncNotEqualTo(String value) {
            addCriterion("subjectOptionC <>", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncGreaterThan(String value) {
            addCriterion("subjectOptionC >", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncGreaterThanOrEqualTo(String value) {
            addCriterion("subjectOptionC >=", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncLessThan(String value) {
            addCriterion("subjectOptionC <", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncLessThanOrEqualTo(String value) {
            addCriterion("subjectOptionC <=", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncLike(String value) {
            addCriterion("subjectOptionC like", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncNotLike(String value) {
            addCriterion("subjectOptionC not like", value, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncIn(List<String> values) {
            addCriterion("subjectOptionC in", values, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncNotIn(List<String> values) {
            addCriterion("subjectOptionC not in", values, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncBetween(String value1, String value2) {
            addCriterion("subjectOptionC between", value1, value2, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptioncNotBetween(String value1, String value2) {
            addCriterion("subjectOptionC not between", value1, value2, "subjectoptionc");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondIsNull() {
            addCriterion("subjectOptionD is null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondIsNotNull() {
            addCriterion("subjectOptionD is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondEqualTo(String value) {
            addCriterion("subjectOptionD =", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondNotEqualTo(String value) {
            addCriterion("subjectOptionD <>", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondGreaterThan(String value) {
            addCriterion("subjectOptionD >", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondGreaterThanOrEqualTo(String value) {
            addCriterion("subjectOptionD >=", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondLessThan(String value) {
            addCriterion("subjectOptionD <", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondLessThanOrEqualTo(String value) {
            addCriterion("subjectOptionD <=", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondLike(String value) {
            addCriterion("subjectOptionD like", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondNotLike(String value) {
            addCriterion("subjectOptionD not like", value, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondIn(List<String> values) {
            addCriterion("subjectOptionD in", values, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondNotIn(List<String> values) {
            addCriterion("subjectOptionD not in", values, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondBetween(String value1, String value2) {
            addCriterion("subjectOptionD between", value1, value2, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectoptiondNotBetween(String value1, String value2) {
            addCriterion("subjectOptionD not between", value1, value2, "subjectoptiond");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerIsNull() {
            addCriterion("subjectAnswer is null");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerIsNotNull() {
            addCriterion("subjectAnswer is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerEqualTo(String value) {
            addCriterion("subjectAnswer =", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerNotEqualTo(String value) {
            addCriterion("subjectAnswer <>", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerGreaterThan(String value) {
            addCriterion("subjectAnswer >", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerGreaterThanOrEqualTo(String value) {
            addCriterion("subjectAnswer >=", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerLessThan(String value) {
            addCriterion("subjectAnswer <", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerLessThanOrEqualTo(String value) {
            addCriterion("subjectAnswer <=", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerLike(String value) {
            addCriterion("subjectAnswer like", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerNotLike(String value) {
            addCriterion("subjectAnswer not like", value, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerIn(List<String> values) {
            addCriterion("subjectAnswer in", values, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerNotIn(List<String> values) {
            addCriterion("subjectAnswer not in", values, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerBetween(String value1, String value2) {
            addCriterion("subjectAnswer between", value1, value2, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectanswerNotBetween(String value1, String value2) {
            addCriterion("subjectAnswer not between", value1, value2, "subjectanswer");
            return (Criteria) this;
        }

        public Criteria andSubjectparseIsNull() {
            addCriterion("subjectParse is null");
            return (Criteria) this;
        }

        public Criteria andSubjectparseIsNotNull() {
            addCriterion("subjectParse is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectparseEqualTo(String value) {
            addCriterion("subjectParse =", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseNotEqualTo(String value) {
            addCriterion("subjectParse <>", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseGreaterThan(String value) {
            addCriterion("subjectParse >", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseGreaterThanOrEqualTo(String value) {
            addCriterion("subjectParse >=", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseLessThan(String value) {
            addCriterion("subjectParse <", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseLessThanOrEqualTo(String value) {
            addCriterion("subjectParse <=", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseLike(String value) {
            addCriterion("subjectParse like", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseNotLike(String value) {
            addCriterion("subjectParse not like", value, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseIn(List<String> values) {
            addCriterion("subjectParse in", values, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseNotIn(List<String> values) {
            addCriterion("subjectParse not in", values, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseBetween(String value1, String value2) {
            addCriterion("subjectParse between", value1, value2, "subjectparse");
            return (Criteria) this;
        }

        public Criteria andSubjectparseNotBetween(String value1, String value2) {
            addCriterion("subjectParse not between", value1, value2, "subjectparse");
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