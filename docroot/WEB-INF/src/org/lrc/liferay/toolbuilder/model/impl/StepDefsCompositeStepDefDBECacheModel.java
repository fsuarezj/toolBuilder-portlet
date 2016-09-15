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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StepDefsCompositeStepDefDBE in entity cache.
 *
 * @author Fernando Suárez
 * @see StepDefsCompositeStepDefDBE
 * @generated
 */
public class StepDefsCompositeStepDefDBECacheModel implements CacheModel<StepDefsCompositeStepDefDBE>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{compositeStepDefDBEId=");
		sb.append(compositeStepDefDBEId);
		sb.append(", stepDefDBEId=");
		sb.append(stepDefDBEId);
		sb.append(", stepIndex=");
		sb.append(stepIndex);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StepDefsCompositeStepDefDBE toEntityModel() {
		StepDefsCompositeStepDefDBEImpl stepDefsCompositeStepDefDBEImpl = new StepDefsCompositeStepDefDBEImpl();

		stepDefsCompositeStepDefDBEImpl.setCompositeStepDefDBEId(compositeStepDefDBEId);
		stepDefsCompositeStepDefDBEImpl.setStepDefDBEId(stepDefDBEId);
		stepDefsCompositeStepDefDBEImpl.setStepIndex(stepIndex);

		stepDefsCompositeStepDefDBEImpl.resetOriginalValues();

		return stepDefsCompositeStepDefDBEImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		compositeStepDefDBEId = objectInput.readLong();
		stepDefDBEId = objectInput.readLong();
		stepIndex = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(compositeStepDefDBEId);
		objectOutput.writeLong(stepDefDBEId);
		objectOutput.writeInt(stepIndex);
	}

	public long compositeStepDefDBEId;
	public long stepDefDBEId;
	public int stepIndex;
}