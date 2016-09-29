/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.lrc.liferay.toolbuilder.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StepDefDBE}.
 * </p>
 *
 * @author Fernando Suárez
 * @see StepDefDBE
 * @generated
 */
public class StepDefDBEWrapper implements StepDefDBE, ModelWrapper<StepDefDBE> {
	public StepDefDBEWrapper(StepDefDBE stepDefDBE) {
		_stepDefDBE = stepDefDBE;
	}

	@Override
	public Class<?> getModelClass() {
		return StepDefDBE.class;
	}

	@Override
	public String getModelClassName() {
		return StepDefDBE.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stepDefDBEId", getStepDefDBEId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stepType", getStepType());
		attributes.put("stepTypeId", getStepTypeId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stepDefDBEId = (Long)attributes.get("stepDefDBEId");

		if (stepDefDBEId != null) {
			setStepDefDBEId(stepDefDBEId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String stepType = (String)attributes.get("stepType");

		if (stepType != null) {
			setStepType(stepType);
		}

		Long stepTypeId = (Long)attributes.get("stepTypeId");

		if (stepTypeId != null) {
			setStepTypeId(stepTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this Step Definition.
	*
	* @return the primary key of this Step Definition
	*/
	@Override
	public long getPrimaryKey() {
		return _stepDefDBE.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Step Definition.
	*
	* @param primaryKey the primary key of this Step Definition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_stepDefDBE.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the step def d b e ID of this Step Definition.
	*
	* @return the step def d b e ID of this Step Definition
	*/
	@Override
	public long getStepDefDBEId() {
		return _stepDefDBE.getStepDefDBEId();
	}

	/**
	* Sets the step def d b e ID of this Step Definition.
	*
	* @param stepDefDBEId the step def d b e ID of this Step Definition
	*/
	@Override
	public void setStepDefDBEId(long stepDefDBEId) {
		_stepDefDBE.setStepDefDBEId(stepDefDBEId);
	}

	/**
	* Returns the group ID of this Step Definition.
	*
	* @return the group ID of this Step Definition
	*/
	@Override
	public long getGroupId() {
		return _stepDefDBE.getGroupId();
	}

	/**
	* Sets the group ID of this Step Definition.
	*
	* @param groupId the group ID of this Step Definition
	*/
	@Override
	public void setGroupId(long groupId) {
		_stepDefDBE.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this Step Definition.
	*
	* @return the company ID of this Step Definition
	*/
	@Override
	public long getCompanyId() {
		return _stepDefDBE.getCompanyId();
	}

	/**
	* Sets the company ID of this Step Definition.
	*
	* @param companyId the company ID of this Step Definition
	*/
	@Override
	public void setCompanyId(long companyId) {
		_stepDefDBE.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this Step Definition.
	*
	* @return the user ID of this Step Definition
	*/
	@Override
	public long getUserId() {
		return _stepDefDBE.getUserId();
	}

	/**
	* Sets the user ID of this Step Definition.
	*
	* @param userId the user ID of this Step Definition
	*/
	@Override
	public void setUserId(long userId) {
		_stepDefDBE.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Step Definition.
	*
	* @return the user uuid of this Step Definition
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefDBE.getUserUuid();
	}

	/**
	* Sets the user uuid of this Step Definition.
	*
	* @param userUuid the user uuid of this Step Definition
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_stepDefDBE.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this Step Definition.
	*
	* @return the user name of this Step Definition
	*/
	@Override
	public java.lang.String getUserName() {
		return _stepDefDBE.getUserName();
	}

	/**
	* Sets the user name of this Step Definition.
	*
	* @param userName the user name of this Step Definition
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_stepDefDBE.setUserName(userName);
	}

	/**
	* Returns the create date of this Step Definition.
	*
	* @return the create date of this Step Definition
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _stepDefDBE.getCreateDate();
	}

	/**
	* Sets the create date of this Step Definition.
	*
	* @param createDate the create date of this Step Definition
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_stepDefDBE.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Step Definition.
	*
	* @return the modified date of this Step Definition
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _stepDefDBE.getModifiedDate();
	}

	/**
	* Sets the modified date of this Step Definition.
	*
	* @param modifiedDate the modified date of this Step Definition
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_stepDefDBE.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the step type of this Step Definition.
	*
	* @return the step type of this Step Definition
	*/
	@Override
	public java.lang.String getStepType() {
		return _stepDefDBE.getStepType();
	}

	/**
	* Sets the step type of this Step Definition.
	*
	* @param stepType the step type of this Step Definition
	*/
	@Override
	public void setStepType(java.lang.String stepType) {
		_stepDefDBE.setStepType(stepType);
	}

	/**
	* Returns the step type ID of this Step Definition.
	*
	* @return the step type ID of this Step Definition
	*/
	@Override
	public long getStepTypeId() {
		return _stepDefDBE.getStepTypeId();
	}

	/**
	* Sets the step type ID of this Step Definition.
	*
	* @param stepTypeId the step type ID of this Step Definition
	*/
	@Override
	public void setStepTypeId(long stepTypeId) {
		_stepDefDBE.setStepTypeId(stepTypeId);
	}

	/**
	* Returns the name of this Step Definition.
	*
	* @return the name of this Step Definition
	*/
	@Override
	public java.lang.String getName() {
		return _stepDefDBE.getName();
	}

	/**
	* Sets the name of this Step Definition.
	*
	* @param name the name of this Step Definition
	*/
	@Override
	public void setName(java.lang.String name) {
		_stepDefDBE.setName(name);
	}

	/**
	* Returns the description of this Step Definition.
	*
	* @return the description of this Step Definition
	*/
	@Override
	public java.lang.String getDescription() {
		return _stepDefDBE.getDescription();
	}

	/**
	* Sets the description of this Step Definition.
	*
	* @param description the description of this Step Definition
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_stepDefDBE.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _stepDefDBE.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_stepDefDBE.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _stepDefDBE.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_stepDefDBE.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _stepDefDBE.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _stepDefDBE.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_stepDefDBE.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _stepDefDBE.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_stepDefDBE.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_stepDefDBE.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_stepDefDBE.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StepDefDBEWrapper((StepDefDBE)_stepDefDBE.clone());
	}

	@Override
	public int compareTo(
		org.lrc.liferay.toolbuilder.model.StepDefDBE stepDefDBE) {
		return _stepDefDBE.compareTo(stepDefDBE);
	}

	@Override
	public int hashCode() {
		return _stepDefDBE.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.lrc.liferay.toolbuilder.model.StepDefDBE> toCacheModel() {
		return _stepDefDBE.toCacheModel();
	}

	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefDBE toEscapedModel() {
		return new StepDefDBEWrapper(_stepDefDBE.toEscapedModel());
	}

	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefDBE toUnescapedModel() {
		return new StepDefDBEWrapper(_stepDefDBE.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _stepDefDBE.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _stepDefDBE.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_stepDefDBE.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StepDefDBEWrapper)) {
			return false;
		}

		StepDefDBEWrapper stepDefDBEWrapper = (StepDefDBEWrapper)obj;

		if (Validator.equals(_stepDefDBE, stepDefDBEWrapper._stepDefDBE)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StepDefDBE getWrappedStepDefDBE() {
		return _stepDefDBE;
	}

	@Override
	public StepDefDBE getWrappedModel() {
		return _stepDefDBE;
	}

	@Override
	public void resetOriginalValues() {
		_stepDefDBE.resetOriginalValues();
	}

	private StepDefDBE _stepDefDBE;
}