package org.lrc.liferay.toolbuilder.bean.toolDefinition;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.FactoryBean;

@ManagedBean
@RequestScoped
public class ToolDefListBacking extends AbstractBaseBean {

	private String newToolDefName;

	public ToolDefListBacking() {
		// TODO Auto-generated constructor stub
	}

	public void checkToolDefName(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
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
	
	public String editNewToolDef() throws UnsupportedEncodingException {
		System.out.println("Va a la pag de admin para crear " + this.newToolDefName);
		return "editToolDef?faces-redirect=true&amp;includeViewParams=true&amp;newToolDefName=" + URLEncoder.encode(this.newToolDefName, "UTF-8");
	}
	
}
