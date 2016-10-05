package org.lrc.liferay.toolbuilder.steps.composite;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lrc.liferay.toolbuilder.CompositeStepDBEException;
import org.lrc.liferay.toolbuilder.CompositeStepDefDBEException;
import org.lrc.liferay.toolbuilder.NoSuchInstalledStepException;
import org.lrc.liferay.toolbuilder.NoSuchStepDefDBEException;
import org.lrc.liferay.toolbuilder.StepDBEException;
import org.lrc.liferay.toolbuilder.StepDefDBEException;
import org.lrc.liferay.toolbuilder.StepFactory;
import org.lrc.liferay.toolbuilder.model.CompositeStepDefDBE;
import org.lrc.liferay.toolbuilder.model.StepDefDBE;
import org.lrc.liferay.toolbuilder.model.StepDefsCompositeStepDefDBE;
import org.lrc.liferay.toolbuilder.service.CompositeStepDefDBELocalServiceUtil;
import org.lrc.liferay.toolbuilder.service.StepDefDBELocalServiceUtil;
import org.lrc.liferay.toolbuilder.service.StepDefsCompositeStepDefDBELocalServiceUtil;
import org.lrc.liferay.toolbuilder.steps.Step;
import org.lrc.liferay.toolbuilder.steps.StepDef;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class CompositeStepDef extends StepDef {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7733476918496135630L;
	private CompositeStepDefDBE compositeStepDefDBE;
	private List<StepDef> stepDefs;
//	private List<String> newOrderedIndexes;
	private List<Integer> newOrderedIndexes = new ArrayList<Integer>();

	/* CONSTRUCTORS */
	public CompositeStepDef() throws NoSuchUserException, NoSuchInstalledStepException, StepDefDBEException, SystemException, CompositeStepDefDBEException {
		super("COMPOSITE");
		System.out.println("It is going to create new Composite Step with ID " + this.stepDefDBE.getStepDefDBEId());
		this.compositeStepDefDBE = CompositeStepDefDBELocalServiceUtil.addCompositeStepDefDBE(true, 0);
		this.setStepTypeId(this.compositeStepDefDBE.getCompositeStepDefDBEId());
		this.stepDefs = new ArrayList<StepDef>();
	}

	public CompositeStepDef(StepDefDBE stepDefDBE) throws PortalException, SystemException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		super(stepDefDBE);
		this.compositeStepDefDBE = CompositeStepDefDBELocalServiceUtil.getCompositeStepDefDBE(stepDefDBE.getStepTypeId());
		this.buildStepDefs();
	}
	
//	public CompositeStepDef(CompositeStepDefDBE compositeStepDefDBE) {
//		int a = 1;
//		super(compositeStepDefDBE);
//		this.compositeStepDefDBE = compositeStepDefDBE;
//	}

	/* GETTERS AND SETTERS */
	public void setStepsNumber() {
		this.compositeStepDefDBE.setStepsNumber(this.stepDefs.size());
	}
	
	public int getStepsNumber() {
		return this.compositeStepDefDBE.getStepsNumber();
	}

	public void setSequential(boolean sequential) {
		this.compositeStepDefDBE.setSequential(sequential);
	}
	
	public boolean isSequential() {
		return this.compositeStepDefDBE.getSequential();
	}
	
	public void setDepth(int depth) {
		this.compositeStepDefDBE.setDepth(depth);
	}
	
	public int getDepth() {
		return this.compositeStepDefDBE.getDepth();
	}
	
	public long getCompositeStepDefDBEId() {
		return this.compositeStepDefDBE.getCompositeStepDefDBEId();
	}
	
	// VER CÓMO get y set los StepDefs
	public StepDef getStepDef(int index) {
		return this.stepDefs.get(index);
	}
	
	public boolean hasSteps() {
		System.out.println("dos");
		return !this.stepDefs.isEmpty();
	}
	
//	public List<Integer> getIndexesList() {
//	public List<String> getIndexesList() {
//		if (this.newOrderedIndexes == null) {
//			this.newOrderedIndexes = new ArrayList<String>();
//			//		List<Integer> result = new ArrayList<Integer>();
//					for (Integer i = 0; i < this.getStepsNumber(); i++) {
//			//			result.add(i);
//						this.newOrderedIndexes.add(i.toString());
//					}
//		}
//		System.out.println("Recogiendo indexes");
//		System.out.println(this.newOrderedIndexes);
//		return this.newOrderedIndexes;
//	}
//	
//	public void setIndexesList(List<String> indexes) {
////	public void setIndexesList(List<Integer> indexes) {
//		System.out.println("Listando indexes");
//		System.out.println(indexes);
//		this.newOrderedIndexes = indexes;
//	}
	
