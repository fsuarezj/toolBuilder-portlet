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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the StepDBE service. Represents a row in the &quot;lrc_tb_StepDBE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.lrc.liferay.toolbuilder.model.impl.StepDBEModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.lrc.liferay.toolbuilder.model.impl.StepDBEImpl}.
 * </p>
 *
 * @author Fernando Suárez
 * @see StepDBE
 * @see org.lrc.liferay.toolbuilder.model.impl.StepDBEImpl
 * @see org.lrc.liferay.toolbuilder.model.impl.StepDBEModelImpl
 * @generated
 */
public interface StepDBEModel extends BaseModel<StepDBE>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a step d b e model instance should use the {@link StepDBE} interface instead.
	 */

	/**
	 * Returns the primary key of this step d b e.
	 *
	 * @return the primary key of this step d b e
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this step d b e.
	 *
	 * @param primaryKey the primary key of this step d b e
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the step d b e ID of this step d b e.
	 *
	 * @return the step d b e ID of this step d b e
	 */
	public long getStepDBEId();

	/**
	 * Sets the step d b e ID of this step d b e.
	 *
	 * @param stepDBEId the step d b e ID of this step d b e
	 */
	public void setStepDBEId(long stepDBEId);

	/**
	 * Returns the group ID of this step d b e.
	 *
	 * @return the group ID of this step d b e
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this step d b e.
	 *
	 * @param groupId the group ID of this step d b e
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this step d b e.
	 *
	 * @return the company ID of this step d b e
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this step d b e.
	 *
	 * @param companyId the company ID of this step d b e
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this step d b e.
	 *
	 * @return the user ID of this step d b e
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this step d b e.
	 *
	 * @param userId the user ID of this step d b e
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this step d b e.
	 *
	 * @return the user uuid of this step d b e
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this step d b e.
	 *
	 * @param userUuid the user uuid of this step d b e
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this step d b e.
	 *
	 * @return the user name of this step d b e
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this step d b e.
	 *
	 * @param userName the user name of this step d b e
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this step d b e.
	 *
	 * @return the create date of this step d b e
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this step d b e.
	 *
	 * @param createDate the create date of this step d b e
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this step d b e.
	 *
	 * @return the modified date of this step d b e
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this step d b e.
	 *
	 * @param modifiedDate the modified date of this step d b e
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the step type of this step d b e.
	 *
	 * @return the step type of this step d b e
	 */
	@AutoEscape
	public String getStepType();

	/**
	 * Sets the step type of this step d b e.
	 *
	 * @param stepType the step type of this step d b e
	 */
	public void setStepType(String stepType);

	/**
	 * Returns the step type ID of this step d b e.
	 *
	 * @return the step type ID of this step d b e
	 */
	public long getStepTypeId();

	/**
	 * Sets the step type ID of this step d b e.
	 *
	 * @param stepTypeId the step type ID of this step d b e
	 */
	public void setStepTypeId(long stepTypeId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(org.lrc.liferay.toolbuilder.model.StepDBE stepDBE);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.lrc.liferay.toolbuilder.model.StepDBE> toCacheModel();

	@Override
	public org.lrc.liferay.toolbuilder.model.StepDBE toEscapedModel();

	@Override
	public org.lrc.liferay.toolbuilder.model.StepDBE toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}