package org.lrc.liferay.toolbuilder.bean.steps.mock;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.ToolSession;
import org.lrc.liferay.toolbuilder.steps.mock.MockStepDef;

/**
 * @author Fernando Suárez
 *
 */
@ManagedBean
@RequestScoped
public class MockStepDefBacking extends AbstractBaseBean implements Serializable {
	
	private static final long serialVersionUID = 7240062978786587647L;

	private MockStepDef mockStepDef;
	
	@ManagedProperty(name = "toolSession", value = "#{toolSession}")
	private ToolSession toolSession;

	public MockStepDefBacking() {
	}
	
	@PostConstruct
	public void constructBean() {
		this.mockStepDef = (MockStepDef) this.toolSession.getCurrentStepDef();
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

	public long getStepDefDBEId() {
		return this.mockStepDef.getStepDefDBEId();
	}
	
	public String getStepName() {
		return this.mockStepDef.getStepDefName();
	}
	
}
