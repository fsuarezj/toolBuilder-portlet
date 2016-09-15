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

import org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.lrc.liferay.toolbuilder.service.http.StepDefsCompositeStepDefDBEServiceSoap}.
 *
 * @author Fernando Suárez
 * @see org.lrc.liferay.toolbuilder.service.http.StepDefsCompositeStepDefDBEServiceSoap
 * @generated
 */
public class StepDefsCompositeStepDefDBESoap implements Serializable {
	public static StepDefsCompositeStepDefDBESoap toSoapModel(
		StepDefsCompositeStepDefDBE model) {
		StepDefsCompositeStepDefDBESoap soapModel = new StepDefsCompositeStepDefDBESoap();

		soapModel.setCompositeStepDefDBEId(model.getCompositeStepDefDBEId());
		soapModel.setStepDefDBEId(model.getStepDefDBEId());
		soapModel.setStepIndex(model.getStepIndex());

		return soapModel;
	}

	public static StepDefsCompositeStepDefDBESoap[] toSoapModels(
		StepDefsCompositeStepDefDBE[] models) {
		StepDefsCompositeStepDefDBESoap[] soapModels = new StepDefsCompositeStepDefDBESoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StepDefsCompositeStepDefDBESoap[][] toSoapModels(
		StepDefsCompositeStepDefDBE[][] models) {
		StepDefsCompositeStepDefDBESoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StepDefsCompositeStepDefDBESoap[models.length][models[0].length];
		}
		else {
			soapModels = new StepDefsCompositeStepDefDBESoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StepDefsCompositeStepDefDBESoap[] toSoapModels(
		List<StepDefsCompositeStepDefDBE> models) {
		List<StepDefsCompositeStepDefDBESoap> soapModels = new ArrayList<StepDefsCompositeStepDefDBESoap>(models.size());

		for (StepDefsCompositeStepDefDBE model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StepDefsCompositeStepDefDBESoap[soapModels.size()]);
	}

	public StepDefsCompositeStepDefDBESoap() {
	}

	public StepDefsCompositeStepDefDBEPK getPrimaryKey() {
		return new StepDefsCompositeStepDefDBEPK(_compositeStepDefDBEId,
			_stepDefDBEId);
	}

	public void setPrimaryKey(StepDefsCompositeStepDefDBEPK pk) {
		setCompositeStepDefDBEId(pk.compositeStepDefDBEId);
		setStepDefDBEId(pk.stepDefDBEId);
	}

	public long getCompositeStepDefDBEId() {
		return _compositeStepDefDBEId;
	}

	public void setCompositeStepDefDBEId(long compositeStepDefDBEId) {
		_compositeStepDefDBEId = compositeStepDefDBEId;
	}

	public long getStepDefDBEId() {
		return _stepDefDBEId;
	}

	public void setStepDefDBEId(long stepDefDBEId) {
		_stepDefDBEId = stepDefDBEId;
	}

	public int getStepIndex() {
		return _stepIndex;
	}

	public void setStepIndex(int stepIndex) {
		_stepIndex = stepIndex;
	}

	private long _compositeStepDefDBEId;
	private long _stepDefDBEId;
	private int _stepIndex;
}