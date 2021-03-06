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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE;
import org.lrc.liferay.toolbuilder.model.CompositeStepDefDBEModel;
import org.lrc.liferay.toolbuilder.model.CompositeStepDefDBESoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CompositeStepDefDBE service. Represents a row in the &quot;lrc_tb_CompositeStepDefDBE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.lrc.liferay.toolbuilder.model.CompositeStepDefDBEModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CompositeStepDefDBEImpl}.
 * </p>
 *
 * @author Fernando Suárez
 * @see CompositeStepDefDBEImpl
 * @see org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE
 * @see org.lrc.liferay.toolbuilder.model.CompositeStepDefDBEModel
 * @generated
 */
@JSON(strict = true)
public class CompositeStepDefDBEModelImpl extends BaseModelImpl<CompositeStepDefDBE>
	implements CompositeStepDefDBEModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a composite step def d b e model instance should use the {@link org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE} interface instead.
	 */
	public static final String TABLE_NAME = "lrc_tb_CompositeStepDefDBE";
	public static final Object[][] TABLE_COLUMNS = {
			{ "compositeStepDefDBEId", Types.BIGINT },
			{ "stepsNumber", Types.INTEGER },
			{ "sequential", Types.BOOLEAN },
			{ "depth", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table lrc_tb_CompositeStepDefDBE (compositeStepDefDBEId LONG not null primary key,stepsNumber INTEGER,sequential BOOLEAN,depth INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table lrc_tb_CompositeStepDefDBE";
	public static final String ORDER_BY_JPQL = " ORDER BY compositeStepDefDBE.compositeStepDefDBEId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY lrc_tb_CompositeStepDefDBE.compositeStepDefDBEId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE"),
			true);
	public static long COMPOSITESTEPDEFDBEID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CompositeStepDefDBE toModel(CompositeStepDefDBESoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CompositeStepDefDBE model = new CompositeStepDefDBEImpl();

		model.setCompositeStepDefDBEId(soapModel.getCompositeStepDefDBEId());
		model.setStepsNumber(soapModel.getStepsNumber());
		model.setSequential(soapModel.getSequential());
		model.setDepth(soapModel.getDepth());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CompositeStepDefDBE> toModels(
		CompositeStepDefDBESoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CompositeStepDefDBE> models = new ArrayList<CompositeStepDefDBE>(soapModels.length);

		for (CompositeStepDefDBESoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE"));

	public CompositeStepDefDBEModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _compositeStepDefDBEId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCompositeStepDefDBEId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _compositeStepDefDBEId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CompositeStepDefDBE.class;
	}

	@Override
	public String getModelClassName() {
		return CompositeStepDefDBE.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("compositeStepDefDBEId", getCompositeStepDefDBEId());
		attributes.put("stepsNumber", getStepsNumber());
		attributes.put("sequential", getSequential());
		attributes.put("depth", getDepth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long compositeStepDefDBEId = (Long)attributes.get(
				"compositeStepDefDBEId");

		if (compositeStepDefDBEId != null) {
			setCompositeStepDefDBEId(compositeStepDefDBEId);
		}

		Integer stepsNumber = (Integer)attributes.get("stepsNumber");

		if (stepsNumber != null) {
			setStepsNumber(stepsNumber);
		}

		Boolean sequential = (Boolean)attributes.get("sequential");

		if (sequential != null) {
			setSequential(sequential);
		}

		Integer depth = (Integer)attributes.get("depth");

		if (depth != null) {
			setDepth(depth);
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
	public int getStepsNumber() {
		return _stepsNumber;
	}

	@Override
	public void setStepsNumber(int stepsNumber) {
		_stepsNumber = stepsNumber;
	}

	@JSON
	@Override
	public boolean getSequential() {
		return _sequential;
	}

	@Override
	public boolean isSequential() {
		return _sequential;
	}

	@Override
	public void setSequential(boolean sequential) {
		_sequential = sequential;
	}

	@JSON
	@Override
	public int getDepth() {
		return _depth;
	}

	@Override
	public void setDepth(int depth) {
		_depth = depth;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CompositeStepDefDBE.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CompositeStepDefDBE toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CompositeStepDefDBE)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CompositeStepDefDBEImpl compositeStepDefDBEImpl = new CompositeStepDefDBEImpl();

		compositeStepDefDBEImpl.setCompositeStepDefDBEId(getCompositeStepDefDBEId());
		compositeStepDefDBEImpl.setStepsNumber(getStepsNumber());
		compositeStepDefDBEImpl.setSequential(getSequential());
		compositeStepDefDBEImpl.setDepth(getDepth());

		compositeStepDefDBEImpl.resetOriginalValues();

		return compositeStepDefDBEImpl;
	}

	@Override
	public int compareTo(CompositeStepDefDBE compositeStepDefDBE) {
		long primaryKey = compositeStepDefDBE.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompositeStepDefDBE)) {
			return false;
		}

		CompositeStepDefDBE compositeStepDefDBE = (CompositeStepDefDBE)obj;

		long primaryKey = compositeStepDefDBE.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CompositeStepDefDBEModelImpl compositeStepDefDBEModelImpl = this;

		compositeStepDefDBEModelImpl._originalCompositeStepDefDBEId = compositeStepDefDBEModelImpl._compositeStepDefDBEId;

		compositeStepDefDBEModelImpl._setOriginalCompositeStepDefDBEId = false;

		compositeStepDefDBEModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CompositeStepDefDBE> toCacheModel() {
		CompositeStepDefDBECacheModel compositeStepDefDBECacheModel = new CompositeStepDefDBECacheModel();

		compositeStepDefDBECacheModel.compositeStepDefDBEId = getCompositeStepDefDBEId();

		compositeStepDefDBECacheModel.stepsNumber = getStepsNumber();

		compositeStepDefDBECacheModel.sequential = getSequential();

		compositeStepDefDBECacheModel.depth = getDepth();

		return compositeStepDefDBECacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{compositeStepDefDBEId=");
		sb.append(getCompositeStepDefDBEId());
		sb.append(", stepsNumber=");
		sb.append(getStepsNumber());
		sb.append(", sequential=");
		sb.append(getSequential());
		sb.append(", depth=");
		sb.append(getDepth());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>compositeStepDefDBEId</column-name><column-value><![CDATA[");
		sb.append(getCompositeStepDefDBEId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepsNumber</column-name><column-value><![CDATA[");
		sb.append(getStepsNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequential</column-name><column-value><![CDATA[");
		sb.append(getSequential());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depth</column-name><column-value><![CDATA[");
		sb.append(getDepth());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CompositeStepDefDBE.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CompositeStepDefDBE.class
		};
	private long _compositeStepDefDBEId;
	private long _originalCompositeStepDefDBEId;
	private boolean _setOriginalCompositeStepDefDBEId;
	private int _stepsNumber;
	private boolean _sequential;
	private int _depth;
	private long _columnBitmask;
	private CompositeStepDefDBE _escapedModel;
}