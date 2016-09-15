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

package org.lrc.liferay.toolbuilder.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Fernando Suárez
 * @generated
 */
public class StepDefsCompositeStepDefDBEPK implements Comparable<StepDefsCompositeStepDefDBEPK>,
	Serializable {
	public long compositeStepDefDBEId;
	public long stepDefDBEId;

	public StepDefsCompositeStepDefDBEPK() {
	}

	public StepDefsCompositeStepDefDBEPK(long compositeStepDefDBEId,
		long stepDefDBEId) {
		this.compositeStepDefDBEId = compositeStepDefDBEId;
		this.stepDefDBEId = stepDefDBEId;
	}

	public long getCompositeStepDefDBEId() {
		return compositeStepDefDBEId;
	}

	public void setCompositeStepDefDBEId(long compositeStepDefDBEId) {
		this.compositeStepDefDBEId = compositeStepDefDBEId;
	}

	public long getStepDefDBEId() {
		return stepDefDBEId;
	}

	public void setStepDefDBEId(long stepDefDBEId) {
		this.stepDefDBEId = stepDefDBEId;
	}

	@Override
	public int compareTo(StepDefsCompositeStepDefDBEPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (compositeStepDefDBEId < pk.compositeStepDefDBEId) {
			value = -1;
		}
		else if (compositeStepDefDBEId > pk.compositeStepDefDBEId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (stepDefDBEId < pk.stepDefDBEId) {
			value = -1;
		}
		else if (stepDefDBEId > pk.stepDefDBEId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StepDefsCompositeStepDefDBEPK)) {
			return false;
		}

		StepDefsCompositeStepDefDBEPK pk = (StepDefsCompositeStepDefDBEPK)obj;

		if ((compositeStepDefDBEId == pk.compositeStepDefDBEId) &&
				(stepDefDBEId == pk.stepDefDBEId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(compositeStepDefDBEId) +
		String.valueOf(stepDefDBEId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("compositeStepDefDBEId");
		sb.append(StringPool.EQUAL);
		sb.append(compositeStepDefDBEId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stepDefDBEId");
		sb.append(StringPool.EQUAL);
		sb.append(stepDefDBEId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}