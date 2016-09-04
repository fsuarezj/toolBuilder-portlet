/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package org.lrc.liferay.toolbuilder;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Fernando Suárez
 */
public class StepDBEException extends PortalException {

	public StepDBEException() {
		super();
	}

	public StepDBEException(String msg) {
		super(msg);
	}

	public StepDBEException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StepDBEException(Throwable cause) {
		super(cause);
	}

}