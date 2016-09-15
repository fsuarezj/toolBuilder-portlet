package org.lrc.liferay.toolbuilder.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.lrc.liferay.toolbuilder.model.InstalledStep;
import org.primefaces.context.RequestContext;

import com.liferay.portal.kernel.portlet.LiferayWindowState;

@ManagedBean
@RequestScoped
public class StepTypeListBacking extends AbstractBaseBean {

	public StepTypeListBacking() {
		// TODO Auto-generated constructor stub
	}

	public void chooseStepDef() {
		// To embed just the portlet and not the whole portal in the dialog
		System.out.println("Entrando a elegir StepDef en la nueva Bean");
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
	
}
