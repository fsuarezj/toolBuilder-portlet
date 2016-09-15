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

import org.lrc.liferay.toolbuilder.service.ClpSerializer;
import org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalServiceUtil;
import org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fernando Suárez
 */
public class StepDefsCompositeStepDefDBEClp extends BaseModelImpl<StepDefsCompositeStepDefDBE>
	implements StepDefsCompositeStepDefDBE {
	public StepDefsCompositeStepDefDBEClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StepDefsCompositeStepDefDBE.class;
	}

	@Override
	public String getModelClassName() {
		return StepDefsCompositeStepDefDBE.class.getName();
	}

	@Override
	public StepDefsCompositeStepDefDBEPK getPrimaryKey() {
		return new StepDefsCompositeStepDefDBEPK(_compositeStepDefDBEId,
			_stepDefDBEId);
	}

	@Override
	public void setPrimaryKey(StepDefsCompositeStepDefDBEPK primaryKey) {
		setCompositeStepDefDBEId(primaryKey.compositeStepDefDBEId);
		setStepDefDBEId(primaryKey.stepDefDBEId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StepDefsCompositeStepDefDBEPK(_compositeStepDefDBEId,
			_stepDefDBEId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StepDefsCompositeStepDefDBEPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("compositeStepDefDBEId", getCompositeStepDefDBEId());
		attributes.put("stepDefDBEId", getStepDefDBEId());
		attributes.put("stepIndex", getStepIndex());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long compositeStepDefDBEId = (Long)attributes.get(
				"compositeStepDefDBEId");

		if (compositeStepDefDBEId != null) {
			setCompositeStepDefDBEId(compositeStepDefDBEId);
		}

		Long stepDefDBEId = (Long)attributes.get("stepDefDBEId");

		if (stepDefDBEId != null) {
			setStepDefDBEId(stepDefDBEId);
		}

		Integer stepIndex = (Integer)attributes.get("stepIndex");

		if (stepIndex != null) {
			setStepIndex(stepIndex);
		}
	}

	@Override
	public long getCompositeStepDefDBEId() {
		return _compositeStepDefDBEId;
	}

	@Override
	public void setCompositeStepDefDBEId(long compositeStepDefDBEId) {
		_compositeStepDefDBEId = compositeStepDefDBEId;

		if (_stepDefsCompositeStepDefDBERemoteModel != null) {
			try {
				Class<?> clazz = _stepDefsCompositeStepDefDBERemoteModel.getClass();

				Method method = clazz.getMethod("setCompositeStepDefDBEId",
						long.class);

				method.invoke(_stepDefsCompositeStepDefDBERemoteModel,
					compositeStepDefDBEId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStepDefDBEId() {
		return _stepDefDBEId;
	}

	@Override
	public void setStepDefDBEId(long stepDefDBEId) {
		_stepDefDBEId = stepDefDBEId;

		if (_stepDefsCompositeStepDefDBERemoteModel != null) {
			try {
				Class<?> clazz = _stepDefsCompositeStepDefDBERemoteModel.getClass();

				Method method = clazz.getMethod("setStepDefDBEId", long.class);

				method.invoke(_stepDefsCompositeStepDefDBERemoteModel,
					stepDefDBEId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStepIndex() {
		return _stepIndex;
	}

	@Override
	public void setStepIndex(int stepIndex) {
		_stepIndex = stepIndex;

		if (_stepDefsCompositeStepDefDBERemoteModel != null) {
			try {
				Class<?> clazz = _stepDefsCompositeStepDefDBERemoteModel.getClass();

				Method method = clazz.getMethod("setStepIndex", int.class);

				method.invoke(_stepDefsCompositeStepDefDBERemoteModel, stepIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStepDefsCompositeStepDefDBERemoteModel() {
		return _stepDefsCompositeStepDefDBERemoteModel;
	}

	public void setStepDefsCompositeStepDefDBERemoteModel(
		BaseModel<?> stepDefsCompositeStepDefDBERemoteModel) {
		_stepDefsCompositeStepDefDBERemoteModel = stepDefsCompositeStepDefDBERemoteModel;
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

		Class<?> remoteModelClass = _stepDefsCompositeStepDefDBERemoteModel.getClass();

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

		Object returnValue = method.invoke(_stepDefsCompositeStepDefDBERemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StepDefsCompositeStepDefDBELocalServiceUtil.addStepDefsCompositeStepDefDBE(this);
		}
		else {
			StepDefsCompositeStepDefDBELocalServiceUtil.updateStepDefsCompositeStepDefDBE(this);
		}
	}

	@Override
	public StepDefsCompositeStepDefDBE toEscapedModel() {
		return (StepDefsCompositeStepDefDBE)ProxyUtil.newProxyInstance(StepDefsCompositeStepDefDBE.class.getClassLoader(),
			new Class[] { StepDefsCompositeStepDefDBE.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StepDefsCompositeStepDefDBEClp clone = new StepDefsCompositeStepDefDBEClp();

		clone.setCompositeStepDefDBEId(getCompositeStepDefDBEId());
		clone.setStepDefDBEId(getStepDefDBEId());
		clone.setStepIndex(getStepIndex());

		return clone;
	}

	@Override
	public int compareTo(
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE) {
		StepDefsCompositeStepDefDBEPK primaryKey = stepDefsCompositeStepDefDBE.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StepDefsCompositeStepDefDBEClp)) {
			return false;
		}

		StepDefsCompositeStepDefDBEClp stepDefsCompositeStepDefDBE = (StepDefsCompositeStepDefDBEClp)obj;

		StepDefsCompositeStepDefDBEPK primaryKey = stepDefsCompositeStepDefDBE.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{compositeStepDefDBEId=");
		sb.append(getCompositeStepDefDBEId());
		sb.append(", stepDefDBEId=");
		sb.append(getStepDefDBEId());
		sb.append(", stepIndex=");
		sb.append(getStepIndex());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>compositeStepDefDBEId</column-name><column-value><![CDATA[");
		sb.append(getCompositeStepDefDBEId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepDefDBEId</column-name><column-value><![CDATA[");
		sb.append(getStepDefDBEId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepIndex</column-name><column-value><![CDATA[");
		sb.append(getStepIndex());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _compositeStepDefDBEId;
	private long _stepDefDBEId;
	private int _stepIndex;
	private BaseModel<?> _stepDefsCompositeStepDefDBERemoteModel;
	private Class<?> _clpSerializerClass = org.lrc.liferay.toolbuilder.service.ClpSerializer.class;
}