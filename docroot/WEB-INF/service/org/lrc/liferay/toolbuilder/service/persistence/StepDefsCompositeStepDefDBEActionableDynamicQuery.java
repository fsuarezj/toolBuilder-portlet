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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE;
import org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalServiceUtil;

/**
 * @author Fernando Suárez
 * @generated
 */
public abstract class StepDefsCompositeStepDefDBEActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public StepDefsCompositeStepDefDBEActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(StepDefsCompositeStepDefDBELocalServiceUtil.getService());
		setClass(StepDefsCompositeStepDefDBE.class);

		setClassLoader(org.lrc.liferay.toolbuilder.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.compositeStepDefDBEId");
	}
}