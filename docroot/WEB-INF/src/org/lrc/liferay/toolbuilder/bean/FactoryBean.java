package org.lrc.liferay.toolbuilder.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.lrc.liferay.toolbuilder.NoSuchToolDefDBEException;
import org.lrc.liferay.toolbuilder.StepFactory;
import org.lrc.liferay.toolbuilder.ToolDef;
import org.lrc.liferay.toolbuilder.model.ToolDefDBE;
import org.lrc.liferay.toolbuilder.service.ToolDefDBELocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Fernando Suárez
 * Application scoped bean to create the steps factory and to store tool definitions
 */
//@ManagedBean
@ManagedBean(eager = true)
@ApplicationScoped
public class FactoryBean extends AbstractBaseBean implements Serializable {

	private static final long serialVersionUID = 7484141348342418895L;
	private static Map<String, ToolDef> toolDefs = new HashMap<String, ToolDef>();
	private static ToolDef selectedToolDef;

	/**
	 * The constructor creates the stepFactory and get the installed ToolDefs names.
	 * @throws SystemException
	 * @throws PortalException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public FactoryBean() throws SystemException, PortalException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StepFactory.initialize();
		List<ToolDefDBE> toolDefDBEs = ToolDefDBELocalServiceUtil.getToolDefDBEs(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		for (ToolDefDBE toolDefDBE: toolDefDBEs) {
			toolDefs.put(toolDefDBE.getToolName(), null);
		}
	}

	/**
	 * Searches for a toolDef, if it has not yet been bring from the db it brings it.
	 * If there is no toolDef and the given name is "Test Tool" it will create the test tool
	 * 
	 * @param toolName the name of the tool to search
	 * @return the ToolDef object. null if there is no a Tool Definition with the given name.
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
	public static ToolDef getToolDef(String toolName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		ToolDef result;
		if (toolDefs.containsKey(toolName)) {
			System.out.println("Looking for the existing tool " + toolName);
			if (toolDefs.get(toolName) == null) {
				try {
					System.out.println("Bringing " + toolName + " from the database");
					ToolDefDBE toolDefDBE = ToolDefDBELocalServiceUtil.getToolDefDBE(toolName);
					result = new ToolDef(toolDefDBE);
					toolDefs.put(toolName, result);
				} catch (NoSuchToolDefDBEException e) {
					// TODO: Declare Specific Exception
					// throw new Exception("None tool with given name");
					System.out.println("No la encuentra");
					result = null;
				}
			} else {
				result = toolDefs.get(toolName);
			}
		} else if (toolName.equals("Test Tool")) {
			result = new ToolDef("Test Tool");
			System.out.println("Creando Test Tool = " + result);
			toolDefs.put(toolName, result);
		} else if (toolName.equals("Test Tool 2")) {
			result = new ToolDef("Test Tool 2");
			System.out.println("Creando Test Tool 2 = " + result);
			toolDefs.put(toolName, result);
		} else {
			// TODO: Declare Specific Exception
			// throw new Exception("None tool with given name");
			System.out.println("No encuentra " + toolName);
			result = null;
		}
		return result;
	}
	
	public static void removeToolDef(String toolDefName) throws PortalException, SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Removing from FactoryBean and db the toolDef " + toolDefName);
		ToolDef toolDef = FactoryBean.getToolDef(toolDefName);
		if (!toolDef.hasInstances()) {
			toolDef.delete();
			FactoryBean.toolDefs.remove(toolDefName);
		} else {
			throw new PortalException();
		}
	}
	
	public static boolean hasInstances(String toolDefName) throws SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PortalException {
		return FactoryBean.getToolDef(toolDefName).hasInstances();
	}
	
	public static void putToolDef(String toolDefName) {
		FactoryBean.toolDefs.put(toolDefName, null);
	}
	
	public static void putToolDef(String toolDefName, ToolDef toolDef) {
		FactoryBean.toolDefs.put(toolDefName, toolDef);
	}
	
	public static List<String> getToolDefNames() {
		return new ArrayList<String>(FactoryBean.toolDefs.keySet());
	}

	public static List<ToolDef> getToolDefs() {
		return new ArrayList<ToolDef>(FactoryBean.toolDefs.values());
	}
	
	public static List<ToolDef> getInstalledSteps() {
		return StepFactory.getInstalledSteps();
	}
	
	public static void setInstalledSteps(List<ToolDef> installedSteps) {
		
	}

	public static boolean isExistingToolDef(String toolDefName) {
		return FactoryBean.toolDefs.containsKey(toolDefName);
	}

	public static ToolDef getSelectedToolDef() {
		return selectedToolDef;
	}

	public static void setSelectedToolDef(ToolDef selectedToolDef) {
		FactoryBean.selectedToolDef = selectedToolDef;
	}
}