//	public List<Long> getIdsList() {
//		List<Long> result = new ArrayList<Long>();
//		for (int i = 0; i < this.getStepsNumber(); i++) {
//			result.add(this.stepDefs.get(i).getStepDefDBEId());
//		}
//		return result;
//	}
//	
//	public void setIdsList(List<Long> ids) {
//		System.out.println("Listando ids");
//		System.out.println(ids);
//	}
//	
//	public String getStepTypeByIndex(Integer index) {
//		return this.stepDefs.get(index).getStepType();
//	}
//	
//	public String getStepTypeById(Long stepDefDBEId) {
//		for (StepDef stepDef: this.stepDefs) {
//			if (stepDef.getStepDefDBEId() == stepDefDBEId) {
//				return stepDef.getStepType();
//			}
//		}
//		return null;
//	}
	
	public List<StepDef> getStepDefsList() {
		List<StepDef> result = new ArrayList<StepDef>();
		for (int i = 0; i < this.getStepsNumber(); i++) {
			result.add(this.getStepDef(i));
		}
		return result;
	}
	
	public List<StepDef> getStepDefs() {
		return this.stepDefs;
	}
	
	public void setStepDefs(List<StepDef> stepDefs) {
		this.stepDefs = stepDefs;
	}
	
	public void addStepDef(StepDef stepDef) throws SystemException {
		this.addStepDef(stepDef, this.stepDefs.size());
	}

	public void addStepDef(StepDef stepDef, int stepIndex) throws SystemException {
			// Includes new StepDef in the tables
//			this.save();
//			stepDef.save();
			this.stepDefs.add(stepIndex, stepDef);
			System.out.println("Añadido StepDef de tipo " + stepDef.getStepType());
			// Increments stepNumber
			this.setStepsNumber();
			this.newOrderedIndexes.add(this.stepDefs.size() - 1);
	}
	
	public void deleteStepDef(int index) throws SystemException, PortalException {
		try {
			StepDef auxStepDef = this.stepDefs.get(index);
			this.stepDefs.remove(index);
			this.setStepsNumber();
			this.compositeStepDefDBE.deleteRelationship(auxStepDef.getStepDefDBE());
			auxStepDef.delete();
			System.out.println("Antes de borrar: " + this.newOrderedIndexes);
			this.newOrderedIndexes.remove((Integer) index);
			System.out.println("Después de borrar: " + this.newOrderedIndexes);
			for (int i = 0; i < this.stepDefs.size(); i++) {
				if (this.newOrderedIndexes.get(i) > index) {
					this.newOrderedIndexes.set(i, this.newOrderedIndexes.get(i) - 1);
				}
			}
			System.out.println("Después de renumerar: " + this.newOrderedIndexes);
			this.saveNewStepsOrder(true);
			this.saveCompositeStepDef();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void initStepsOrder() {
		this.newOrderedIndexes = new ArrayList<Integer>();
		for (int i = 0; i < this.stepDefs.size(); this.newOrderedIndexes.add(i++));
	}
	
	public void reorderStepDef(int element, int newIndex) {
		this.newOrderedIndexes.remove((Integer) element);
		this.newOrderedIndexes.add(newIndex, element);
		System.out.println("El nuevo orden es " + this.newOrderedIndexes);
	}
	
	public void saveNewStepsOrder() throws SystemException {
		this.saveNewStepsOrder(false);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void saveNewStepsOrder(boolean sure) throws SystemException {
		System.out.println("Va a ordenar lista");
		List baseList = new ArrayList(this.newOrderedIndexes);
		Collections.sort(baseList);
//		System.out.println("newOrderedIndexes: " + this.newOrderedIndexes);
//		System.out.println("baseList: " + baseList);
//		System.out.println("Equals? " + this.newOrderedIndexes.equals(baseList));
		if (!this.newOrderedIndexes.equals(baseList) || sure) {
			System.out.println("Ordenando Lista");
			List<StepDef> newStepDefs = new ArrayList<StepDef>();
//			for (String i: this.newOrderedIndexes) {
//				newStepDefs.add(this.stepDefs.get(Integer.parseInt(i)));
			for (Integer i: this.newOrderedIndexes) {
				newStepDefs.add(this.stepDefs.get(i));
			}
			this.stepDefs = newStepDefs;
			this.initStepsOrder();
			this.saveStepsOrder();
		}
	}
	
	private void saveStepsOrder() throws SystemException {
		for (int stepIndex = 0; stepIndex < this.stepDefs.size(); stepIndex++) {
			StepDef auxStepDef = this.stepDefs.get(stepIndex);
			this.compositeStepDefDBE.saveRelationship(stepIndex, auxStepDef.getStepDefDBE());
		}
	}

	public List<Integer> getNewOrderedIndexes() {
		return newOrderedIndexes;
	}

	public void setNewOrderedIndexes(List<Integer> newOrderedIndexes) {
		this.newOrderedIndexes = newOrderedIndexes;
	}
	
	private void saveSteps() throws SystemException, PortalException {
		for (StepDef auxStepDef: this.stepDefs) {
			auxStepDef.save();
		}
	}
	
	private void saveCompositeStepDef() throws SystemException, PortalException {
		super.save();
		if (this.compositeStepDefDBE.getCompositeStepDefDBEId() == 0) {
			this.compositeStepDefDBE.setCompositeStepDefDBEId(this.stepDefDBE.getStepDefDBEId());
			CompositeStepDefDBELocalServiceUtil.addCompositeStepDefDBE(this.compositeStepDefDBE);
//			StepDefDBELocalServiceUtil.addCompositeStepDefDBEStepDefDBEs
//				(this.compositeStepDefDBE.getCompositeStepDefDBEId(), this.compositeStepDefDBE.getStepDefDBEs());
		}
		else {
			CompositeStepDefDBELocalServiceUtil.updateCompositeStepDefDBE(this.compositeStepDefDBE);
//			StepDefDBELocalServiceUtil.addCompositeStepDefDBEStepDefDBEs
//				(this.compositeStepDefDBE.getCompositeStepDefDBEId(), this.compositeStepDefDBE.getStepDefDBEs());
		}
	}
	
	public void save() throws SystemException, PortalException {
		super.save();
		if (this.compositeStepDefDBE.getCompositeStepDefDBEId() == 0) {
			this.compositeStepDefDBE.setCompositeStepDefDBEId(this.stepDefDBE.getStepDefDBEId());
			CompositeStepDefDBELocalServiceUtil.addCompositeStepDefDBE(this.compositeStepDefDBE);
//			StepDefDBELocalServiceUtil.addCompositeStepDefDBEStepDefDBEs
//				(this.compositeStepDefDBE.getCompositeStepDefDBEId(), this.compositeStepDefDBE.getStepDefDBEs());
		}
		else {
			CompositeStepDefDBELocalServiceUtil.updateCompositeStepDefDBE(this.compositeStepDefDBE);
//			StepDefDBELocalServiceUtil.addCompositeStepDefDBEStepDefDBEs
//				(this.compositeStepDefDBE.getCompositeStepDefDBEId(), this.compositeStepDefDBE.getStepDefDBEs());
		}
		this.saveSteps();
		this.saveNewStepsOrder(true);
	}
	
	@Override
	public Step buildStep() throws SystemException, NoSuchUserException, NoSuchInstalledStepException, StepDBEException, StepDefDBEException, CompositeStepDBEException {
		CompositeStep builtStep = new CompositeStep(this);
		System.out.println("Building composite step");
		for (StepDef stepDef: this.stepDefs) {
			System.out.println("Building substep of type " + stepDef.getStepType());
			builtStep.addStep(stepDef.buildStep());
		}
		return builtStep;
	}

	public void buildStepDefs() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SystemException, NoSuchStepDefDBEException, PortalException {
		System.out.println("It is going to rebuild steps defs for composite def with ID " + this.getCompositeStepDefDBEId());
//		List<StepDefDBE> stepDefDBEs = StepDefDBELocalServiceUtil.getCompositeStepDefDBEStepDefDBEs(this.getCompositeStepDefDBEId());
		List<StepDefsCompositeStepDefDBE> stepDefsCompositeStepDefDBEs = StepDefsCompositeStepDefDBELocalServiceUtil.getRelationships(this.getCompositeStepDefDBEId());
		this.stepDefs = new ArrayList<StepDef>();
		for (StepDefsCompositeStepDefDBE stepDefsCompositeStepDefDBE: stepDefsCompositeStepDefDBEs) {
			StepDefDBE stepDefDBE = StepDefDBELocalServiceUtil.getStepDefDBE(stepDefsCompositeStepDefDBE.getStepDefDBEId());
			this.stepDefs.add(StepFactory.getStepDef(stepDefDBE.getStepType(), stepDefDBE));
//			this.newOrderedIndexes.add(this.stepDefs.size() -1);
		}
	}

	@Override
	public String getAdminView() {
		return "compositeStepAdmin.xhtml";
	}
}
