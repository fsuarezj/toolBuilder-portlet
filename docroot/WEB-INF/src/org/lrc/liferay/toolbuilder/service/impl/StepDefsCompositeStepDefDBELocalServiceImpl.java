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

package org.lrc.liferay.toolbuilder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE;
import org.lrc.liferay.toolbuilder.service.base.StepDefsCompositeStepDefDBELocalServiceBaseImpl;
import org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the step defs composite step def d b e local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Fernando Suárez
 * @see org.lrc.liferay.toolbuilder.service.base.StepDefsCompositeStepDefDBELocalServiceBaseImpl
 * @see org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalServiceUtil
 */
public class StepDefsCompositeStepDefDBELocalServiceImpl
	extends StepDefsCompositeStepDefDBELocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalServiceUtil} to access the step defs composite step def d b e local service.
	 */
	
	public List<StepDefsCompositeStepDefDBE> getRelationships(long compositeStepDefDBEId) throws SystemException {
		List<StepDefsCompositeStepDefDBE> auxList = StepDefsCompositeStepDefDBEUtil.findByCompositeStepDefDBEId(compositeStepDefDBEId);
		List<StepDefsCompositeStepDefDBE> result = new ArrayList<StepDefsCompositeStepDefDBE>();
		// Order the relationships entries
		for (StepDefsCompositeStepDefDBE aux: auxList) {
			if (aux.getStepIndex() > result.size()) {
				result.add(aux);
			} else {
				result.add(aux.getStepIndex(), aux);
			}
		}
		return result;
	}
	
	public StepDefsCompositeStepDefDBE updateStepDefsCompositeStepDefDBE(StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE) throws SystemException {
		try {
			super.deleteStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBE.getPrimaryKey());
		} catch (Exception e) {
			
		}
		return super.updateStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBE);
	}
	
}