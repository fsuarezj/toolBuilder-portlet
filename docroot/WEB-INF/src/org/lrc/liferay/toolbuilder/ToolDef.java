package org.lrc.liferay.toolbuilder;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.lrc.liferay.toolbuilder.model.StepDefDBE;
import org.lrc.liferay.toolbuilder.model.ToolDefDBE;
import org.lrc.liferay.toolbuilder.service.StepDefDBELocalServiceUtil;
import org.lrc.liferay.toolbuilder.service.ToolDefDBELocalServiceUtil;
import org.lrc.liferay.toolbuilder.service.persistence.ToolDefDBEUtil;
import org.lrc.liferay.toolbuilder.steps.composite.CompositeStep;
import org.lrc.liferay.toolbuilder.steps.composite.CompositeStepDef;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class ToolDef implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3469229446098569636L;
	private CompositeStepDef compositeStepDef;
	private ToolDefDBE toolDefDBE;
	
	public ToolDef(String toolName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		if (toolName.equals("Test Tool")) {
			this.createToolDef(toolName, "This is the first tool created called \"Test Tool\"");
			this.createMockSteps(5);
			this.save();
		} else if (toolName.equals("Test Tool 2")) {
			this.createToolDef(toolName);
			this.createMockSteps(3);
			this.save();
		} else {
			this.createToolDef(toolName);
			//TODO: Create new exception
//			throw new NoSuchToolDefDBEException();
		}
	}

	public ToolDef(ToolDefDBE toolDefDBE) throws PortalException, SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.toolDefDBE = toolDefDBE;
		StepDefDBE stepDefDBE = StepDefDBELocalServiceUtil.getStepDefDBE(this.toolDefDBE.getCompositeStepDefDBEId());
		this.compositeStepDef = new CompositeStepDef(stepDefDBE);
	}

	private void createToolDef(String name) throws SystemException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, PortalException {
		// TODO Auto-generated constructor stub
		this.toolDefDBE = ToolDefDBEUtil.create(0L);
		
		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
		this.toolDefDBE = ToolDefDBELocalServiceUtil.addToolDefDBE(name, liferayFacesContext);

//		this.compositeStepDef = new CompositeStepDef();
		this.compositeStepDef = (CompositeStepDef) StepFactory.getStepDef("COMPOSITE");

		this.compositeStepDef.save();
		this.toolDefDBE.setCompositeStepDefDBEId(this.compositeStepDef.getStepDefDBEId());
//		ToolDefDBELocalServiceUtil.addToolDefDBE(this.toolDefDBE);
		ToolDefDBELocalServiceUtil.updateToolDefDBE(this.toolDefDBE);
	}
	
	private void createMockSteps(int stepsNumber) throws NoSuchUserException, InstalledStepException, SystemException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for (int i = 0; i < stepsNumber; i++) {
			this.compositeStepDef.addStepDef(StepFactory.getStepDef("MOCK"));
		}
	}
	
	private void createToolDef(String name, String description) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		this.createToolDef(name);
		this.setToolDescription(description);
		this.save();
	}
	
	public long getToolDefDBEId() {
		return this.toolDefDBE.getToolDefDBEId();
	}

	public ToolInstance buildInstance() throws SystemException, NoSuchUserException, NoSuchInstalledStepException, StepDBEException, StepDefDBEException, CompositeStepDBEException, NoSuchToolDefDBEException {
		return new ToolInstance(this, (CompositeStep) this.compositeStepDef.buildStep());
	}

	public void rebuildSteps() throws NoSuchStepDefDBEException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SystemException, PortalException {
		this.compositeStepDef.buildStepDefs();
	}

	public String getToolDefName() {
		// TODO Auto-generated method stub
		return this.toolDefDBE.getToolName();
	}
	
	public String getToolDescription()  {
		return this.toolDefDBE.getToolDescription();
	}
	
	public void save() throws SystemException, PortalException {
		ToolDefDBELocalServiceUtil.updateToolDefDBE(this.toolDefDBE);
		this.compositeStepDef.save();
	}

	public void setToolDefName(String toolDefName) {
		this.toolDefDBE.setToolName(toolDefName);
	}
	
	public void setToolDescription(String toolDescription) {
		this.toolDefDBE.setToolDescription(toolDescription);
	}
	
	public CompositeStepDef getCompositeStepDef() {
		return this.compositeStepDef;
	}
}
