package org.demo.documentation.additional.checkforceactiveshowcondition.hiddenchain;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436_;
import org.springframework.stereotype.Service;

/**
 * Scenario 7: the great-grandchild of myexample1432 (the child of the hidden myexample1449), hidden by showCondition
 */
@Service
public class MyExample1450Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "hiddenGreatGrandchild";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

	@Override
	protected Predicate parentPredicate(Root<MyEntity1436> root, CriteriaBuilder cb, BusinessComponent bc) {
		return cb.equal(root.get(MyEntity1436_.ownerId), bc.getParentIdAsLong());
	}

}
