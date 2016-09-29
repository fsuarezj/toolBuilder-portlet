package org.lrc.liferay.toolbuilder.steps;

import java.io.Serializable;

import org.lrc.liferay.toolbuilder.CompositeStepDBEException;
import org.lrc.liferay.toolbuilder.NoSuchInstalledStepException;
import org.lrc.liferay.toolbuilder.StepDBEException;
import org.lrc.liferay.toolbuilder.StepDefDBEException;
import org.lrc.liferay.toolbuilder.StepFactory;
import org.lrc.liferay.toolbuilder.model.StepDefDBE;
import org.lrc.liferay.toolbuilder.service.CompositeStepDefDBELocalServiceUtil;
import org.lrc.liferay.toolbuilder.service.StepDefDBELocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public abstract class StepDef implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2179871737463934043L;
	protected StepDefDBE stepDefDBE;
//	private InstalledStep installedStep;
	
	public StepDef(String stepType) throws NoSuchUserException, NoSuchInstalledStepException, StepDefDBEException, SystemException {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
		this.stepDefDBE = StepDefDBELocalServiceUtil.addStepDefDBE(stepType, liferayFacesContext);
		System.out.println("Created Step Def of type " + stepType + " with ID " + this.stepDefDBE.getStepDefDBEId());
	}
	
	public StepDef(StepDefDBE stepDefDBE) {
		this.stepDefDBE = stepDefDBE;
	}
	
	public abstract Step buildStep() throws SystemException, NoSuchUserException, NoSuchInstalledStepException, StepDBEException, StepDefDBEException, CompositeStepDBEException;
	
	public abstract String getAdminView();
	
	public String getAdminCommonView() {
		return "";
	}
	
	public String getStepDefName() {
		return this.stepDefDBE.getName();
	}
	
	public void setStepDefName(String name) {
		this.stepDefDBE.setName(name);
	}
	
	public void save() throws SystemException, PortalException {
		if (this.stepDefDBE.getStepDefDBEId() == 0) {
			StepDefDBELocalServiceUtil.addStepDefDBE(this.stepDefDBE);
		}
		else {
			StepDefDBELocalServiceUtil.updateStepDefDBE(this.stepDefDBE);
		}
	}
	
	public StepDefDBE getStepDefDBE() {
		return this.stepDefDBE;
	}

	public long getStepDefDBEId() {
		return this.stepDefDBE.getStepDefDBEId();
	}
	
	public String getStepType() {
		return this.stepDefDBE.getStepType();
	}
	
	public String getStepDescription() {
		return StepFactory.getStepDescription(this.getStepType());
	}
	
	public void setStepTypeId(long stepTypeId) {
		this.stepDefDBE.setStepTypeId(stepTypeId);
	}
	
	public void removeStepDef() throws PortalException, SystemException {
		StepDefDBELocalServiceUtil.deleteStepDefDBE(this.getStepDefDBEId());
	}

	public void delete() throws PortalException, SystemException {
		StepDefDBELocalServiceUtil.deleteStepDefDBE(this.getStepDefDBEId());
	}
	
//	public String getStepType() {
//		return stepDefDBE.getStepType();
//	}

//	public String getNamespace() {
//		return this.installedStep.getNamespace();
//	}
//	
//	public String getClassName() {
//		return this.installedStep.getClassName();
//	}
}
