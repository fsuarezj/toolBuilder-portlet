package org.lrc.liferay.toolbuilder.bean.steps;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang.WordUtils;
import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.toolDefinition.EditToolDefBacking;
import org.lrc.liferay.toolbuilder.steps.composite.CompositeStepDef;
import org.primefaces.event.DashboardReorderEvent;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@RequestScoped
public class CompositeStepDefBacking extends AbstractBaseBean {

	@ManagedProperty(name = "editToolDefBacking", value = "#{editToolDefBacking}")
	private EditToolDefBacking editToolDefBacking;

	@ManagedProperty(name = "compositeStepDef", value = "#{editToolDefBacking.compositeStepDef}")
	private CompositeStepDef compositeStepDef;

	public CompositeStepDefBacking() {
		// TODO Auto-generated constructor stub
	}
	
	public void reorderStepDef(DashboardReorderEvent event) {
		System.out.println("entrando a reorder");
		String widgetId = event.getWidgetId();
		int idx = Integer.parseInt(widgetId.substring(6));
		System.out.println("Cambio de " + idx + " a " + event.getItemIndex());
		this.compositeStepDef.reorderStepDef(idx, event.getItemIndex());
	}

	public void saveNewStepsOrder() throws SystemException {
		this.compositeStepDef.saveNewStepsOrder();
		this.editToolDefBacking.createDashBoard();
	}

	public long getStepDefDBEId() {
		return editToolDefBacking.getCompositeStepDef().getStepDefDBEId();
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
		this.editToolDefBacking.createDashBoard();
		this.compositeStepDef.initStepsOrder();
	}
	
	public List<Integer> getIndexesList() {
		List<Integer> aux = ((CompositeStepDef) this.editToolDefBacking.getCompositeStepDef()).getNewOrderedIndexes();
		System.out.println("Getting indexes = " + aux);
		return aux;
	}
	
	public int getStepsNumber() {
		return this.compositeStepDef.getStepsNumber();
	}

	public EditToolDefBacking getEditToolDefBacking() {
		return editToolDefBacking;
	}

	public void setEditToolDefBacking(EditToolDefBacking editToolDefBacking) {
		this.editToolDefBacking = editToolDefBacking;
	}

	public CompositeStepDef getCompositeStepDef() {
		return compositeStepDef;
	}

	public void setCompositeStepDef(CompositeStepDef compositeStepDef) {
		this.compositeStepDef = compositeStepDef;
	}

//	public void orderStepDefsDialog() {
//		// To embed just the portlet and not the whole portal in the dialog
//		Map<String, List<String>> params = new HashMap<String, List<String>>();
//		List<String> paramValue = new ArrayList<String>();
//		paramValue.add(LiferayWindowState.POP_UP.toString());
//		params.put("p_p_state", paramValue);
//
//		// Dialog options
//		Map<String,Object> options = new HashMap<String,Object>();
//		options.put("resizable", true);
//		options.put("draggable", true);
//		options.put("modal", true);
//		options.put("header", new String("Order the steps"));
//		options.put("showEffect", "explode");
//		options.put("width", "1000");
//
//		// Call to openDialog
//		System.out.println("Va a abrir el diálogo");
//		RequestContext.getCurrentInstance().openDialog("orderStepDefsDialog", options, params);
//		RequestContext.getCurrentInstance().update("@all");
////		return "steps/orderStepDefsDialog.xhtml";
//	}
//
//	public void selectStepDef(InstalledStep stepType) {
//		System.out.println("Ejecutando actionListener de salida del dialog");
//		RequestContext.getCurrentInstance().closeDialog(stepType);
//	}
	
}
