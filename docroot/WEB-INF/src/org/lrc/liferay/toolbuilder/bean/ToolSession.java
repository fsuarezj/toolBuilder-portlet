package org.lrc.liferay.toolbuilder.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Stack;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.lrc.liferay.toolbuilder.CompositeStepDBEException;
import org.lrc.liferay.toolbuilder.NoSuchCompositeStepDBEException;
import org.lrc.liferay.toolbuilder.NoSuchInstalledStepException;
import org.lrc.liferay.toolbuilder.NoSuchToolDefDBEException;
import org.lrc.liferay.toolbuilder.StepDBEException;
import org.lrc.liferay.toolbuilder.StepDefDBEException;
import org.lrc.liferay.toolbuilder.ToolDef;
import org.lrc.liferay.toolbuilder.ToolInstance;
import org.lrc.liferay.toolbuilder.steps.StepDef;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Fernando Suárez
 * A session scoped bean to store the different configurations for a session
 * 
 */
@ManagedBean
@SessionScoped
public class ToolSession extends AbstractBaseBean implements Serializable{
	
//	@ManagedProperty(name = "factoryBean", value = "#{factoryBean}")
//	private FactoryBean factoryBean;

	private static final long serialVersionUID = 8736093122352111506L;
	private static final String mainView = "mainView.xhtml";
	private static final String toolInstanceView = "toolInstanceView.xhtml";
	
	private ToolInstance selectedToolInstance;
//	private List<ToolInstance> toolInstances = null;
	private boolean workingOnToolInstance;
	private boolean configuringInstance;
	private Stack<StepDef> currentStepDef = new Stack<StepDef>();
//	private ToolDef selectedToolDef;
	
	// Permissions
	public static final String MODEL = "org.lrc.liferay.toolbuilder.model";
	
