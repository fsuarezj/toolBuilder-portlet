package org.lrc.liferay.toolbuilder.bean.steps;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.ToolSession;
import org.lrc.liferay.toolbuilder.steps.StepDef;
import org.primefaces.context.RequestContext;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class StepDefBacking extends AbstractBaseBean implements Serializable {
	
	private static final long serialVersionUID = 2586034249982870816L;
	@ManagedProperty(name = "toolSession", value = "#{toolSession}")
	private ToolSession toolSession;

	public StepDefBacking() {
		// TODO Auto-generated constructor stub
		sysOutput("New construction of step def bean");
	}
	
	@PreDestroy
	public void destroyBean() {
		sysOutput("ESTÁ DESTRUYENDO LA BEAN de StepDef");
	}
	
	public void setStepDefName(String stepDefName) {
		this.toolSession.getCurrentStepDef().setStepDefName(stepDefName);
	}
	
	public String getStepDefName() {
		return this.toolSession.getCurrentStepDef().getStepDefName();
	}
	
	public long getStepDefDBEId() {
		return this.toolSession.getCurrentStepDef().getStepDefDBEId();
	}
	
	public void saveStepDefConfig() throws SystemException, PortalException {
		this.toolSession.getCurrentStepDef().save();
		this.toolSession.popCurrentStepDef();
		RequestContext.getCurrentInstance().closeDialog(this.toolSession.getCurrentStepDef());
	}
	
	public void cancelStepDefConfig() {
		this.toolSession.popCurrentStepDef();
		sysOutput("Cancelando");
		RequestContext.getCurrentInstance().closeDialog(null);
	}

	public StepDef getCurrentStepDef() {
		sysOutput("El currentStepDef es " + this.toolSession.getCurrentStepDef().getStepDefDBEId());
		return this.toolSession.getCurrentStepDef();
	}
	
	public void setCurrentStepDef(StepDef currentStepDef) {
		this.toolSession.setCurrentStepDef(currentStepDef);
	}

	public ToolSession getToolSession() {
		return toolSession;
	}

	public void setToolSession(ToolSession toolSession) {
		this.toolSession = toolSession;
	}
}
