package org.lrc.liferay.toolbuilder.bean.steps.mock;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.lrc.liferay.toolbuilder.CompositeStepDBEException;
import org.lrc.liferay.toolbuilder.NoSuchInstalledStepException;
import org.lrc.liferay.toolbuilder.StepDBEException;
import org.lrc.liferay.toolbuilder.StepDefDBEException;
import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.ToolSession;
import org.lrc.liferay.toolbuilder.steps.mock.MockStep;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Fernando Suárez
 *
 */
@ManagedBean
@RequestScoped
public class MockStepBacking extends AbstractBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1141313013139174266L;

	private MockStep mockStep;
	
	@ManagedProperty(name = "toolSession", value = "#{toolSession}")
	private ToolSession toolSession;

	public MockStepBacking() {
	}
	
	@PostConstruct
	public void constructBean() throws NoSuchUserException, NoSuchInstalledStepException, StepDBEException, StepDefDBEException, CompositeStepDBEException, SystemException {
		this.mockStep = (MockStep) this.toolSession.getSelectedToolInstance().getCurrentStep();
	}
	
	@PreDestroy
	public void destroyBean() {
	}

	public ToolSession getToolSession() {
		return toolSession;
	}

	public void setToolSession(ToolSession toolSession) {
		this.toolSession = toolSession;
	}

	public long getStepDBEId() {
		return this.mockStep.getStepDBEId();
	}
	
}
