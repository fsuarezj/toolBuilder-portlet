package org.lrc.liferay.toolbuilder.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.lrc.liferay.toolbuilder.ToolDef;
import org.lrc.liferay.toolbuilder.steps.StepDef;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

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
	private String toolDefName;
	private StepDef selectedStepDef, compositeStepDef, newStepDef;

	public ToolDefBacking() {
		// TODO Auto-generated constructor stub
	}

	public String configToolDef() {
		return "toolDefConfig.xhtml";
	}
	
	public String saveToolDef() throws SystemException {
		this.toolDef.save(); 
		FactoryBean.removeToolDef(this.toolDefName);
		FactoryBean.putToolDef(this.toolDef.getToolDefName());
		System.out.println("Salvada");
		return "adminView.xhtml";
	}
	
	public void setToolDefName(String toolDefName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		if (this.toolDef != null) {
			System.out.println("Setting toolDefName with toolDef != null");
			System.out.println("Saving toolDefName as " + this.toolDefName);
			this.toolDef.setToolDefName(toolDefName);
		} else {
			System.out.println("Setting toolDefName with toolDef == null");
			this.toolDef = FactoryBean.getToolDef(toolDefName);
			this.compositeStepDef = this.toolDef.getCompositeStepDef();
		}
	}
	
	public String getToolDefName() {
		if (this.toolDef != null)
			return this.toolDef.getToolDefName();
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
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		List<String> paramValue = new ArrayList<String>();
		paramValue.add(LiferayWindowState.POP_UP.toString());
		params.put("p_p_state", paramValue);
		// Dialog options
		Map<String,Object> options = new HashMap<String,Object>();
		options.put("resizable", false);
		options.put("draggable", false);
		options.put("modal", true);
		System.out.println("Tratando de dibujar el dialogo");
		RequestContext.getCurrentInstance().openDialog("selectStepDefDialog", options, params);
//		RequestContext.getCurrentInstance().openDialog("hola");
		System.out.println("Se supone dibujado");
	}
	
	public void createNewStepDef(SelectEvent event) {
		
	}
}
