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

package org.lrc.liferay.toolbuilder.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import org.lrc.liferay.toolbuilder.model.ToolDefDBE;
import org.lrc.liferay.toolbuilder.service.ToolDefDBELocalService;
import org.lrc.liferay.toolbuilder.service.persistence.CompositeStepDBEPersistence;
import org.lrc.liferay.toolbuilder.service.persistence.CompositeStepDefDBEPersistence;
import org.lrc.liferay.toolbuilder.service.persistence.InstalledStepPersistence;
import org.lrc.liferay.toolbuilder.service.persistence.StepDBEPersistence;
import org.lrc.liferay.toolbuilder.service.persistence.StepDefDBEPersistence;
import org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPersistence;
import org.lrc.liferay.toolbuilder.service.persistence.ToolDefDBEPersistence;
import org.lrc.liferay.toolbuilder.service.persistence.ToolInstanceDBEPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the tool def d b e local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.lrc.liferay.toolbuilder.service.impl.ToolDefDBELocalServiceImpl}.
 * </p>
 *
 * @author Fernando Suárez
 * @see org.lrc.liferay.toolbuilder.service.impl.ToolDefDBELocalServiceImpl
 * @see org.lrc.liferay.toolbuilder.service.ToolDefDBELocalServiceUtil
 * @generated
 */
