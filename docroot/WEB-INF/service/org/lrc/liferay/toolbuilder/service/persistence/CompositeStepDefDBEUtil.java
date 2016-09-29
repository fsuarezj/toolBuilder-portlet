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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE;

import java.util.List;

/**
 * The persistence utility for the composite step def d b e service. This utility wraps {@link CompositeStepDefDBEPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Fernando Suárez
 * @see CompositeStepDefDBEPersistence
 * @see CompositeStepDefDBEPersistenceImpl
 * @generated
 */
public class CompositeStepDefDBEUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CompositeStepDefDBE compositeStepDefDBE) {
		getPersistence().clearCache(compositeStepDefDBE);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CompositeStepDefDBE> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompositeStepDefDBE> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompositeStepDefDBE> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CompositeStepDefDBE update(
		CompositeStepDefDBE compositeStepDefDBE) throws SystemException {
		return getPersistence().update(compositeStepDefDBE);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CompositeStepDefDBE update(
		CompositeStepDefDBE compositeStepDefDBE, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(compositeStepDefDBE, serviceContext);
	}

	/**
	* Returns all the composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @return the matching composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompositeStepDefDBEId(compositeStepDefDBEId);
	}

	/**
	* Returns a range of all the composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.CompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param start the lower bound of the range of composite step def d b es
	* @param end the upper bound of the range of composite step def d b es (not inclusive)
	* @return the range of matching composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompositeStepDefDBEId(compositeStepDefDBEId, start,
			end);
	}

	/**
	* Returns an ordered range of all the composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.CompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param start the lower bound of the range of composite step def d b es
	* @param end the upper bound of the range of composite step def d b es (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompositeStepDefDBEId(compositeStepDefDBEId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching composite step def d b e
	* @throws org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException if a matching composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE findByCompositeStepDefDBEId_First(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException {
		return getPersistence()
				   .findByCompositeStepDefDBEId_First(compositeStepDefDBEId,
			orderByComparator);
	}

	/**
	* Returns the first composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching composite step def d b e, or <code>null</code> if a matching composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE fetchByCompositeStepDefDBEId_First(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompositeStepDefDBEId_First(compositeStepDefDBEId,
			orderByComparator);
	}

	/**
	* Returns the last composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching composite step def d b e
	* @throws org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException if a matching composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE findByCompositeStepDefDBEId_Last(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException {
		return getPersistence()
				   .findByCompositeStepDefDBEId_Last(compositeStepDefDBEId,
			orderByComparator);
	}

	/**
	* Returns the last composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching composite step def d b e, or <code>null</code> if a matching composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE fetchByCompositeStepDefDBEId_Last(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompositeStepDefDBEId_Last(compositeStepDefDBEId,
			orderByComparator);
	}

	/**
	* Removes all the composite step def d b es where compositeStepDefDBEId = &#63; from the database.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompositeStepDefDBEId(long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompositeStepDefDBEId(compositeStepDefDBEId);
	}

	/**
	* Returns the number of composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @return the number of matching composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompositeStepDefDBEId(long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompositeStepDefDBEId(compositeStepDefDBEId);
	}

	/**
	* Caches the composite step def d b e in the entity cache if it is enabled.
	*
	* @param compositeStepDefDBE the composite step def d b e
	*/
	public static void cacheResult(
		org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE compositeStepDefDBE) {
		getPersistence().cacheResult(compositeStepDefDBE);
	}

	/**
	* Caches the composite step def d b es in the entity cache if it is enabled.
	*
	* @param compositeStepDefDBEs the composite step def d b es
	*/
	public static void cacheResult(
		java.util.List<org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE> compositeStepDefDBEs) {
		getPersistence().cacheResult(compositeStepDefDBEs);
	}

	/**
	* Creates a new composite step def d b e with the primary key. Does not add the composite step def d b e to the database.
	*
	* @param compositeStepDefDBEId the primary key for the new composite step def d b e
	* @return the new composite step def d b e
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE create(
		long compositeStepDefDBEId) {
		return getPersistence().create(compositeStepDefDBEId);
	}

	/**
	* Removes the composite step def d b e with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param compositeStepDefDBEId the primary key of the composite step def d b e
	* @return the composite step def d b e that was removed
	* @throws org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException if a composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE remove(
		long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException {
		return getPersistence().remove(compositeStepDefDBEId);
	}

	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE updateImpl(
		org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE compositeStepDefDBE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(compositeStepDefDBE);
	}

	/**
	* Returns the composite step def d b e with the primary key or throws a {@link org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException} if it could not be found.
	*
	* @param compositeStepDefDBEId the primary key of the composite step def d b e
	* @return the composite step def d b e
	* @throws org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException if a composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE findByPrimaryKey(
		long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchCompositeStepDefDBEException {
		return getPersistence().findByPrimaryKey(compositeStepDefDBEId);
	}

	/**
	* Returns the composite step def d b e with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param compositeStepDefDBEId the primary key of the composite step def d b e
	* @return the composite step def d b e, or <code>null</code> if a composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE fetchByPrimaryKey(
		long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(compositeStepDefDBEId);
	}

	/**
	* Returns all the composite step def d b es.
	*
	* @return the composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the composite step def d b es.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.CompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of composite step def d b es
	* @param end the upper bound of the range of composite step def d b es (not inclusive)
	* @return the range of composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the composite step def d b es.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.CompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of composite step def d b es
	* @param end the upper bound of the range of composite step def d b es (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the composite step def d b es from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of composite step def d b es.
	*
	* @return the number of composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CompositeStepDefDBEPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CompositeStepDefDBEPersistence)PortletBeanLocatorUtil.locate(org.lrc.liferay.toolbuilder.service.ClpSerializer.getServletContextName(),
					CompositeStepDefDBEPersistence.class.getName());

			ReferenceRegistry.registerReference(CompositeStepDefDBEUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CompositeStepDefDBEPersistence persistence) {
	}

	private static CompositeStepDefDBEPersistence _persistence;
}