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

import com.liferay.portal.service.persistence.BasePersistence;

import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE;

/**
 * The persistence interface for the step defs composite step def d b e service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Fernando Suárez
 * @see StepDefsCompositeStepDefDBEPersistenceImpl
 * @see StepDefsCompositeStepDefDBEUtil
 * @generated
 */
public interface StepDefsCompositeStepDefDBEPersistence extends BasePersistence<StepDefsCompositeStepDefDBE> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StepDefsCompositeStepDefDBEUtil} to access the step defs composite step def d b e persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the step defs composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @return the matching step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the step defs composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param start the lower bound of the range of step defs composite step def d b es
	* @param end the upper bound of the range of step defs composite step def d b es (not inclusive)
	* @return the range of matching step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the step defs composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param start the lower bound of the range of step defs composite step def d b es
	* @param end the upper bound of the range of step defs composite step def d b es (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step defs composite step def d b e
	* @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a matching step defs composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE findByCompositeStepDefDBEId_First(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException;

	/**
	* Returns the first step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step defs composite step def d b e, or <code>null</code> if a matching step defs composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE fetchByCompositeStepDefDBEId_First(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step defs composite step def d b e
	* @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a matching step defs composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE findByCompositeStepDefDBEId_Last(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException;

	/**
	* Returns the last step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step defs composite step def d b e, or <code>null</code> if a matching step defs composite step def d b e could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE fetchByCompositeStepDefDBEId_Last(
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step defs composite step def d b es before and after the current step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key of the current step defs composite step def d b e
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next step defs composite step def d b e
	* @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a step defs composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE[] findByCompositeStepDefDBEId_PrevAndNext(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK,
		long compositeStepDefDBEId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException;

	/**
	* Removes all the step defs composite step def d b es where compositeStepDefDBEId = &#63; from the database.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompositeStepDefDBEId(long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of step defs composite step def d b es where compositeStepDefDBEId = &#63;.
	*
	* @param compositeStepDefDBEId the composite step def d b e ID
	* @return the number of matching step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompositeStepDefDBEId(long compositeStepDefDBEId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the step defs composite step def d b e in the entity cache if it is enabled.
	*
	* @param stepDefsCompositeStepDefDBE the step defs composite step def d b e
	*/
	public void cacheResult(
		org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE);

	/**
	* Caches the step defs composite step def d b es in the entity cache if it is enabled.
	*
	* @param stepDefsCompositeStepDefDBEs the step defs composite step def d b es
	*/
	public void cacheResult(
		java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> stepDefsCompositeStepDefDBEs);

	/**
	* Creates a new step defs composite step def d b e with the primary key. Does not add the step defs composite step def d b e to the database.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key for the new step defs composite step def d b e
	* @return the new step defs composite step def d b e
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE create(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK);

	/**
	* Removes the step defs composite step def d b e with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	* @return the step defs composite step def d b e that was removed
	* @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a step defs composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE remove(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException;

	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE updateImpl(
		org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step defs composite step def d b e with the primary key or throws a {@link org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException} if it could not be found.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	* @return the step defs composite step def d b e
	* @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a step defs composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE findByPrimaryKey(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException;

	/**
	* Returns the step defs composite step def d b e with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	* @return the step defs composite step def d b e, or <code>null</code> if a step defs composite step def d b e with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE fetchByPrimaryKey(
		org.lrc.liferay.toolbuilder.service.persistence.StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the step defs composite step def d b es.
	*
	* @return the step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the step defs composite step def d b es.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of step defs composite step def d b es
	* @param end the upper bound of the range of step defs composite step def d b es (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the step defs composite step def d b es from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of step defs composite step def d b es.
	*
	* @return the number of step defs composite step def d b es
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}