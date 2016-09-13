package org.lrc.liferay.toolbuilder.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.lrc.liferay.toolbuilder.CompositeStepDefDBEException;
import org.lrc.liferay.toolbuilder.InstalledStepException;
import org.lrc.liferay.toolbuilder.NoSuchInstalledStepException;
import org.lrc.liferay.toolbuilder.NoSuchToolDefDBEException;
import org.lrc.liferay.toolbuilder.StepDefDBEException;
import org.lrc.liferay.toolbuilder.StepFactory;
import org.lrc.liferay.toolbuilder.ToolDef;
import org.lrc.liferay.toolbuilder.ToolDefDBEException;
import org.lrc.liferay.toolbuilder.model.InstalledStep;
import org.lrc.liferay.toolbuilder.steps.StepDef;
import org.lrc.liferay.toolbuilder.steps.composite.CompositeStepDef;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayWindowState;

@ManagedBean
@ViewScoped
public class ToolDefBacking extends AbstractBaseBean implements Serializable {
	
	private static final long serialVersionUID = 7422248327006221303L;
	@ManagedProperty(name = "factoryBean", value = "#{factoryBean}")
	private FactoryBean factoryBean;
	@ManagedProperty(name = "toolSession", value = "#{toolSession}")
	private ToolSession toolSession;
	private ToolDef toolDef = null;
	private String newToolDefName, oldToolDefName = null;
	private StepDef selectedStepDef, compositeStepDef, newStepDef;
	public ToolDefBacking() {
		// TODO Auto-generated constructor stub
	}

	public String configToolDef() {
		return "toolDefConfig.xhtml";
	}
	
