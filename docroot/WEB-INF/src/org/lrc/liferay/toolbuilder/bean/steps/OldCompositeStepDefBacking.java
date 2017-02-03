package org.lrc.liferay.toolbuilder.bean.steps;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang.WordUtils;
import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.toolDefinition.EditToolDefBacking;
import org.lrc.liferay.toolbuilder.steps.composite.CompositeStepDef;
import org.primefaces.event.DashboardReorderEvent;

@ManagedBean
@RequestScoped
public class OldCompositeStepDefBacking extends AbstractBaseBean {

	@ManagedProperty(name = "editToolDefBacking", value = "#{editToolDefBacking}")
	private EditToolDefBacking editToolDefBacking;

	@ManagedProperty(name = "compositeStepDef", value = "#{editToolDefBacking.compositeStepDef}")
	private CompositeStepDef compositeStepDef;

	public OldCompositeStepDefBacking() {
		// TODO Auto-generated constructor stub
	}
	
	public void reorderStepDef(DashboardReorderEvent event) {
		System.out.println("entrando a reorder");
		String widgetId = event.getWidgetId();
		int idx = Integer.parseInt(widgetId.substring(6));
		System.out.println("Cambio de " + idx + " a " + event.getItemIndex());
		this.compositeStepDef.reorderStepDef(idx, event.getItemIndex());
	}

//	public void saveNewStepsOrder() throws SystemException {
//		this.compositeStepDef.saveNewStepsOrder();
//		this.editToolDefBacking.createDashBoard();
//	}
//
//	public long getStepDefDBEId() {
//		return editToolDefBacking.getCompositeStepDef().getStepDefDBEId();
//	}
	
	public long getStepDefDBEId(int index) {
		return this.compositeStepDef.getStepDef(index).getStepDefDBEId();
	}
	
	public String getStepType(int index) {
		return WordUtils.capitalizeFully(this.compositeStepDef.getStepDef(index).getStepType());
	}
	
	public String getStepName(int index) {
		return this.compositeStepDef.getStepDef(index).getStepDefName();
	}
	
//	public void deleteStepDef(int index) throws SystemException, PortalException {
//		this.compositeStepDef.deleteStepDef(index);
//		this.editToolDefBacking.createDashBoard();
//		this.compositeStepDef.initStepsOrder();
//	}
//	
//	public List<Integer> getIndexesList() {
//		List<Integer> aux = ((CompositeStepDef) this.editToolDefBacking.getCompositeStepDef()).getNewOrderedIndexes();
//		System.out.println("Getting indexes = " + aux);
//		return aux;
//	}
	
	public int getStepsNumber() {
		return this.compositeStepDef.getStepsNumber();
	}
}
