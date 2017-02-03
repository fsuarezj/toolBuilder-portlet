package org.lrc.liferay.toolbuilder.bean.toolDefinition;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;

import javax.annotation.PreDestroy;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.lrc.liferay.toolbuilder.ToolDef;
import org.lrc.liferay.toolbuilder.bean.AbstractBaseBean;
import org.lrc.liferay.toolbuilder.bean.FactoryBean;
import org.lrc.liferay.toolbuilder.bean.steps.CompositeStepDefBacking;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class EditToolDefBacking extends AbstractBaseBean implements Serializable {
	
	private static final long serialVersionUID = 7422248327006221303L;

	private ToolDef toolDef = null;
	private String newToolDefName, oldToolDefName = null;
	@ManagedProperty(name = "compositeStepDefBacking", value = "#{compositeStepDefBacking}")
	private CompositeStepDefBacking compositeStepDefBacking;

	public EditToolDefBacking() {
		// TODO Auto-generated constructor stub
		sysOutput("New construction of tool bean");
	}
	
	@PreDestroy
	public void destroyBean() {
		sysOutput("ESTÁ DESTRUYENDO LA BEAN de Tool");
	}
	
	public void setToolDefName(String toolDefName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException, IOException {
		if (this.toolDef != null) {
			sysOutput("Setting toolDefName for an existing toolDef");
			sysOutput("Saving toolDefName as " + toolDefName);
			this.oldToolDefName = this.toolDef.getToolDefName();
			this.toolDef.setToolDefName(toolDefName);
		} else if (toolDefName == null) {
			sysOutput("Entrando para null");
		} else if (!toolDefName.isEmpty()){
			sysOutput("ToolDefName = " + toolDefName);
			try {
				this.toolDef = FactoryBean.getToolDef(toolDefName);
				sysOutput("Acaba de pasar a objeto la tooldef " + toolDefName + ". Es " + this.toolDef +
						" con composite = " + this.toolDef.getCompositeStepDef());
//				CompositeStepDef aux = this.toolDef.getCompositeStepDef();
				this.compositeStepDefBacking.setCompositeStepDef(this.toolDef.getCompositeStepDef());
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext fc = FacesContext.getCurrentInstance();
				NavigationHandler nh = fc.getApplication().getNavigationHandler();
				nh.handleNavigation(fc, null, "adminView.xhtml");
			}
		} else {
			sysOutput("Entrando para nombre en blanco");
			FacesContext fc = FacesContext.getCurrentInstance();
			NavigationHandler nh = fc.getApplication().getNavigationHandler();
			nh.handleNavigation(fc, null, "adminView.xhtml");
		}
	}
	
	public String getToolDefName() {
		sysOutput("Tratando de recoger la var toolDefName");
		if (this.toolDef != null) {
			sysOutput("Recogiendo la var toolDefName = " + this.toolDef.getToolDefName());
			return this.toolDef.getToolDefName();
		}
		return null;
	}

	public String getNewToolDefName() {
		sysOutput("Recogiendo la var newToolDefName = " + this.newToolDefName);
		return this.newToolDefName;
	}

	public void setNewToolDefName(String newToolDefName) throws UnsupportedEncodingException {
		sysOutput("Poniendo la newToolDefName a " + newToolDefName);
		this.newToolDefName = URLDecoder.decode(newToolDefName, "UTF-8");
	}
//	
//	public StepDef getCompositeStepDef() {
//		return this.compositeStepDef;
//	}
	
	public void createNewToolDef() throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException, IOException {
		if (!(FacesContext.getCurrentInstance().isPostback())) {
			if (this.newToolDefName != null) {
				sysOutput("Crea la nueva toolDef " + this.newToolDefName);
				this.toolDef = new ToolDef(this.newToolDefName);	
				this.compositeStepDefBacking.setCompositeStepDef(this.toolDef.getCompositeStepDef());
				FactoryBean.putToolDef(this.toolDef.getToolDefName(), this.toolDef);
				this.newToolDefName = null;
			}
		}
	}

	public String saveToolDef() throws SystemException, PortalException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.toolDef.save(); 
		if (this.oldToolDefName != null) {
			FactoryBean.removeToolDef(this.oldToolDefName);
			FactoryBean.putToolDef(this.toolDef.getToolDefName(), this.toolDef);
			sysOutput("Salvando cambio de nombre de " + this.oldToolDefName + " a " + this.toolDef.getToolDefName());
			this.oldToolDefName = null;
		}
		sysOutput("Salvada " + this.toolDef.getToolDefName());
		return "adminView.xhtml";
	}

	public CompositeStepDefBacking getCompositeStepDefBacking() {
		return compositeStepDefBacking;
	}

	public void setCompositeStepDefBacking(CompositeStepDefBacking compositeStepDefBacking) {
		this.compositeStepDefBacking = compositeStepDefBacking;
	}
	
	public String printDebug() {
		sysOutput("PRINT DEBUG");
		return "DEBUG";
	}
}
