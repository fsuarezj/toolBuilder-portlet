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
 * Provides a wrapper for {@link ToolDefDBELocalService}.
 *
 * @author Fernando Suárez
 * @see ToolDefDBELocalService
 * @generated
 */
public class ToolDefDBELocalServiceWrapper implements ToolDefDBELocalService,
	ServiceWrapper<ToolDefDBELocalService> {
	public ToolDefDBELocalServiceWrapper(
		ToolDefDBELocalService toolDefDBELocalService) {
		_toolDefDBELocalService = toolDefDBELocalService;
	}

	/**
	* Adds the tool def d b e to the database. Also notifies the appropriate model listeners.
	*
	* @param toolDefDBE the tool def d b e
	* @return the tool def d b e that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE addToolDefDBE(
		org.lrc.liferay.toolbuilder.model.ToolDefDBE toolDefDBE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.addToolDefDBE(toolDefDBE);
	}

	/**
	* Creates a new tool def d b e with the primary key. Does not add the tool def d b e to the database.
	*
	* @param toolDefDBEId the primary key for the new tool def d b e
	* @return the new tool def d b e
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE createToolDefDBE(
		long toolDefDBEId) {
		return _toolDefDBELocalService.createToolDefDBE(toolDefDBEId);
	}

	/**
	* Deletes the tool def d b e with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param toolDefDBEId the primary key of the tool def d b e
	* @return the tool def d b e that was removed
	* @throws PortalException if a tool def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE deleteToolDefDBE(
		long toolDefDBEId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.deleteToolDefDBE(toolDefDBEId);
	}

	/**
	* Deletes the tool def d b e from the database. Also notifies the appropriate model listeners.
	*
	* @param toolDefDBE the tool def d b e
	* @return the tool def d b e that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE deleteToolDefDBE(
		org.lrc.liferay.toolbuilder.model.ToolDefDBE toolDefDBE)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.deleteToolDefDBE(toolDefDBE);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _toolDefDBELocalService.dynamicQuery();
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
		return _toolDefDBELocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _toolDefDBELocalService.dynamicQueryCount(dynamicQuery);
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
		return _toolDefDBELocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE fetchToolDefDBE(
		long toolDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.fetchToolDefDBE(toolDefDBEId);
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
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE getToolDefDBE(
		long toolDefDBEId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchToolDefDBEException {
		return _toolDefDBELocalService.getToolDefDBE(toolDefDBEId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.lrc.liferay.toolbuilder.model.ToolDefDBE> getToolDefDBEs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.getToolDefDBEs(start, end);
	}

	/**
	* Returns the number of tool def d b es.
	*
	* @return the number of tool def d b es
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getToolDefDBEsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.getToolDefDBEsCount();
	}

	/**
	* Updates the tool def d b e in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param toolDefDBE the tool def d b e
	* @return the tool def d b e that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE updateToolDefDBE(
		org.lrc.liferay.toolbuilder.model.ToolDefDBE toolDefDBE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolDefDBELocalService.updateToolDefDBE(toolDefDBE);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _toolDefDBELocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_toolDefDBELocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _toolDefDBELocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE getToolDefDBE(
		java.lang.String toolName)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchToolDefDBEException {
		return _toolDefDBELocalService.getToolDefDBE(toolName);
	}

	@Override
	public org.lrc.liferay.toolbuilder.model.ToolDefDBE addToolDefDBE(
		java.lang.String toolName,
		com.liferay.faces.portal.context.LiferayFacesContext liferayFacesContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.ToolDefDBEException {
		return _toolDefDBELocalService.addToolDefDBE(toolName,
			liferayFacesContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ToolDefDBELocalService getWrappedToolDefDBELocalService() {
		return _toolDefDBELocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedToolDefDBELocalService(
		ToolDefDBELocalService toolDefDBELocalService) {
		_toolDefDBELocalService = toolDefDBELocalService;
	}

	@Override
	public ToolDefDBELocalService getWrappedService() {
		return _toolDefDBELocalService;
	}

	@Override
	public void setWrappedService(ToolDefDBELocalService toolDefDBELocalService) {
		_toolDefDBELocalService = toolDefDBELocalService;
	}

	private ToolDefDBELocalService _toolDefDBELocalService;
}