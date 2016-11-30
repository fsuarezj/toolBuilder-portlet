package org.lrc.liferay.toolbuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lrc.liferay.toolbuilder.model.InstalledStep;
import org.lrc.liferay.toolbuilder.model.StepDBE;
import org.lrc.liferay.toolbuilder.model.StepDefDBE;
import org.lrc.liferay.toolbuilder.service.InstalledStepLocalServiceUtil;
import org.lrc.liferay.toolbuilder.steps.Step;
import org.lrc.liferay.toolbuilder.steps.StepDef;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;

public final class StepFactory {
	private static Map<String, InstalledStep> stepClasses = new HashMap<String, InstalledStep>();
	
	public static void initialize() throws SystemException, NoSuchUserException, InstalledStepException {
//		List<InstalledStep> installedSteps = InstalledStepLocalServiceUtil.getInstalledSteps(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		List<InstalledStep> installedSteps = InstalledStepLocalServiceUtil.getInstalledSteps(0, InstalledStepLocalServiceUtil.getInstalledStepsCount());
		if (installedSteps.isEmpty()) {
			StepFactory.installCoreSteps();
		} else {
			for (InstalledStep installedStep: installedSteps) {
				StepFactory.stepClasses.put(installedStep.getStepType(), installedStep);
			}
		}
//		StepFactory.stepClasses.put("INFO", "org.lrc.liferay.toolbuilder.steps.InfoStep");
//		StepFactory.stepClasses.put("DECISION_TREE", "org.lrc.liferay.toolbuilder.steps.DecisionTreeStep");
	}
	
	private static void installCoreSteps() throws SystemException, NoSuchUserException, InstalledStepException {
		// TODO Fill other database fields for Core Steps
		StepFactory.installStep("COMPOSITE", "A step to contain other steps", "org.lrc.liferay.toolbuilder.steps.composite", "CompositeStep");
		StepFactory.installStep("MOCK", "A void step for testing and developing purposes", "org.lrc.liferay.toolbuilder.steps.mock", "MockStep");
	}
	
	public static void installStep(String stepType, String stepDescription, String namespace, String className) throws SystemException, NoSuchUserException, InstalledStepException {
		
		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
		InstalledStep installedStep = InstalledStepLocalServiceUtil.addInstalledStep(stepType, stepDescription, namespace, className, liferayFacesContext);
		StepFactory.stepClasses.put(stepType, installedStep);
	}
	
//	private static void installStep(String stepType, InstalledStep installedStep) throws SystemException {
//		InstalledStepLocalServiceUtil.addInstalledStep(installedStep);
//		StepFactory.stepClasses.put(stepType, installedStep);
//	}
	
	public static StepDef getStepDef(String stepType) throws NoSuchUserException, InstalledStepException, SystemException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (StepFactory.stepClasses.isEmpty())
			StepFactory.installCoreSteps();
//		System.out.println("Creating Step " + StepFactory.stepClasses.get(stepType) + " for name " + stepType);
		Class<?> stepClass = Class.forName(stepClasses.get(stepType).getNamespace() +
				"." + stepClasses.get(stepType).getClassName() + "Def");
		Constructor<?> stepConstructor = stepClass.getConstructor();
		return (StepDef) stepConstructor.newInstance();
	}

	public static StepDef getStepDef(String stepType, StepDefDBE stepDefDBE) {
//		System.out.println("Creating Step " + StepFactory.stepClasses.get(stepType) + " for name " + stepType);
		try {
		Class<?> stepClass = Class.forName(stepClasses.get(stepType).getNamespace() +
				"." + stepClasses.get(stepType).getClassName() + "Def");
		Class<?>[] cArgs = new Class[1];
		cArgs[0] = StepDefDBE.class;
		Constructor<?> stepConstructor = stepClass.getConstructor(cArgs);
		System.out.println("It is going to create a step def of type " + stepType);
		return (StepDef) stepConstructor.newInstance(stepDefDBE);
		} catch (ClassNotFoundException | NoSuchMethodException |
				SecurityException | InstantiationException |
				IllegalAccessException | IllegalArgumentException |
				InvocationTargetException p) {
			p.printStackTrace();
		}
		return null;
	}

	public static Step getStep(String stepType, StepDBE stepDBE) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> stepClass = Class.forName(stepClasses.get(stepType).getNamespace() +
				"." + stepClasses.get(stepType).getClassName());
		Class<?>[] cArgs = new Class[1];
		cArgs[0] = StepDBE.class;
		Constructor<?> stepConstructor = stepClass.getConstructor(cArgs);
		return (Step) stepConstructor.newInstance(stepDBE);
	}

	public static boolean isInstalledStep(String stepType) {
		return StepFactory.stepClasses.containsKey(stepType);
	}
	
	@SuppressWarnings("unchecked")
	public static List<ToolDef> getInstalledSteps() {
		return new ArrayList<ToolDef>((Collection<? extends ToolDef>) StepFactory.stepClasses.values());
	}

	public static String getStepDescription(String stepType) {
		// TODO Auto-generated method stub
		return StepFactory.stepClasses.get(stepType).getStepDescription();
	}
}
