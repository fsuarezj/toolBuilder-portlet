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

package org.lrc.liferay.toolbuilder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StepDefsCompositeStepDefDBELocalService}.
 *
 * @author Fernando Suárez
 * @see StepDefsCompositeStepDefDBELocalService
 * @generated
 */
public class StepDefsCompositeStepDefDBELocalServiceWrapper
	implements StepDefsCompositeStepDefDBELocalService,
		ServiceWrapper<StepDefsCompositeStepDefDBELocalService> {
	public StepDefsCompositeStepDefDBELocalServiceWrapper(
		StepDefsCompositeStepDefDBELocalService stepDefsCompositeStepDefDBELocalService) {
		_stepDefsCompositeStepDefDBELocalService = stepDefsCompositeStepDefDBELocalService;
	}

	/**
	* Adds the step defs composite step def d b e to the database. Also notifies the appropriate model listeners.
	*
	* @param stepDefsCompositeStepDefDBE the step defs composite step def d b e
	* @return the step defs composite step def d b e that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE addStepDefsCompositeStepDefDBE(
		org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.addStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBE);
	}

	/**
	* Creates a new step defs composite step def d b e with the primary key. Does not add the step defs composite step def d b e to the database.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key for the new step defs composite step def d b e
	* @return the new step defs composite step def d b e
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE createStepDefsCompositeStepDefDBE(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK) {
		return _stepDefsCompositeStepDefDBELocalService.createStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBEPK);
	}

	/**
	* Deletes the step defs composite step def d b e with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	* @return the step defs composite step def d b e that was removed
	* @throws PortalException if a step defs composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE deleteStepDefsCompositeStepDefDBE(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.deleteStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBEPK);
	}

	/**
	* Deletes the step defs composite step def d b e from the database. Also notifies the appropriate model listeners.
	*
	* @param stepDefsCompositeStepDefDBE the step defs composite step def d b e
	* @return the step defs composite step def d b e that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE deleteStepDefsCompositeStepDefDBE(
		org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.deleteStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBE);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stepDefsCompositeStepDefDBELocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE fetchStepDefsCompositeStepDefDBE(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.fetchStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBEPK);
	}

	/**
	* Returns the step defs composite step def d b e with the primary key.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	* @return the step defs composite step def d b e
	* @throws PortalException if a step defs composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE getStepDefsCompositeStepDefDBE(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.getStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBEPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the step defs composite step def d b es.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of step defs composite step def d b es
	* @param end the upper bound of the range of step defs composite step def d b es (not inclusive)
	* @return the range of step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> getStepDefsCompositeStepDefDBEs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.getStepDefsCompositeStepDefDBEs(start,
			end);
	}

	/**
	* Returns the number of step defs composite step def d b es.
	*
	* @return the number of step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStepDefsCompositeStepDefDBEsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.getStepDefsCompositeStepDefDBEsCount();
	}

	/**
	* Updates the step defs composite step def d b e in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param stepDefsCompositeStepDefDBE the step defs composite step def d b e
	* @return the step defs composite step def d b e that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE updateStepDefsCompositeStepDefDBE(
		org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.updateStepDefsCompositeStepDefDBE(stepDefsCompositeStepDefDBE);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _stepDefsCompositeStepDefDBELocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_stepDefsCompositeStepDefDBELocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _stepDefsCompositeStepDefDBELocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> getRelationships(
		long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stepDefsCompositeStepDefDBELocalService.getRelationships(compositeStepDefDBEId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StepDefsCompositeStepDefDBELocalService getWrappedStepDefsCompositeStepDefDBELocalService() {
		return _stepDefsCompositeStepDefDBELocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStepDefsCompositeStepDefDBELocalService(
		StepDefsCompositeStepDefDBELocalService stepDefsCompositeStepDefDBELocalService) {
		_stepDefsCompositeStepDefDBELocalService = stepDefsCompositeStepDefDBELocalService;
	}

	@Override
	public StepDefsCompositeStepDefDBELocalService getWrappedService() {
		return _stepDefsCompositeStepDefDBELocalService;
	}

	@Override
	public void setWrappedService(
		StepDefsCompositeStepDefDBELocalService stepDefsCompositeStepDefDBELocalService) {
		_stepDefsCompositeStepDefDBELocalService = stepDefsCompositeStepDefDBELocalService;
	}

	private StepDefsCompositeStepDefDBELocalService _stepDefsCompositeStepDefDBELocalService;
}