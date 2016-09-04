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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.lrc.liferay.toolbuilder.service.ClpSerializer;
import org.lrc.liferay.toolbuilder.service.InstalledStepLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fernando Suárez
 */
public class InstalledStepClp extends BaseModelImpl<InstalledStep>
	implements InstalledStep {
	public InstalledStepClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return InstalledStep.class;
	}

	@Override
	public String getModelClassName() {
		return InstalledStep.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _stepType;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setStepType(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stepType;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stepType", getStepType());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("namespace", getNamespace());
		attributes.put("className", getClassName());
		attributes.put("stepDescription", getStepDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String stepType = (String)attributes.get("stepType");

		if (stepType != null) {
			setStepType(stepType);
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

		String namespace = (String)attributes.get("namespace");

		if (namespace != null) {
			setNamespace(namespace);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String stepDescription = (String)attributes.get("stepDescription");

		if (stepDescription != null) {
			setStepDescription(stepDescription);
		}
	}

	@Override
	public String getStepType() {
		return _stepType;
	}

	@Override
	public void setStepType(String stepType) {
		_stepType = stepType;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setStepType", String.class);

				method.invoke(_installedStepRemoteModel, stepType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_installedStepRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_installedStepRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_installedStepRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_installedStepRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_installedStepRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_installedStepRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNamespace() {
		return _namespace;
	}

	@Override
	public void setNamespace(String namespace) {
		_namespace = namespace;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setNamespace", String.class);

				method.invoke(_installedStepRemoteModel, namespace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_installedStepRemoteModel, className);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStepDescription() {
		return _stepDescription;
	}

	@Override
	public void setStepDescription(String stepDescription) {
		_stepDescription = stepDescription;

		if (_installedStepRemoteModel != null) {
			try {
				Class<?> clazz = _installedStepRemoteModel.getClass();

				Method method = clazz.getMethod("setStepDescription",
						String.class);

				method.invoke(_installedStepRemoteModel, stepDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInstalledStepRemoteModel() {
		return _installedStepRemoteModel;
	}

	public void setInstalledStepRemoteModel(
		BaseModel<?> installedStepRemoteModel) {
		_installedStepRemoteModel = installedStepRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _installedStepRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_installedStepRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InstalledStepLocalServiceUtil.addInstalledStep(this);
		}
		else {
			InstalledStepLocalServiceUtil.updateInstalledStep(this);
		}
	}

	@Override
	public InstalledStep toEscapedModel() {
		return (InstalledStep)ProxyUtil.newProxyInstance(InstalledStep.class.getClassLoader(),
			new Class[] { InstalledStep.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstalledStepClp clone = new InstalledStepClp();

		clone.setStepType(getStepType());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNamespace(getNamespace());
		clone.setClassName(getClassName());
		clone.setStepDescription(getStepDescription());

		return clone;
	}

	@Override
	public int compareTo(InstalledStep installedStep) {
		String primaryKey = installedStep.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InstalledStepClp)) {
			return false;
		}

		InstalledStepClp installedStep = (InstalledStepClp)obj;

		String primaryKey = installedStep.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{stepType=");
		sb.append(getStepType());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", namespace=");
		sb.append(getNamespace());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", stepDescription=");
		sb.append(getStepDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.lrc.liferay.toolbuilder.model.InstalledStep");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stepType</column-name><column-value><![CDATA[");
		sb.append(getStepType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>namespace</column-name><column-value><![CDATA[");
		sb.append(getNamespace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepDescription</column-name><column-value><![CDATA[");
		sb.append(getStepDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _stepType;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _namespace;
	private String _className;
	private String _stepDescription;
	private BaseModel<?> _installedStepRemoteModel;
	private Class<?> _clpSerializerClass = org.lrc.liferay.toolbuilder.service.ClpSerializer.class;
}