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

package org.lrc.liferay.toolbuilder.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE;
import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBEModel;
import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBESoap;
import org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the StepDefsCompositeStepDefDBE service. Represents a row in the &quot;lrc_tb_StepDefsCompositeStepDefDBE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBEModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StepDefsCompositeStepDefDBEImpl}.
 * </p>
 *
 * @author Fernando Suárez
 * @see StepDefsCompositeStepDefDBEImpl
 * @see org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE
 * @see org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBEModel
 * @generated
 */
@JSON(strict = true)
public class StepDefsCompositeStepDefDBEModelImpl extends BaseModelImpl<StepDefsCompositeStepDefDBE>
	implements StepDefsCompositeStepDefDBEModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a step defs composite step def d b e model instance should use the {@link org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE} interface instead.
	 */
	public static final String TABLE_NAME = "lrc_tb_StepDefsCompositeStepDefDBE";
	public static final Object[][] TABLE_COLUMNS = {
			{ "compositeStepDefDBEId", Types.BIGINT },
			{ "stepDefDBEId", Types.BIGINT },
			{ "stepIndex", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table lrc_tb_StepDefsCompositeStepDefDBE (compositeStepDefDBEId LONG not null,stepDefDBEId LONG not null,stepIndex INTEGER,primary key (compositeStepDefDBEId, stepDefDBEId))";
	public static final String TABLE_SQL_DROP = "drop table lrc_tb_StepDefsCompositeStepDefDBE";
	public static final String ORDER_BY_JPQL = " ORDER BY stepDefsCompositeStepDefDBE.id.compositeStepDefDBEId ASC, stepDefsCompositeStepDefDBE.id.stepDefDBEId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY lrc_tb_StepDefsCompositeStepDefDBE.compositeStepDefDBEId ASC, lrc_tb_StepDefsCompositeStepDefDBE.stepDefDBEId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE"),
			true);
	public static long COMPOSITESTEPDEFDBEID_COLUMN_BITMASK = 1L;
	public static long STEPDEFDBEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static StepDefsCompositeStepDefDBE toModel(
		StepDefsCompositeStepDefDBESoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		StepDefsCompositeStepDefDBE model = new StepDefsCompositeStepDefDBEImpl();

		model.setCompositeStepDefDBEId(soapModel.getCompositeStepDefDBEId());
		model.setStepDefDBEId(soapModel.getStepDefDBEId());
		model.setStepIndex(soapModel.getStepIndex());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<StepDefsCompositeStepDefDBE> toModels(
		StepDefsCompositeStepDefDBESoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<StepDefsCompositeStepDefDBE> models = new ArrayList<StepDefsCompositeStepDefDBE>(soapModels.length);

		for (StepDefsCompositeStepDefDBESoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE"));

	public StepDefsCompositeStepDefDBEModelImpl() {
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
	public Class<?> getModelClass() {
		return StepDefsCompositeStepDefDBE.class;
	}

	@Override
	public String getModelClassName() {
		return StepDefsCompositeStepDefDBE.class.getName();
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

	@JSON
	@Override
	public long getCompositeStepDefDBEId() {
		return _compositeStepDefDBEId;
	}

	@Override
	public void setCompositeStepDefDBEId(long compositeStepDefDBEId) {
		_columnBitmask |= COMPOSITESTEPDEFDBEID_COLUMN_BITMASK;

		if (!_setOriginalCompositeStepDefDBEId) {
			_setOriginalCompositeStepDefDBEId = true;

			_originalCompositeStepDefDBEId = _compositeStepDefDBEId;
		}

		_compositeStepDefDBEId = compositeStepDefDBEId;
	}

	public long getOriginalCompositeStepDefDBEId() {
		return _originalCompositeStepDefDBEId;
	}

	@JSON
	@Override
	public long getStepDefDBEId() {
		return _stepDefDBEId;
	}

	@Override
	public void setStepDefDBEId(long stepDefDBEId) {
		_stepDefDBEId = stepDefDBEId;
	}

	@JSON
	@Override
	public int getStepIndex() {
		return _stepIndex;
	}

	@Override
	public void setStepIndex(int stepIndex) {
		_stepIndex = stepIndex;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public StepDefsCompositeStepDefDBE toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StepDefsCompositeStepDefDBE)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StepDefsCompositeStepDefDBEImpl stepDefsCompositeStepDefDBEImpl = new StepDefsCompositeStepDefDBEImpl();

		stepDefsCompositeStepDefDBEImpl.setCompositeStepDefDBEId(getCompositeStepDefDBEId());
		stepDefsCompositeStepDefDBEImpl.setStepDefDBEId(getStepDefDBEId());
		stepDefsCompositeStepDefDBEImpl.setStepIndex(getStepIndex());

		stepDefsCompositeStepDefDBEImpl.resetOriginalValues();

		return stepDefsCompositeStepDefDBEImpl;
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

		if (!(obj instanceof StepDefsCompositeStepDefDBE)) {
			return false;
		}

		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = (StepDefsCompositeStepDefDBE)obj;

		StepDefsCompositeStepDefDBEPK primaryKey = stepDefsCompositeStepDefDBE.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		StepDefsCompositeStepDefDBEModelImpl stepDefsCompositeStepDefDBEModelImpl =
			this;

		stepDefsCompositeStepDefDBEModelImpl._originalCompositeStepDefDBEId = stepDefsCompositeStepDefDBEModelImpl._compositeStepDefDBEId;

		stepDefsCompositeStepDefDBEModelImpl._setOriginalCompositeStepDefDBEId = false;

		stepDefsCompositeStepDefDBEModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StepDefsCompositeStepDefDBE> toCacheModel() {
		StepDefsCompositeStepDefDBECacheModel stepDefsCompositeStepDefDBECacheModel =
			new StepDefsCompositeStepDefDBECacheModel();

		stepDefsCompositeStepDefDBECacheModel.compositeStepDefDBEId = getCompositeStepDefDBEId();

		stepDefsCompositeStepDefDBECacheModel.stepDefDBEId = getStepDefDBEId();

		stepDefsCompositeStepDefDBECacheModel.stepIndex = getStepIndex();

		return stepDefsCompositeStepDefDBECacheModel;
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

	private static ClassLoader _classLoader = StepDefsCompositeStepDefDBE.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StepDefsCompositeStepDefDBE.class
		};
	private long _compositeStepDefDBEId;
	private long _originalCompositeStepDefDBEId;
	private boolean _setOriginalCompositeStepDefDBEId;
	private long _stepDefDBEId;
	private int _stepIndex;
	private long _columnBitmask;
	private StepDefsCompositeStepDefDBE _escapedModel;
}