	/**
	 * Constructor which defines the tool Def as "Test Tool"
	 */
	public ToolSession() {
		this.workingOnToolInstance = false;
		this.configuringInstance = false;
		try {
			System.out.println("SELECTING");
			if (FactoryBean.getSelectedToolDef() == null) {
//				FactoryBean.setSelectedToolDef(FactoryBean.getToolDef("Test Tool 2"));
//				FactoryBean.setSelectedToolDef(FactoryBean.getToolDef("Test Tool"));
				FactoryBean.setSelectedToolDef("Test Tool 2");
				FactoryBean.setSelectedToolDef("Test Tool");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	@PostConstruct
	public void postConstruct() throws Exception {
	}

	/**
	 * Saves the selected tool instance
	 * @throws SystemException
	 * @throws PortalException 
	 */
	public void saveExistingToolInstance() throws SystemException, PortalException {
		this.selectedToolInstance.save();
	}

	/**
	 * Try to save a new Tool Instance. If there is a tool instance with the same name it shows an error
	 * @return a string to the tool instance view
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	public String saveNewToolInstance() throws SystemException, PortalException {
//		if (!this.toolInstances.contains(this.selectedToolInstance)) {
		if (!FactoryBean.getSelectedToolDef().getToolInstances().contains(this.selectedToolInstance)) {
			this.selectedToolInstance.save();
			this.configuringInstance = false;
			FactoryBean.getSelectedToolDef().getToolInstances().add(this.selectedToolInstance);
		} else {
//			SessionErrors.add(session, key); //logger.error("Existing Tool Instance");
			this.addGlobalErrorMessage("Existing Tool Instance");
		}
		return ToolSession.toolInstanceView;
	}
	
	/**
	 * Delete all not saved changes and deselects the tool instance
	 * @return a string to the main view
	 */
	public String cancelToolInstance() {
		this.selectedToolInstance = null;
		this.workingOnToolInstance = false;
		this.configuringInstance = false;
		return ToolSession.mainView;
	}
	
	/**
	 * Delete the selected tool instance and all associated entries from the database
	 * @return a string to the main view
	 */
	public String deleteToolInstance() {
		try {
			this.selectedToolInstance.delete();
			FactoryBean.getSelectedToolDef().getToolInstances().remove(this.selectedToolInstance);
			this.selectedToolInstance = null;
			this.workingOnToolInstance = false;
			this.configuringInstance = false;
		} catch (Exception e) {
			this.addGlobalUnexpectedErrorMessage();
			logger.error(e);
		}
		return ToolSession.mainView;
	}

	/**
	 * Selects a tool instance
	 * @param toolInstance the ToolInstance object to be selected
	 * @return a string to the tool instance view
	 */
	public String selectToolInstance(ToolInstance toolInstance) throws SystemException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		this.workingOnToolInstance = true;
		this.selectedToolInstance = toolInstance;
		this.selectedToolInstance.rebuildSteps();
		return ToolSession.toolInstanceView;
	}

	/**
	 * @return true if any tool instance is selected
	 */
	public boolean isWorkingOnToolInstance() {
		return this.workingOnToolInstance;
	}

	/**
	 * @return the selected tool instance object
	 */
	public ToolInstance getSelectedToolInstance() {
		return this.selectedToolInstance;
	}
	
	/**
	 * @return a list with existing tool instances for the existing configuration (user group and selected tool definition)
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws NoSuchCompositeStepDBEException 
	 */
	public List<ToolInstance> getToolInstances() throws NoSuchCompositeStepDBEException, PortalException, SystemException {
		// TODO: Mensajes entre SessionBeans cuando haya modificación del listado disponible para un usuario
		// TODO: Criterios de búsqueda (nombre del RAM, permisos, etc)
		return FactoryBean.getSelectedToolDef().getToolInstances();
//		ToolInstance toolInstance;
//		System.out.println("Calling ToolSession.getToolInstances()");
//		if (this.toolInstances == null) {
//			System.out.println("Try to bring tool instances");
//			this.toolInstances = new ArrayList<ToolInstance>();
//			long groupId = LiferayFacesContext.getInstance().getScopeGroupId();
//			try {
//				List<ToolInstanceDBE> list = ToolInstanceDBELocalServiceUtil.getToolInstanceDBEs(groupId, FactoryBean.getSelectedToolDef().getToolDefDBEId());
////				List<ToolInstanceDBE> list = ToolInstanceDBELocalServiceUtil.getToolInstanceDBEs(groupId, this.selectedToolDef.getToolDefDBEId());
//				for (ToolInstanceDBE toolInstanceDBE : list) {
////					toolInstance = new ToolInstance(toolInstanceDBE, this.selectedToolDef);
//					toolInstance = new ToolInstance(toolInstanceDBE, FactoryBean.getSelectedToolDef());
//					this.toolInstances.add(toolInstance);
//				}
//				System.out.println("Aquí ha llegao");
//			} catch (Exception e) {
//				logger.error(e);
//				System.out.println("Aquí ha llegao con error");
//			}
//		}
//		return this.toolInstances;
	}

	/**
	 * Sets if the selected tool instance is being configured or not
	 */
	public void setConfiguringInstance() {
		this.configuringInstance = true;
	}
	
	/**
	 * @return true if the selected tool instance is being configured
	 */
	public boolean getConfiguringInstance() {
		return this.configuringInstance;
	}

//	/**
//	 * Setter
//	 * @param factoryBean the FactoryBean object
//	 */
//	public void setFactoryBean(FactoryBean factoryBean) {
//		this.factoryBean = factoryBean;
//	}

	/**
	 * Creates a new empty tool instance from the selected tool definition
	 * @return  the tool instance object
	 */
	public ToolInstance createToolInstance() throws SystemException, NoSuchUserException, NoSuchInstalledStepException, StepDBEException, StepDefDBEException, CompositeStepDBEException, NoSuchToolDefDBEException {
//		return this.selectedToolDef.buildInstance();
		return FactoryBean.getSelectedToolDef().buildInstance();
	}
	
//	public Boolean getHasAddDefPermission() {
//		if (this.hasAddDefPermission == null) {
//			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
//			long scopeGroupId = liferayFacesContext.getScopeGroupId();
//			this.hasAddDefPermission = liferayFacesContext.getThemeDisplay().getPermissionChecker()
//					.hasPermission(scopeGroupId, MODEL, scopeGroupId, "ADD_TOOL_DEF");
//		}
//		return this.hasAddDefPermission;
//	}
//	
//	public void setHasAddDefPermission(Boolean hasAddDefPermission) {
//		this.hasAddDefPermission = hasAddDefPermission;
//	}

	/**
	 * Getter
	 * @return the selectedToolDef
	 */
	public ToolDef getSelectedToolDef() {
//		return selectedToolDef;
		return FactoryBean.getSelectedToolDef();
	}
	
	/**
	 * Set the selectedToolDef
	 * @param toolDefName the name of the selected tool definition
	 * @throws SystemException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws PortalException
	 */
	public void setSelectedToolDef(String toolDefName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		System.out.println("Seleccionando " + toolDefName);
//		this.selectedToolDef = FactoryBean.getToolDef(toolDefName);
		FactoryBean.setSelectedToolDef(FactoryBean.getToolDef(toolDefName));
		System.out.println("Tiene seleccionada " + FactoryBean.getSelectedToolDef().getToolDefName() + " con " + FactoryBean.getSelectedToolDef().getCompositeStepDef().getStepsNumber() + " pasos.");
	}
	
	public boolean isSelectedToolDef(String toolDefName) {
		return (toolDefName.equals(FactoryBean.getSelectedToolDef().getToolDefName()));
//		return (toolDefName.equals(this.selectedToolDef.getToolDefName()));
	}
	
	public boolean notIsSelectedToolDef(String toolDefName) {
		return !(toolDefName.equals(FactoryBean.getSelectedToolDef().getToolDefName()));
//		return (toolDefName.equals(this.selectedToolDef.getToolDefName()));
	}

	public StepDef getCurrentStepDef() {
		if (!currentStepDef.isEmpty()) {
			return currentStepDef.peek();
		} else {
			return null;
		}
	}

	public void setCurrentStepDef(StepDef currentStepDef) {
		this.currentStepDef.push(currentStepDef);
	}
	
	public StepDef popCurrentStepDef() {
		sysOutput("POPING the current Step Def");
		return currentStepDef.pop();
	}
	
//	public boolean hasDeleteInstancePermission() {
//		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
//		long scopeGroupId = liferayFacesContext.getScopeGroupId();
//		return liferayFacesContext.getThemeDisplay().getPermissionChecker().hasPermission
//				(scopeGroupId, ToolInstanceDBE.class.getName(), this.selectedToolInstance.getToolInstanceDBEId(), "DELETE");
//	}
//
}