	public String saveToolDef() throws SystemException {
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
	
	public void setToolDefName(String toolDefName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		if (this.toolDef != null) {
			System.out.println("Setting toolDefName for an existing toolDef");
			System.out.println("Saving toolDefName as " + toolDefName);
			this.oldToolDefName = this.toolDef.getToolDefName();
			this.toolDef.setToolDefName(toolDefName);
		} else if (toolDefName == null) {
			System.out.println("Entrando para null");
		} else if (!toolDefName.isEmpty()){
			System.out.println("ToolDefName = " + toolDefName);
			this.toolDef = FactoryBean.getToolDef(toolDefName);
			this.compositeStepDef = this.toolDef.getCompositeStepDef();
		} else {
			System.out.println("Entrando para nombre en blanco");
			this.toolDef = new ToolDef("__tmp_aux_toolDef");
			this.compositeStepDef = this.toolDef.getCompositeStepDef();
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

	public void setToolDef(ToolDef toolDef) {
		this.toolDef = toolDef;
		this.compositeStepDef = this.toolDef.getCompositeStepDef();
	}
	
	public ToolDef getToolDef() {
		return this.toolDef;
	}
	
	public FactoryBean getFactoryBean() {
		return factoryBean;
	}

	public void setFactoryBean(FactoryBean factoryBean) {
		this.factoryBean = factoryBean;
	}

	public ToolSession getToolSession() {
		return toolSession;
	}

	public void setToolSession(ToolSession toolSession) {
		this.toolSession = toolSession;
	}
	
	public StepDef getSelectedStepDef() {
		System.out.println("Sacando el stepDef = " + this.selectedStepDef);
		return this.selectedStepDef;
	}
	
	public void setSelectedStepDef(StepDef selectedStepDef) {
		this.selectedStepDef = selectedStepDef;
	}
	
	public StepDef getCompositeStepDef() {
		return this.compositeStepDef;
	}
	
	public void onTabChange() {
		
	}
	
	public void onTabClose() {
		
	}

	public StepDef getNewStepDef() {
		return newStepDef;
	}

	public void setNewStepDef(StepDef newStepDef) {
		this.newStepDef = newStepDef;
	}
	
	public void chooseStepDef() {
		// To embed just the portlet and not the whole portal in the dialog
		System.out.println("Entrando a elegir StepDef");
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		List<String> paramValue = new ArrayList<String>();
		paramValue.add(LiferayWindowState.POP_UP.toString());
		params.put("p_p_state", paramValue);

		// Dialog options
		Map<String,Object> options = new HashMap<String,Object>();
		options.put("resizable", false);
		options.put("draggable", false);
		options.put("modal", true);
		options.put("header", new String("Choose the type of step to add"));
		options.put("showEffect", "explode");

		// Call to openDialog
		System.out.println("Va a abrir el diálogo");
		RequestContext.getCurrentInstance().openDialog("selectStepDefDialog", options, params);
		RequestContext.getCurrentInstance().update("@all");
	}
	
	public void selectStepDef(InstalledStep stepType) {
		System.out.println("Ejecutando actionListener de salida del dialog");
		RequestContext.getCurrentInstance().closeDialog(stepType);
	}
	
	public void createNewStepDef(SelectEvent event) throws NoSuchUserException, InstalledStepException, SystemException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		System.out.println("Ejecutando listener lanzado con el evento dialogReturn");
		String stepType = ((InstalledStep) event.getObject()).getStepType();
		((CompositeStepDef) this.compositeStepDef).addStepDef(StepFactory.getStepDef(stepType));
	}
	
	public void checkToolDefName(FacesContext context, UIComponent component, Object value) {
		System.out.println("Validating " + (String) value);
		System.out.println("Existing Tool? " + FactoryBean.isExistingToolDef((String) value));
		if (value == null) {
			System.out.println("no hay variable");
			FacesMessage message = new FacesMessage();
			message.setDetail("Void Tool name");
			message.setSummary("Void Tool name");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		if (FactoryBean.isExistingToolDef((String) value)) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Tool Definition called \"" + (String) value + "\" already exists");
			message.setSummary("Existing Tool Def Name");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

	public String getNewToolDefName() {
		System.out.println("Recogiendo la var newToolDefName = " + this.newToolDefName);
		return this.newToolDefName;
	}

	public void setNewToolDefName(String newToolDefName) {
		System.out.println("Poniendo la newToolDefName a " + newToolDefName);
		this.newToolDefName = newToolDefName;
	}
	
	public String callCreateNewToolDef() {
		System.out.println("Va a la pag de admin para crear " + this.newToolDefName);
		return "toolDefConfig?faces-redirect=true&amp;includeViewParams=true&amp;newToolDefName=" + this.newToolDefName;
//http://localhost:8080/group/control_panel/manage?p_p_id=tooldefinition_WAR_toolBuilderportlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&p_p_col_id=&p_p_col_count=0&doAsGroupId=20181&refererPlid=20184&controlPanelCategory=current_site.content&_tooldefinition_WAR_toolBuilderportlet__facesViewIdRender=%2FWEB-INF%2Fviews%2Ftool-definition%2FtoolDefConfig.xhtml&_tooldefinition_WAR_toolBuilderportlet_toolDefName=Test+Tool
//http://localhost:8080/group/control_panel/manage?p_p_id=tooldefinition_WAR_toolBuilderportlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&                            doAsGroupId=20181&refererPlid=20184&controlPanelCategory=current_site.content&_tooldefinition_WAR_toolBuilderportlet__facesViewIdRender=%2FWEB-INF%2Fviews%2Ftool-definition%2FtoolDefConfig.xhtml&_tooldefinition_WAR_toolBuilderportlet_toolDefName=Jereje
	}
	
	public void createNewToolDef() throws NoSuchUserException, NoSuchInstalledStepException, NoSuchToolDefDBEException, ToolDefDBEException, InstalledStepException, StepDefDBEException, CompositeStepDefDBEException, SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Ejecutando el event de preRenderView");
		if (!(FacesContext.getCurrentInstance().isPostback())) {
			System.out.println("No es una llamada post");
			if (this.newToolDefName != null) {
				System.out.println("Crea la nueva toolDef " + this.newToolDefName);
				this.toolDef = new ToolDef(this.newToolDefName);	
				this.compositeStepDef = this.toolDef.getCompositeStepDef();
				this.newToolDefName = null;
			}
		}
	}
}
