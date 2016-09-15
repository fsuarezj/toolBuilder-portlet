package org.lrc.liferay.toolbuilder.bean.toolDefinition;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.lrc.liferay.toolbuilder.InstalledStepException;
import org.lrc.liferay.toolbuilder.StepFactory;
import org.lrc.liferay.toolbuilder.ToolDef;
import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.FactoryBean;
import org.lrc.liferay.toolbuilder.model.InstalledStep;
import org.lrc.liferay.toolbuilder.steps.StepDef;
import org.lrc.liferay.toolbuilder.steps.composite.CompositeStepDef;
import org.primefaces.event.SelectEvent;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class EditToolDefBacking extends AbstractBaseBean implements Serializable {
	
	private static final long serialVersionUID = 7422248327006221303L;
	private ToolDef toolDef = null;
	private String newToolDefName, oldToolDefName = null;
	private CompositeStepDef compositeStepDef;

	public EditToolDefBacking() {
		// TODO Auto-generated constructor stub
	}
	
	public void setToolDefName(String toolDefName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException, IOException {
		if (this.toolDef != null) {
			System.out.println("Setting toolDefName for an existing toolDef");
			System.out.println("Saving toolDefName as " + toolDefName);
			this.oldToolDefName = this.toolDef.getToolDefName();
			this.toolDef.setToolDefName(toolDefName);
		} else if (toolDefName == null) {
			System.out.println("Entrando para null");
		} else if (!toolDefName.isEmpty()){
			System.out.println("ToolDefName = " + toolDefName);
			try {
				this.toolDef = FactoryBean.getToolDef(toolDefName);
				this.compositeStepDef = this.toolDef.getCompositeStepDef();
			} catch (Exception e) {
				FacesContext fc = FacesContext.getCurrentInstance();
				NavigationHandler nh = fc.getApplication().getNavigationHandler();
				nh.handleNavigation(fc, null, "adminView.xhtml");
			}
		} else {
			System.out.println("Entrando para nombre en blanco");
			FacesContext fc = FacesContext.getCurrentInstance();
			NavigationHandler nh = fc.getApplication().getNavigationHandler();
			nh.handleNavigation(fc, null, "adminView.xhtml");
		}
	}
	
	public String getToolDefName() {
		System.out.println("Tratando de recoger la var toolDefName");
		if (this.toolDef != null) {
			System.out.println("Recogiendo la var toolDefName = " + this.toolDef.getToolDefName());
			return this.toolDef.getToolDefName();
		}
		return null;
	}

	public String getNewToolDefName() {
		System.out.println("Recogiendo la var newToolDefName = " + this.newToolDefName);
		return this.newToolDefName;
	}

	public void setNewToolDefName(String newToolDefName) {
		System.out.println("Poniendo la newToolDefName a " + newToolDefName);
		this.newToolDefName = newToolDefName;
	}
	
	public StepDef getCompositeStepDef() {
		return this.compositeStepDef;
	}
	
	public void onTabChange() {
		
	}
	
	public void createNewToolDef() throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		if (!(FacesContext.getCurrentInstance().isPostback())) {
			if (this.newToolDefName != null) {
				System.out.println("Crea la nueva toolDef " + this.newToolDefName);
				this.toolDef = new ToolDef(this.newToolDefName);	
				this.compositeStepDef = this.toolDef.getCompositeStepDef();
				FactoryBean.putToolDef(this.toolDef.getToolDefName(), this.toolDef);
				this.newToolDefName = null;
			}
		}
	}

	public void createNewStepDef(SelectEvent event) throws NoSuchUserException, InstalledStepException, SystemException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		System.out.println("Ejecutando listener lanzado con el evento dialogReturn");
		String stepType = ((InstalledStep) event.getObject()).getStepType();
		this.compositeStepDef.addStepDef(StepFactory.getStepDef(stepType));
	}

	public String saveToolDef() throws SystemException, PortalException {
		this.toolDef.save(); 
		if (this.oldToolDefName != null) {
			FactoryBean.removeToolDef(this.oldToolDefName);
			FactoryBean.putToolDef(this.toolDef.getToolDefName(), this.toolDef);
			System.out.println("Salvando cambio de nombre de " + this.oldToolDefName + " a " + this.toolDef.getToolDefName());
			this.oldToolDefName = null;
		}
		System.out.println("Salvada " + this.toolDef.getToolDefName());
		return "adminView.xhtml";
	}
	
}
