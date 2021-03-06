package cn.boz.domain.ora.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserSysPrivsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public UserSysPrivsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
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

		public Criteria andUsernameIsNull() {
			addCriterion("USERNAME is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("USERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("USERNAME =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("USERNAME <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("USERNAME >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("USERNAME >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("USERNAME <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("USERNAME <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("USERNAME like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("USERNAME not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("USERNAME in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("USERNAME not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("USERNAME between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("USERNAME not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andPrivilegeIsNull() {
			addCriterion("PRIVILEGE is null");
			return (Criteria) this;
		}

		public Criteria andPrivilegeIsNotNull() {
			addCriterion("PRIVILEGE is not null");
			return (Criteria) this;
		}

		public Criteria andPrivilegeEqualTo(String value) {
			addCriterion("PRIVILEGE =", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotEqualTo(String value) {
			addCriterion("PRIVILEGE <>", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeGreaterThan(String value) {
			addCriterion("PRIVILEGE >", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeGreaterThanOrEqualTo(String value) {
			addCriterion("PRIVILEGE >=", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeLessThan(String value) {
			addCriterion("PRIVILEGE <", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeLessThanOrEqualTo(String value) {
			addCriterion("PRIVILEGE <=", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeLike(String value) {
			addCriterion("PRIVILEGE like", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotLike(String value) {
			addCriterion("PRIVILEGE not like", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeIn(List<String> values) {
			addCriterion("PRIVILEGE in", values, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotIn(List<String> values) {
			addCriterion("PRIVILEGE not in", values, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeBetween(String value1, String value2) {
			addCriterion("PRIVILEGE between", value1, value2, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotBetween(String value1, String value2) {
			addCriterion("PRIVILEGE not between", value1, value2, "privilege");
			return (Criteria) this;
		}

		public Criteria andAdminOptionIsNull() {
			addCriterion("ADMIN_OPTION is null");
			return (Criteria) this;
		}

		public Criteria andAdminOptionIsNotNull() {
			addCriterion("ADMIN_OPTION is not null");
			return (Criteria) this;
		}

		public Criteria andAdminOptionEqualTo(String value) {
			addCriterion("ADMIN_OPTION =", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionNotEqualTo(String value) {
			addCriterion("ADMIN_OPTION <>", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionGreaterThan(String value) {
			addCriterion("ADMIN_OPTION >", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionGreaterThanOrEqualTo(String value) {
			addCriterion("ADMIN_OPTION >=", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionLessThan(String value) {
			addCriterion("ADMIN_OPTION <", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionLessThanOrEqualTo(String value) {
			addCriterion("ADMIN_OPTION <=", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionLike(String value) {
			addCriterion("ADMIN_OPTION like", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionNotLike(String value) {
			addCriterion("ADMIN_OPTION not like", value, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionIn(List<String> values) {
			addCriterion("ADMIN_OPTION in", values, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionNotIn(List<String> values) {
			addCriterion("ADMIN_OPTION not in", values, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionBetween(String value1, String value2) {
			addCriterion("ADMIN_OPTION between", value1, value2, "adminOption");
			return (Criteria) this;
		}

		public Criteria andAdminOptionNotBetween(String value1, String value2) {
			addCriterion("ADMIN_OPTION not between", value1, value2, "adminOption");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SYS.USER_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS.USER_SYS_PRIVS
     *
     * @mbg.generated do_not_delete_during_merge Tue Aug 28 10:47:26 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}