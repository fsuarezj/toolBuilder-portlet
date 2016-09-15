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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException;
import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE;
import org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEImpl;
import org.lrc.liferay.toolbuilder.model.impl.StepDefsCompositeStepDefDBEModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the step defs composite step def d b e service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Fernando Suárez
 * @see StepDefsCompositeStepDefDBEPersistence
 * @see StepDefsCompositeStepDefDBEUtil
 * @generated
 */
public class StepDefsCompositeStepDefDBEPersistenceImpl
	extends BasePersistenceImpl<StepDefsCompositeStepDefDBE>
	implements StepDefsCompositeStepDefDBEPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StepDefsCompositeStepDefDBEUtil} to access the step defs composite step def d b e persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StepDefsCompositeStepDefDBEImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEModelImpl.FINDER_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEModelImpl.FINDER_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPOSITESTEPDEFDBEID =
		new FinderPath(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEModelImpl.FINDER_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompositeStepDefDBEId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPOSITESTEPDEFDBEID =
		new FinderPath(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEModelImpl.FINDER_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompositeStepDefDBEId",
			new String[] { Long.class.getName() },
			StepDefsCompositeStepDefDBEModelImpl.COMPOSITESTEPDEFDBEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPOSITESTEPDEFDBEID = new FinderPath(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompositeStepDefDBEId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the step defs composite step def d b es where compositeStepDefDBEId = &#63;.
	 *
	 * @param compositeStepDefDBEId the composite step def d b e ID
	 * @return the matching step defs composite step def d b es
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepDefsCompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId) throws SystemException {
		return findByCompositeStepDefDBEId(compositeStepDefDBEId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StepDefsCompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId, int start, int end)
		throws SystemException {
		return findByCompositeStepDefDBEId(compositeStepDefDBEId, start, end,
			null);
	}

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
	@Override
	public List<StepDefsCompositeStepDefDBE> findByCompositeStepDefDBEId(
		long compositeStepDefDBEId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPOSITESTEPDEFDBEID;
			finderArgs = new Object[] { compositeStepDefDBEId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPOSITESTEPDEFDBEID;
			finderArgs = new Object[] {
					compositeStepDefDBEId,
					
					start, end, orderByComparator
				};
		}

		List<StepDefsCompositeStepDefDBE> list = (List<StepDefsCompositeStepDefDBE>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE : list) {
				if ((compositeStepDefDBEId != stepDefsCompositeStepDefDBE.getCompositeStepDefDBEId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STEPDEFSCOMPOSITESTEPDEFDBE_WHERE);

			query.append(_FINDER_COLUMN_COMPOSITESTEPDEFDBEID_COMPOSITESTEPDEFDBEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StepDefsCompositeStepDefDBEModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(compositeStepDefDBEId);

				if (!pagination) {
					list = (List<StepDefsCompositeStepDefDBE>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StepDefsCompositeStepDefDBE>(list);
				}
				else {
					list = (List<StepDefsCompositeStepDefDBE>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	 *
	 * @param compositeStepDefDBEId the composite step def d b e ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step defs composite step def d b e
	 * @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a matching step defs composite step def d b e could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE findByCompositeStepDefDBEId_First(
		long compositeStepDefDBEId, OrderByComparator orderByComparator)
		throws NoSuchStepDefsCompositeStepDefDBEException, SystemException {
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = fetchByCompositeStepDefDBEId_First(compositeStepDefDBEId,
				orderByComparator);

		if (stepDefsCompositeStepDefDBE != null) {
			return stepDefsCompositeStepDefDBE;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("compositeStepDefDBEId=");
		msg.append(compositeStepDefDBEId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepDefsCompositeStepDefDBEException(msg.toString());
	}

	/**
	 * Returns the first step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	 *
	 * @param compositeStepDefDBEId the composite step def d b e ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step defs composite step def d b e, or <code>null</code> if a matching step defs composite step def d b e could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE fetchByCompositeStepDefDBEId_First(
		long compositeStepDefDBEId, OrderByComparator orderByComparator)
		throws SystemException {
		List<StepDefsCompositeStepDefDBE> list = findByCompositeStepDefDBEId(compositeStepDefDBEId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	 *
	 * @param compositeStepDefDBEId the composite step def d b e ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step defs composite step def d b e
	 * @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a matching step defs composite step def d b e could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE findByCompositeStepDefDBEId_Last(
		long compositeStepDefDBEId, OrderByComparator orderByComparator)
		throws NoSuchStepDefsCompositeStepDefDBEException, SystemException {
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = fetchByCompositeStepDefDBEId_Last(compositeStepDefDBEId,
				orderByComparator);

		if (stepDefsCompositeStepDefDBE != null) {
			return stepDefsCompositeStepDefDBE;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("compositeStepDefDBEId=");
		msg.append(compositeStepDefDBEId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepDefsCompositeStepDefDBEException(msg.toString());
	}

	/**
	 * Returns the last step defs composite step def d b e in the ordered set where compositeStepDefDBEId = &#63;.
	 *
	 * @param compositeStepDefDBEId the composite step def d b e ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step defs composite step def d b e, or <code>null</code> if a matching step defs composite step def d b e could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE fetchByCompositeStepDefDBEId_Last(
		long compositeStepDefDBEId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompositeStepDefDBEId(compositeStepDefDBEId);

		if (count == 0) {
			return null;
		}

		List<StepDefsCompositeStepDefDBE> list = findByCompositeStepDefDBEId(compositeStepDefDBEId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public StepDefsCompositeStepDefDBE[] findByCompositeStepDefDBEId_PrevAndNext(
		StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK,
		long compositeStepDefDBEId, OrderByComparator orderByComparator)
		throws NoSuchStepDefsCompositeStepDefDBEException, SystemException {
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = findByPrimaryKey(stepDefsCompositeStepDefDBEPK);

		Session session = null;

		try {
			session = openSession();

			StepDefsCompositeStepDefDBE[] array = new StepDefsCompositeStepDefDBEImpl[3];

			array[0] = getByCompositeStepDefDBEId_PrevAndNext(session,
					stepDefsCompositeStepDefDBE, compositeStepDefDBEId,
					orderByComparator, true);

			array[1] = stepDefsCompositeStepDefDBE;

			array[2] = getByCompositeStepDefDBEId_PrevAndNext(session,
					stepDefsCompositeStepDefDBE, compositeStepDefDBEId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StepDefsCompositeStepDefDBE getByCompositeStepDefDBEId_PrevAndNext(
		Session session,
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE,
		long compositeStepDefDBEId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STEPDEFSCOMPOSITESTEPDEFDBE_WHERE);

		query.append(_FINDER_COLUMN_COMPOSITESTEPDEFDBEID_COMPOSITESTEPDEFDBEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StepDefsCompositeStepDefDBEModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(compositeStepDefDBEId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(stepDefsCompositeStepDefDBE);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StepDefsCompositeStepDefDBE> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the step defs composite step def d b es where compositeStepDefDBEId = &#63; from the database.
	 *
	 * @param compositeStepDefDBEId the composite step def d b e ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompositeStepDefDBEId(long compositeStepDefDBEId)
		throws SystemException {
		for (StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE : findByCompositeStepDefDBEId(
				compositeStepDefDBEId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(stepDefsCompositeStepDefDBE);
		}
	}

	/**
	 * Returns the number of step defs composite step def d b es where compositeStepDefDBEId = &#63;.
	 *
	 * @param compositeStepDefDBEId the composite step def d b e ID
	 * @return the number of matching step defs composite step def d b es
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompositeStepDefDBEId(long compositeStepDefDBEId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPOSITESTEPDEFDBEID;

		Object[] finderArgs = new Object[] { compositeStepDefDBEId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STEPDEFSCOMPOSITESTEPDEFDBE_WHERE);

			query.append(_FINDER_COLUMN_COMPOSITESTEPDEFDBEID_COMPOSITESTEPDEFDBEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(compositeStepDefDBEId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPOSITESTEPDEFDBEID_COMPOSITESTEPDEFDBEID_2 =
		"stepDefsCompositeStepDefDBE.id.compositeStepDefDBEId = ?";

	public StepDefsCompositeStepDefDBEPersistenceImpl() {
		setModelClass(StepDefsCompositeStepDefDBE.class);
	}

	/**
	 * Caches the step defs composite step def d b e in the entity cache if it is enabled.
	 *
	 * @param stepDefsCompositeStepDefDBE the step defs composite step def d b e
	 */
	@Override
	public void cacheResult(
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE) {
		EntityCacheUtil.putResult(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEImpl.class,
			stepDefsCompositeStepDefDBE.getPrimaryKey(),
			stepDefsCompositeStepDefDBE);

		stepDefsCompositeStepDefDBE.resetOriginalValues();
	}

	/**
	 * Caches the step defs composite step def d b es in the entity cache if it is enabled.
	 *
	 * @param stepDefsCompositeStepDefDBEs the step defs composite step def d b es
	 */
	@Override
	public void cacheResult(
		List<StepDefsCompositeStepDefDBE> stepDefsCompositeStepDefDBEs) {
		for (StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE : stepDefsCompositeStepDefDBEs) {
			if (EntityCacheUtil.getResult(
						StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
						StepDefsCompositeStepDefDBEImpl.class,
						stepDefsCompositeStepDefDBE.getPrimaryKey()) == null) {
				cacheResult(stepDefsCompositeStepDefDBE);
			}
			else {
				stepDefsCompositeStepDefDBE.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all step defs composite step def d b es.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StepDefsCompositeStepDefDBEImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StepDefsCompositeStepDefDBEImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the step defs composite step def d b e.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE) {
		EntityCacheUtil.removeResult(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEImpl.class,
			stepDefsCompositeStepDefDBE.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StepDefsCompositeStepDefDBE> stepDefsCompositeStepDefDBEs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE : stepDefsCompositeStepDefDBEs) {
			EntityCacheUtil.removeResult(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
				StepDefsCompositeStepDefDBEImpl.class,
				stepDefsCompositeStepDefDBE.getPrimaryKey());
		}
	}

	/**
	 * Creates a new step defs composite step def d b e with the primary key. Does not add the step defs composite step def d b e to the database.
	 *
	 * @param stepDefsCompositeStepDefDBEPK the primary key for the new step defs composite step def d b e
	 * @return the new step defs composite step def d b e
	 */
	@Override
	public StepDefsCompositeStepDefDBE create(
		StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK) {
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = new StepDefsCompositeStepDefDBEImpl();

		stepDefsCompositeStepDefDBE.setNew(true);
		stepDefsCompositeStepDefDBE.setPrimaryKey(stepDefsCompositeStepDefDBEPK);

		return stepDefsCompositeStepDefDBE;
	}

	/**
	 * Removes the step defs composite step def d b e with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	 * @return the step defs composite step def d b e that was removed
	 * @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a step defs composite step def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE remove(
		StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws NoSuchStepDefsCompositeStepDefDBEException, SystemException {
		return remove((Serializable)stepDefsCompositeStepDefDBEPK);
	}

	/**
	 * Removes the step defs composite step def d b e with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the step defs composite step def d b e
	 * @return the step defs composite step def d b e that was removed
	 * @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a step defs composite step def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE remove(Serializable primaryKey)
		throws NoSuchStepDefsCompositeStepDefDBEException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = (StepDefsCompositeStepDefDBE)session.get(StepDefsCompositeStepDefDBEImpl.class,
					primaryKey);

			if (stepDefsCompositeStepDefDBE == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStepDefsCompositeStepDefDBEException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(stepDefsCompositeStepDefDBE);
		}
		catch (NoSuchStepDefsCompositeStepDefDBEException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StepDefsCompositeStepDefDBE removeImpl(
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE)
		throws SystemException {
		stepDefsCompositeStepDefDBE = toUnwrappedModel(stepDefsCompositeStepDefDBE);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stepDefsCompositeStepDefDBE)) {
				stepDefsCompositeStepDefDBE = (StepDefsCompositeStepDefDBE)session.get(StepDefsCompositeStepDefDBEImpl.class,
						stepDefsCompositeStepDefDBE.getPrimaryKeyObj());
			}

			if (stepDefsCompositeStepDefDBE != null) {
				session.delete(stepDefsCompositeStepDefDBE);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (stepDefsCompositeStepDefDBE != null) {
			clearCache(stepDefsCompositeStepDefDBE);
		}

		return stepDefsCompositeStepDefDBE;
	}

	@Override
	public StepDefsCompositeStepDefDBE updateImpl(
		org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE)
		throws SystemException {
		stepDefsCompositeStepDefDBE = toUnwrappedModel(stepDefsCompositeStepDefDBE);

		boolean isNew = stepDefsCompositeStepDefDBE.isNew();

		StepDefsCompositeStepDefDBEModelImpl stepDefsCompositeStepDefDBEModelImpl =
			(StepDefsCompositeStepDefDBEModelImpl)stepDefsCompositeStepDefDBE;

		Session session = null;

		try {
			session = openSession();

			if (stepDefsCompositeStepDefDBE.isNew()) {
				session.save(stepDefsCompositeStepDefDBE);

				stepDefsCompositeStepDefDBE.setNew(false);
			}
			else {
				session.merge(stepDefsCompositeStepDefDBE);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!StepDefsCompositeStepDefDBEModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((stepDefsCompositeStepDefDBEModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPOSITESTEPDEFDBEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stepDefsCompositeStepDefDBEModelImpl.getOriginalCompositeStepDefDBEId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPOSITESTEPDEFDBEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPOSITESTEPDEFDBEID,
					args);

				args = new Object[] {
						stepDefsCompositeStepDefDBEModelImpl.getCompositeStepDefDBEId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPOSITESTEPDEFDBEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPOSITESTEPDEFDBEID,
					args);
			}
		}

		EntityCacheUtil.putResult(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
			StepDefsCompositeStepDefDBEImpl.class,
			stepDefsCompositeStepDefDBE.getPrimaryKey(),
			stepDefsCompositeStepDefDBE);

		return stepDefsCompositeStepDefDBE;
	}

	protected StepDefsCompositeStepDefDBE toUnwrappedModel(
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE) {
		if (stepDefsCompositeStepDefDBE instanceof StepDefsCompositeStepDefDBEImpl) {
			return stepDefsCompositeStepDefDBE;
		}

		StepDefsCompositeStepDefDBEImpl stepDefsCompositeStepDefDBEImpl = new StepDefsCompositeStepDefDBEImpl();

		stepDefsCompositeStepDefDBEImpl.setNew(stepDefsCompositeStepDefDBE.isNew());
		stepDefsCompositeStepDefDBEImpl.setPrimaryKey(stepDefsCompositeStepDefDBE.getPrimaryKey());

		stepDefsCompositeStepDefDBEImpl.setCompositeStepDefDBEId(stepDefsCompositeStepDefDBE.getCompositeStepDefDBEId());
		stepDefsCompositeStepDefDBEImpl.setStepDefDBEId(stepDefsCompositeStepDefDBE.getStepDefDBEId());
		stepDefsCompositeStepDefDBEImpl.setStepIndex(stepDefsCompositeStepDefDBE.getStepIndex());

		return stepDefsCompositeStepDefDBEImpl;
	}

	/**
	 * Returns the step defs composite step def d b e with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the step defs composite step def d b e
	 * @return the step defs composite step def d b e
	 * @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a step defs composite step def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStepDefsCompositeStepDefDBEException, SystemException {
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = fetchByPrimaryKey(primaryKey);

		if (stepDefsCompositeStepDefDBE == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStepDefsCompositeStepDefDBEException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return stepDefsCompositeStepDefDBE;
	}

	/**
	 * Returns the step defs composite step def d b e with the primary key or throws a {@link org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException} if it could not be found.
	 *
	 * @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	 * @return the step defs composite step def d b e
	 * @throws org.lrc.liferay.toolbuilder.NoSuchStepDefsCompositeStepDefDBEException if a step defs composite step def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE findByPrimaryKey(
		StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws NoSuchStepDefsCompositeStepDefDBEException, SystemException {
		return findByPrimaryKey((Serializable)stepDefsCompositeStepDefDBEPK);
	}

	/**
	 * Returns the step defs composite step def d b e with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the step defs composite step def d b e
	 * @return the step defs composite step def d b e, or <code>null</code> if a step defs composite step def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE = (StepDefsCompositeStepDefDBE)EntityCacheUtil.getResult(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
				StepDefsCompositeStepDefDBEImpl.class, primaryKey);

		if (stepDefsCompositeStepDefDBE == _nullStepDefsCompositeStepDefDBE) {
			return null;
		}

		if (stepDefsCompositeStepDefDBE == null) {
			Session session = null;

			try {
				session = openSession();

				stepDefsCompositeStepDefDBE = (StepDefsCompositeStepDefDBE)session.get(StepDefsCompositeStepDefDBEImpl.class,
						primaryKey);

				if (stepDefsCompositeStepDefDBE != null) {
					cacheResult(stepDefsCompositeStepDefDBE);
				}
				else {
					EntityCacheUtil.putResult(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
						StepDefsCompositeStepDefDBEImpl.class, primaryKey,
						_nullStepDefsCompositeStepDefDBE);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StepDefsCompositeStepDefDBEModelImpl.ENTITY_CACHE_ENABLED,
					StepDefsCompositeStepDefDBEImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return stepDefsCompositeStepDefDBE;
	}

	/**
	 * Returns the step defs composite step def d b e with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stepDefsCompositeStepDefDBEPK the primary key of the step defs composite step def d b e
	 * @return the step defs composite step def d b e, or <code>null</code> if a step defs composite step def d b e with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepDefsCompositeStepDefDBE fetchByPrimaryKey(
		StepDefsCompositeStepDefDBEPK stepDefsCompositeStepDefDBEPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stepDefsCompositeStepDefDBEPK);
	}

	/**
	 * Returns all the step defs composite step def d b es.
	 *
	 * @return the step defs composite step def d b es
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepDefsCompositeStepDefDBE> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<StepDefsCompositeStepDefDBE> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StepDefsCompositeStepDefDBE> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<StepDefsCompositeStepDefDBE> list = (List<StepDefsCompositeStepDefDBE>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STEPDEFSCOMPOSITESTEPDEFDBE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STEPDEFSCOMPOSITESTEPDEFDBE;

				if (pagination) {
					sql = sql.concat(StepDefsCompositeStepDefDBEModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StepDefsCompositeStepDefDBE>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StepDefsCompositeStepDefDBE>(list);
				}
				else {
					list = (List<StepDefsCompositeStepDefDBE>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the step defs composite step def d b es from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE : findAll()) {
			remove(stepDefsCompositeStepDefDBE);
		}
	}

	/**
	 * Returns the number of step defs composite step def d b es.
	 *
	 * @return the number of step defs composite step def d b es
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STEPDEFSCOMPOSITESTEPDEFDBE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the step defs composite step def d b e persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StepDefsCompositeStepDefDBE>> listenersList = new ArrayList<ModelListener<StepDefsCompositeStepDefDBE>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StepDefsCompositeStepDefDBE>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StepDefsCompositeStepDefDBEImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STEPDEFSCOMPOSITESTEPDEFDBE = "SELECT stepDefsCompositeStepDefDBE FROM StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE";
	private static final String _SQL_SELECT_STEPDEFSCOMPOSITESTEPDEFDBE_WHERE = "SELECT stepDefsCompositeStepDefDBE FROM StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE WHERE ";
	private static final String _SQL_COUNT_STEPDEFSCOMPOSITESTEPDEFDBE = "SELECT COUNT(stepDefsCompositeStepDefDBE) FROM StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE";
	private static final String _SQL_COUNT_STEPDEFSCOMPOSITESTEPDEFDBE_WHERE = "SELECT COUNT(stepDefsCompositeStepDefDBE) FROM StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "stepDefsCompositeStepDefDBE.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StepDefsCompositeStepDefDBE exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StepDefsCompositeStepDefDBE exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StepDefsCompositeStepDefDBEPersistenceImpl.class);
	private static StepDefsCompositeStepDefDBE _nullStepDefsCompositeStepDefDBE = new StepDefsCompositeStepDefDBEImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StepDefsCompositeStepDefDBE> toCacheModel() {
				return _nullStepDefsCompositeStepDefDBECacheModel;
			}
		};

	private static CacheModel<StepDefsCompositeStepDefDBE> _nullStepDefsCompositeStepDefDBECacheModel =
		new CacheModel<StepDefsCompositeStepDefDBE>() {
			@Override
			public StepDefsCompositeStepDefDBE toEntityModel() {
				return _nullStepDefsCompositeStepDefDBE;
			}
		};
}