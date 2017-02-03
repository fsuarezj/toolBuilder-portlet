package org.lrc.liferay.toolbuilder.bean.steps.composite;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.WordUtils;
import org.lrc.liferay.toolbuilder.StepFactory;
import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.ToolSession;
import org.lrc.liferay.toolbuilder.model.InstalledStep;
import org.lrc.liferay.toolbuilder.steps.StepDef;
import org.lrc.liferay.toolbuilder.steps.composite.CompositeStepDef;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayWindowState;

@ManagedBean
@ViewScoped
public class CompositeStepDefBacking extends AbstractBaseBean implements Serializable {
	
	private static final long serialVersionUID = 4808125974238826813L;
	private DashboardModel dashboard;
	private CompositeStepDef compositeStepDef;

	@ManagedProperty(name = "toolSession", value = "#{toolSession}")
	private ToolSession toolSession;

	public CompositeStepDefBacking() {
		// TODO Auto-generated constructor stub
		sysOutput("New construction of composite bean");
	}
	
	@PostConstruct
	public void constructBean() {
		this.compositeStepDef = (CompositeStepDef) this.toolSession.getCurrentStepDef();
		// If it is the compositeStepDef related to the toolDef does not yet construct the dashboard
		if (this.compositeStepDef != null)
			this.createDashBoard();
	}
	
	@PreDestroy
	public void destroyBean() {
		sysOutput("ESTÁ DESTRUYENDO LA BEAN de Composite");
	}
	
	public void setCompositeStepDef(CompositeStepDef compositeStepDef) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException, IOException {
		this.setCurrentStepDef(compositeStepDef);
		this.compositeStepDef = compositeStepDef;
		this.createDashBoard();
	}
	
	public void createDashBoard() {
		this.dashboard = new DefaultDashboardModel();
		DashboardColumn column = new DefaultDashboardColumn();
		sysOutput("Va a crear el dashboard para " + this.compositeStepDef.getStepDefDBEId());
		for (int i = 0; i < this.compositeStepDef.getStepsNumber(); i++) {
			sysOutput("Añadiendo Panel_" + i);
			column.addWidget("Panel_" + i);
//			column.addWidget("Panel" + this.compositeStepDef.getStepDef(i).getStepDefDBEId());
		}
		sysOutput("Creando Dashboard");
		((CompositeStepDef) this.getCompositeStepDef()).initStepsOrder();
		dashboard.addColumn(column);
	}
	
	public StepDef getCompositeStepDef() {
		return this.compositeStepDef;
	}

	public void createNewStepDef(SelectEvent event) throws SystemException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, PortalException {
		sysOutput("Ejecutando listener lanzado con el evento dialogReturn");
		String stepType = ((InstalledStep) event.getObject()).getStepType();
		StepDef newStepDef = StepFactory.getStepDef(stepType);
		if (stepType.equals("COMPOSITE"))
			((CompositeStepDef) newStepDef).setDepth(this.compositeStepDef.getDepth() + 1);
		this.compositeStepDef.addStepDef(newStepDef);
		this.compositeStepDef.save();
		this.createDashBoard();
	}

	public DashboardModel getDashboard() {
		sysOutput("Getting Dashboard");
//		this.createDashBoard();
		return this.dashboard;
	}

	public void setDashboard(DashboardModel dashboard) {
		sysOutput("Setting Dashboard");
		this.dashboard = dashboard;
	}
	
	public void configStepDialog(int index) {
		// To embed just the portlet and not the whole portal in the dialog
		sysOutput("Entrando a config Step");
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		List<String> paramValue = new ArrayList<String>();
		paramValue.add(LiferayWindowState.POP_UP.toString());
		params.put("p_p_state", paramValue);

		// Dialog options
		Map<String,Object> options = new HashMap<String,Object>();
		options.put("resizable", false);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("closable", false);
		options.put("header", new String("Cconfiguring Step"));
		options.put("showEffect", "explode");

		this.toolSession.setCurrentStepDef(this.compositeStepDef.getStepDef(index));
		sysOutput("Abriendo el dialogo de conf para " + this.compositeStepDef.getStepDef(index).getStepDefDBEId());
//		if (this.toolSession.getCurrentStepDef().getStepType().equals("COMPOSITE")) {
//			this.compositeStepDef = (CompositeStepDef) this.toolSession.getCurrentStepDef();
//		}
		// Call to openDialog
		sysOutput("Va a abrir el diálogo con currentStep = " + this.toolSession.getCurrentStepDef().getStepDefDBEId());
		RequestContext.getCurrentInstance().openDialog("configStepDefDialog", options, params);
		RequestContext.getCurrentInstance().update("@all");
	}
	
	public void returnFromConfigStep(SelectEvent event) {
		sysOutput("Ejecutando listener tras volver de config Step");
//		String stepType = ((InstalledStep) event.getObject()).getStepType();
//		if (this.toolSession.getCurrentStepDef().getStepType().equals("COMPOSITE")) {
//			this.compositeStepDef.pop();
//		}
		this.toolSession.setCurrentStepDef(this.compositeStepDef);
		sysOutput("Volviendo a " + this.toolSession.getCurrentStepDef().getStepDefDBEId() + " de tipo " + this.toolSession.getCurrentStepDef().getStepType());
	}
	
//	public void saveStepDefConfig() {
//		RequestContext.getCurrentInstance().closeDialog(this.toolSession.getCurrentStepDef());
//	}
//	
//	public void cancelStepDefConfig() {
//		sysOutput("Cancelando");
//		RequestContext.getCurrentInstance().closeDialog(this.toolSession.getCurrentStepDef());
//	}
//
	public StepDef getCurrentStepDef() {
		sysOutput("El currentStepDef es " + this.toolSession.getCurrentStepDef());
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
	
	public boolean hasSteps() {
		return this.compositeStepDef.hasSteps();
	}
	
	public void reorderStepDef(DashboardReorderEvent event) {
		sysOutput("entrando a reorder");
		String widgetId = event.getWidgetId();
		int idx = Integer.parseInt(widgetId.substring(6));
		sysOutput("Cambio de " + idx + " a " + event.getItemIndex());
		this.compositeStepDef.reorderStepDef(idx, event.getItemIndex());
	}

	public void saveNewStepsOrder() throws SystemException {
		this.compositeStepDef.saveNewStepsOrder();
		this.createDashBoard();
	}

	public long getStepDefDBEId() {
		return this.compositeStepDef.getStepDefDBEId();
	}
	
	public long getStepDefDBEId(int index) {
		return this.compositeStepDef.getStepDef(index).getStepDefDBEId();
	}
	
	public String getStepType(int index) {
		return WordUtils.capitalizeFully(this.compositeStepDef.getStepDef(index).getStepType());
	}
	
	public String getStepName(int index) {
		return this.compositeStepDef.getStepDef(index).getStepDefName();
	}
	
	public void deleteStepDef(int index) throws SystemException, PortalException {
		this.compositeStepDef.deleteStepDef(index);
		this.createDashBoard();
		this.compositeStepDef.initStepsOrder();
	}
	
	public List<Integer> getIndexesList() {
		List<Integer> aux = this.compositeStepDef.getNewOrderedIndexes();
		sysOutput("Getting indexes = " + aux);
		return aux;
	}
	
	public int getStepsNumber() {
		return this.compositeStepDef.getStepsNumber();
	}
}
