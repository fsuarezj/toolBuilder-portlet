package org.lrc.liferay.toolbuilder.bean.steps.composite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.model.InstalledStep;
import org.primefaces.context.RequestContext;

import com.liferay.portal.kernel.portlet.LiferayWindowState;

@ManagedBean
@RequestScoped
public class OrderStepsBacking extends AbstractBaseBean {

	public OrderStepsBacking() {
		// TODO Auto-generated constructor stub
	}

	public void orderStepDefsDialog() {
		// To embed just the portlet and not the whole portal in the dialog
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		List<String> paramValue = new ArrayList<String>();
		paramValue.add(LiferayWindowState.POP_UP.toString());
		params.put("p_p_state", paramValue);

		// Dialog options
		Map<String,Object> options = new HashMap<String,Object>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("header", new String("Order the steps"));
		options.put("showEffect", "explode");
		options.put("width", "1000");

		// Call to openDialog
		System.out.println("Va a abrir el diálogo");
		RequestContext.getCurrentInstance().openDialog("orderStepDefsDialog", options, params);
		RequestContext.getCurrentInstance().update("@all");
//		return "steps/orderStepDefsDialog.xhtml";
	}

	public void selectStepDef(InstalledStep stepType) {
		System.out.println("Ejecutando actionListener de salida del dialog");
		RequestContext.getCurrentInstance().closeDialog(stepType);
	}
	
}