public abstract class ToolDefDBELocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ToolDefDBELocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.lrc.liferay.toolbuilder.service.ToolDefDBELocalServiceUtil} to access the tool def d b e local service.
	 */

	/**
	 * Adds the tool def d b e to the database. Also notifies the appropriate model listeners.
	 *
	 * @param toolDefDBE the tool def d b e
	 * @return the tool def d b e that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ToolDefDBE addToolDefDBE(ToolDefDBE toolDefDBE)
		throws SystemException {
		toolDefDBE.setNew(true);

		return toolDefDBEPersistence.update(toolDefDBE);
	}

	/**
	 * Creates a new tool def d b e with the primary key. Does not add the tool def d b e to the database.
	 *
	 * @param toolDefDBEId the primary key for the new tool def d b e
	 * @return the new tool def d b e
	 */
	@Override
	public ToolDefDBE createToolDefDBE(long toolDefDBEId) {
		return toolDefDBEPersistence.create(toolDefDBEId);
	}

	/**
	 * Deletes the tool def d b e with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param toolDefDBEId the primary key of the tool def d b e
	 * @return the tool def d b e that was removed
	 * @throws PortalException if a tool def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ToolDefDBE deleteToolDefDBE(long toolDefDBEId)
		throws PortalException, SystemException {
		return toolDefDBEPersistence.remove(toolDefDBEId);
	}

	/**
	 * Deletes the tool def d b e from the database. Also notifies the appropriate model listeners.
	 *
	 * @param toolDefDBE the tool def d b e
	 * @return the tool def d b e that was removed
	 * @throws PortalException
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ToolDefDBE deleteToolDefDBE(ToolDefDBE toolDefDBE)
		throws PortalException, SystemException {
		return toolDefDBEPersistence.remove(toolDefDBE);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ToolDefDBE.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return toolDefDBEPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.ToolDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return toolDefDBEPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.ToolDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return toolDefDBEPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return toolDefDBEPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return toolDefDBEPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ToolDefDBE fetchToolDefDBE(long toolDefDBEId)
		throws SystemException {
		return toolDefDBEPersistence.fetchByPrimaryKey(toolDefDBEId);
	}

	/**
	 * Returns the tool def d b e with the primary key.
	 *
	 * @param toolDefDBEId the primary key of the tool def d b e
	 * @return the tool def d b e
	 * @throws PortalException if a tool def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 * @throws org.lrc.liferay.toolbuilder.NoSuchToolDefDBEException
	 */
	@Override
	public ToolDefDBE getToolDefDBE(long toolDefDBEId)
		throws PortalException, SystemException,
			org.lrc.liferay.toolbuilder.NoSuchToolDefDBEException {
		return toolDefDBEPersistence.findByPrimaryKey(toolDefDBEId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return toolDefDBEPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the tool def d b es.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.ToolDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tool def d b es
	 * @param end the upper bound of the range of tool def d b es (not inclusive)
	 * @return the range of tool def d b es
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ToolDefDBE> getToolDefDBEs(int start, int end)
		throws SystemException {
		return toolDefDBEPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of tool def d b es.
	 *
	 * @return the number of tool def d b es
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getToolDefDBEsCount() throws SystemException {
		return toolDefDBEPersistence.countAll();
	}

	/**
	 * Updates the tool def d b e in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param toolDefDBE the tool def d b e
	 * @return the tool def d b e that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ToolDefDBE updateToolDefDBE(ToolDefDBE toolDefDBE)
		throws SystemException {
		return toolDefDBEPersistence.update(toolDefDBE);
	}

	/**
	 * Returns the composite step d b e local service.
	 *
	 * @return the composite step d b e local service
	 */
	public org.lrc.liferay.toolbuilder.service.CompositeStepDBELocalService getCompositeStepDBELocalService() {
		return compositeStepDBELocalService;
	}

	/**
	 * Sets the composite step d b e local service.
	 *
	 * @param compositeStepDBELocalService the composite step d b e local service
	 */
	public void setCompositeStepDBELocalService(
		org.lrc.liferay.toolbuilder.service.CompositeStepDBELocalService compositeStepDBELocalService) {
		this.compositeStepDBELocalService = compositeStepDBELocalService;
	}

	/**
	 * Returns the composite step d b e remote service.
	 *
	 * @return the composite step d b e remote service
	 */
	public org.lrc.liferay.toolbuilder.service.CompositeStepDBEService getCompositeStepDBEService() {
		return compositeStepDBEService;
	}

	/**
	 * Sets the composite step d b e remote service.
	 *
	 * @param compositeStepDBEService the composite step d b e remote service
	 */
	public void setCompositeStepDBEService(
		org.lrc.liferay.toolbuilder.service.CompositeStepDBEService compositeStepDBEService) {
		this.compositeStepDBEService = compositeStepDBEService;
	}

	/**
	 * Returns the composite step d b e persistence.
	 *
	 * @return the composite step d b e persistence
	 */
	public CompositeStepDBEPersistence getCompositeStepDBEPersistence() {
		return compositeStepDBEPersistence;
	}

	/**
	 * Sets the composite step d b e persistence.
	 *
	 * @param compositeStepDBEPersistence the composite step d b e persistence
	 */
	public void setCompositeStepDBEPersistence(
		CompositeStepDBEPersistence compositeStepDBEPersistence) {
		this.compositeStepDBEPersistence = compositeStepDBEPersistence;
	}

	/**
	 * Returns the composite step def d b e local service.
	 *
	 * @return the composite step def d b e local service
	 */
	public org.lrc.liferay.toolbuilder.service.CompositeStepDefDBELocalService getCompositeStepDefDBELocalService() {
		return compositeStepDefDBELocalService;
	}

	/**
	 * Sets the composite step def d b e local service.
	 *
	 * @param compositeStepDefDBELocalService the composite step def d b e local service
	 */
	public void setCompositeStepDefDBELocalService(
		org.lrc.liferay.toolbuilder.service.CompositeStepDefDBELocalService compositeStepDefDBELocalService) {
		this.compositeStepDefDBELocalService = compositeStepDefDBELocalService;
	}

	/**
	 * Returns the composite step def d b e remote service.
	 *
	 * @return the composite step def d b e remote service
	 */
	public org.lrc.liferay.toolbuilder.service.CompositeStepDefDBEService getCompositeStepDefDBEService() {
		return compositeStepDefDBEService;
	}

	/**
	 * Sets the composite step def d b e remote service.
	 *
	 * @param compositeStepDefDBEService the composite step def d b e remote service
	 */
	public void setCompositeStepDefDBEService(
		org.lrc.liferay.toolbuilder.service.CompositeStepDefDBEService compositeStepDefDBEService) {
		this.compositeStepDefDBEService = compositeStepDefDBEService;
	}

	/**
	 * Returns the composite step def d b e persistence.
	 *
	 * @return the composite step def d b e persistence
	 */
	public CompositeStepDefDBEPersistence getCompositeStepDefDBEPersistence() {
		return compositeStepDefDBEPersistence;
	}

	/**
	 * Sets the composite step def d b e persistence.
	 *
	 * @param compositeStepDefDBEPersistence the composite step def d b e persistence
	 */
	public void setCompositeStepDefDBEPersistence(
		CompositeStepDefDBEPersistence compositeStepDefDBEPersistence) {
		this.compositeStepDefDBEPersistence = compositeStepDefDBEPersistence;
	}

	/**
	 * Returns the installed step local service.
	 *
	 * @return the installed step local service
	 */
	public org.lrc.liferay.toolbuilder.service.InstalledStepLocalService getInstalledStepLocalService() {
		return installedStepLocalService;
	}

	/**
	 * Sets the installed step local service.
	 *
	 * @param installedStepLocalService the installed step local service
	 */
	public void setInstalledStepLocalService(
		org.lrc.liferay.toolbuilder.service.InstalledStepLocalService installedStepLocalService) {
		this.installedStepLocalService = installedStepLocalService;
	}

	/**
	 * Returns the installed step remote service.
	 *
	 * @return the installed step remote service
	 */
	public org.lrc.liferay.toolbuilder.service.InstalledStepService getInstalledStepService() {
		return installedStepService;
	}

	/**
	 * Sets the installed step remote service.
	 *
	 * @param installedStepService the installed step remote service
	 */
	public void setInstalledStepService(
		org.lrc.liferay.toolbuilder.service.InstalledStepService installedStepService) {
		this.installedStepService = installedStepService;
	}

	/**
	 * Returns the installed step persistence.
	 *
	 * @return the installed step persistence
	 */
	public InstalledStepPersistence getInstalledStepPersistence() {
		return installedStepPersistence;
	}

	/**
	 * Sets the installed step persistence.
	 *
	 * @param installedStepPersistence the installed step persistence
	 */
	public void setInstalledStepPersistence(
		InstalledStepPersistence installedStepPersistence) {
		this.installedStepPersistence = installedStepPersistence;
	}

	/**
	 * Returns the step d b e local service.
	 *
	 * @return the step d b e local service
	 */
	public org.lrc.liferay.toolbuilder.service.StepDBELocalService getStepDBELocalService() {
		return stepDBELocalService;
	}

	/**
	 * Sets the step d b e local service.
	 *
	 * @param stepDBELocalService the step d b e local service
	 */
	public void setStepDBELocalService(
		org.lrc.liferay.toolbuilder.service.StepDBELocalService stepDBELocalService) {
		this.stepDBELocalService = stepDBELocalService;
	}

	/**
	 * Returns the step d b e remote service.
	 *
	 * @return the step d b e remote service
	 */
	public org.lrc.liferay.toolbuilder.service.StepDBEService getStepDBEService() {
		return stepDBEService;
	}

	/**
	 * Sets the step d b e remote service.
	 *
	 * @param stepDBEService the step d b e remote service
	 */
	public void setStepDBEService(
		org.lrc.liferay.toolbuilder.service.StepDBEService stepDBEService) {
		this.stepDBEService = stepDBEService;
	}

	/**
	 * Returns the step d b e persistence.
	 *
	 * @return the step d b e persistence
	 */
	public StepDBEPersistence getStepDBEPersistence() {
		return stepDBEPersistence;
	}

	/**
	 * Sets the step d b e persistence.
	 *
	 * @param stepDBEPersistence the step d b e persistence
	 */
	public void setStepDBEPersistence(StepDBEPersistence stepDBEPersistence) {
		this.stepDBEPersistence = stepDBEPersistence;
	}

	/**
	 * Returns the Step Definition local service.
	 *
	 * @return the Step Definition local service
	 */
	public org.lrc.liferay.toolbuilder.service.StepDefDBELocalService getStepDefDBELocalService() {
		return stepDefDBELocalService;
	}

	/**
	 * Sets the Step Definition local service.
	 *
	 * @param stepDefDBELocalService the Step Definition local service
	 */
	public void setStepDefDBELocalService(
		org.lrc.liferay.toolbuilder.service.StepDefDBELocalService stepDefDBELocalService) {
		this.stepDefDBELocalService = stepDefDBELocalService;
	}

	/**
	 * Returns the Step Definition remote service.
	 *
	 * @return the Step Definition remote service
	 */
	public org.lrc.liferay.toolbuilder.service.StepDefDBEService getStepDefDBEService() {
		return stepDefDBEService;
	}

	/**
	 * Sets the Step Definition remote service.
	 *
	 * @param stepDefDBEService the Step Definition remote service
	 */
	public void setStepDefDBEService(
		org.lrc.liferay.toolbuilder.service.StepDefDBEService stepDefDBEService) {
		this.stepDefDBEService = stepDefDBEService;
	}

	/**
	 * Returns the Step Definition persistence.
	 *
	 * @return the Step Definition persistence
	 */
	public StepDefDBEPersistence getStepDefDBEPersistence() {
		return stepDefDBEPersistence;
	}

	/**
	 * Sets the Step Definition persistence.
	 *
	 * @param stepDefDBEPersistence the Step Definition persistence
	 */
	public void setStepDefDBEPersistence(
		StepDefDBEPersistence stepDefDBEPersistence) {
		this.stepDefDBEPersistence = stepDefDBEPersistence;
	}

	/**
	 * Returns the step defs composite step def d b e local service.
	 *
	 * @return the step defs composite step def d b e local service
	 */
	public org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalService getStepDefsCompositeStepDefDBELocalService() {
		return stepDefsCompositeStepDefDBELocalService;
	}

	/**
	 * Sets the step defs composite step def d b e local service.
	 *
	 * @param stepDefsCompositeStepDefDBELocalService the step defs composite step def d b e local service
	 */
	public void setStepDefsCompositeStepDefDBELocalService(
		org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalService stepDefsCompositeStepDefDBELocalService) {
		this.stepDefsCompositeStepDefDBELocalService = stepDefsCompositeStepDefDBELocalService;
	}

	/**
	 * Returns the step defs composite step def d b e remote service.
	 *
	 * @return the step defs composite step def d b e remote service
	 */
	public org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBEService getStepDefsCompositeStepDefDBEService() {
		return stepDefsCompositeStepDefDBEService;
	}

	/**
	 * Sets the step defs composite step def d b e remote service.
	 *
	 * @param stepDefsCompositeStepDefDBEService the step defs composite step def d b e remote service
	 */
	public void setStepDefsCompositeStepDefDBEService(
		org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBEService stepDefsCompositeStepDefDBEService) {
		this.stepDefsCompositeStepDefDBEService = stepDefsCompositeStepDefDBEService;
	}

	/**
	 * Returns the step defs composite step def d b e persistence.
	 *
	 * @return the step defs composite step def d b e persistence
	 */
	public StepDefsCompositeStepDefDBEPersistence getStepDefsCompositeStepDefDBEPersistence() {
		return stepDefsCompositeStepDefDBEPersistence;
	}

	/**
	 * Sets the step defs composite step def d b e persistence.
	 *
	 * @param stepDefsCompositeStepDefDBEPersistence the step defs composite step def d b e persistence
	 */
	public void setStepDefsCompositeStepDefDBEPersistence(
		StepDefsCompositeStepDefDBEPersistence stepDefsCompositeStepDefDBEPersistence) {
		this.stepDefsCompositeStepDefDBEPersistence = stepDefsCompositeStepDefDBEPersistence;
	}

	/**
	 * Returns the tool def d b e local service.
	 *
	 * @return the tool def d b e local service
	 */
	public org.lrc.liferay.toolbuilder.service.ToolDefDBELocalService getToolDefDBELocalService() {
		return toolDefDBELocalService;
	}

	/**
	 * Sets the tool def d b e local service.
	 *
	 * @param toolDefDBELocalService the tool def d b e local service
	 */
	public void setToolDefDBELocalService(
		org.lrc.liferay.toolbuilder.service.ToolDefDBELocalService toolDefDBELocalService) {
		this.toolDefDBELocalService = toolDefDBELocalService;
	}

	/**
	 * Returns the tool def d b e remote service.
	 *
	 * @return the tool def d b e remote service
	 */
	public org.lrc.liferay.toolbuilder.service.ToolDefDBEService getToolDefDBEService() {
		return toolDefDBEService;
	}

	/**
	 * Sets the tool def d b e remote service.
	 *
	 * @param toolDefDBEService the tool def d b e remote service
	 */
	public void setToolDefDBEService(
		org.lrc.liferay.toolbuilder.service.ToolDefDBEService toolDefDBEService) {
		this.toolDefDBEService = toolDefDBEService;
	}

	/**
	 * Returns the tool def d b e persistence.
	 *
	 * @return the tool def d b e persistence
	 */
	public ToolDefDBEPersistence getToolDefDBEPersistence() {
		return toolDefDBEPersistence;
	}

	/**
	 * Sets the tool def d b e persistence.
	 *
	 * @param toolDefDBEPersistence the tool def d b e persistence
	 */
	public void setToolDefDBEPersistence(
		ToolDefDBEPersistence toolDefDBEPersistence) {
		this.toolDefDBEPersistence = toolDefDBEPersistence;
	}

	/**
	 * Returns the tool instance d b e local service.
	 *
	 * @return the tool instance d b e local service
	 */
	public org.lrc.liferay.toolbuilder.service.ToolInstanceDBELocalService getToolInstanceDBELocalService() {
		return toolInstanceDBELocalService;
	}

	/**
	 * Sets the tool instance d b e local service.
	 *
	 * @param toolInstanceDBELocalService the tool instance d b e local service
	 */
	public void setToolInstanceDBELocalService(
		org.lrc.liferay.toolbuilder.service.ToolInstanceDBELocalService toolInstanceDBELocalService) {
		this.toolInstanceDBELocalService = toolInstanceDBELocalService;
	}

	/**
	 * Returns the tool instance d b e remote service.
	 *
	 * @return the tool instance d b e remote service
	 */
	public org.lrc.liferay.toolbuilder.service.ToolInstanceDBEService getToolInstanceDBEService() {
		return toolInstanceDBEService;
	}

	/**
	 * Sets the tool instance d b e remote service.
	 *
	 * @param toolInstanceDBEService the tool instance d b e remote service
	 */
	public void setToolInstanceDBEService(
		org.lrc.liferay.toolbuilder.service.ToolInstanceDBEService toolInstanceDBEService) {
		this.toolInstanceDBEService = toolInstanceDBEService;
	}

	/**
	 * Returns the tool instance d b e persistence.
	 *
	 * @return the tool instance d b e persistence
	 */
	public ToolInstanceDBEPersistence getToolInstanceDBEPersistence() {
		return toolInstanceDBEPersistence;
	}

	/**
	 * Sets the tool instance d b e persistence.
	 *
	 * @param toolInstanceDBEPersistence the tool instance d b e persistence
	 */
	public void setToolInstanceDBEPersistence(
		ToolInstanceDBEPersistence toolInstanceDBEPersistence) {
		this.toolInstanceDBEPersistence = toolInstanceDBEPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("org.lrc.liferay.toolbuilder.model.ToolDefDBE",
			toolDefDBELocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.lrc.liferay.toolbuilder.model.ToolDefDBE");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return ToolDefDBE.class;
	}

	protected String getModelClassName() {
		return ToolDefDBE.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = toolDefDBEPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.lrc.liferay.toolbuilder.service.CompositeStepDBELocalService.class)
	protected org.lrc.liferay.toolbuilder.service.CompositeStepDBELocalService compositeStepDBELocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.CompositeStepDBEService.class)
	protected org.lrc.liferay.toolbuilder.service.CompositeStepDBEService compositeStepDBEService;
	@BeanReference(type = CompositeStepDBEPersistence.class)
	protected CompositeStepDBEPersistence compositeStepDBEPersistence;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.CompositeStepDefDBELocalService.class)
	protected org.lrc.liferay.toolbuilder.service.CompositeStepDefDBELocalService compositeStepDefDBELocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.CompositeStepDefDBEService.class)
	protected org.lrc.liferay.toolbuilder.service.CompositeStepDefDBEService compositeStepDefDBEService;
	@BeanReference(type = CompositeStepDefDBEPersistence.class)
	protected CompositeStepDefDBEPersistence compositeStepDefDBEPersistence;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.InstalledStepLocalService.class)
	protected org.lrc.liferay.toolbuilder.service.InstalledStepLocalService installedStepLocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.InstalledStepService.class)
	protected org.lrc.liferay.toolbuilder.service.InstalledStepService installedStepService;
	@BeanReference(type = InstalledStepPersistence.class)
	protected InstalledStepPersistence installedStepPersistence;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.StepDBELocalService.class)
	protected org.lrc.liferay.toolbuilder.service.StepDBELocalService stepDBELocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.StepDBEService.class)
	protected org.lrc.liferay.toolbuilder.service.StepDBEService stepDBEService;
	@BeanReference(type = StepDBEPersistence.class)
	protected StepDBEPersistence stepDBEPersistence;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.StepDefDBELocalService.class)
	protected org.lrc.liferay.toolbuilder.service.StepDefDBELocalService stepDefDBELocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.StepDefDBEService.class)
	protected org.lrc.liferay.toolbuilder.service.StepDefDBEService stepDefDBEService;
	@BeanReference(type = StepDefDBEPersistence.class)
	protected StepDefDBEPersistence stepDefDBEPersistence;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalService.class)
	protected org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalService stepDefsCompositeStepDefDBELocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBEService.class)
	protected org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBEService stepDefsCompositeStepDefDBEService;
	@BeanReference(type = StepDefsCompositeStepDefDBEPersistence.class)
	protected StepDefsCompositeStepDefDBEPersistence stepDefsCompositeStepDefDBEPersistence;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.ToolDefDBELocalService.class)
	protected org.lrc.liferay.toolbuilder.service.ToolDefDBELocalService toolDefDBELocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.ToolDefDBEService.class)
	protected org.lrc.liferay.toolbuilder.service.ToolDefDBEService toolDefDBEService;
	@BeanReference(type = ToolDefDBEPersistence.class)
	protected ToolDefDBEPersistence toolDefDBEPersistence;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.ToolInstanceDBELocalService.class)
	protected org.lrc.liferay.toolbuilder.service.ToolInstanceDBELocalService toolInstanceDBELocalService;
	@BeanReference(type = org.lrc.liferay.toolbuilder.service.ToolInstanceDBEService.class)
	protected org.lrc.liferay.toolbuilder.service.ToolInstanceDBEService toolInstanceDBEService;
	@BeanReference(type = ToolInstanceDBEPersistence.class)
	protected ToolInstanceDBEPersistence toolInstanceDBEPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ToolDefDBELocalServiceClpInvoker _clpInvoker = new ToolDefDBELocalServiceClpInvoker();
}