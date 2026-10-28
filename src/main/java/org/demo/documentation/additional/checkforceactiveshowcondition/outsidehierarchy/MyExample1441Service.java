package org.demo.documentation.additional.checkforceactiveshowcondition.outsidehierarchy;

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
 * Scenario 2: the child of myexample1447 with showCondition by the forceActive field of myexample1432 (another hierarchy)
 */
@Service
public class MyExample1441Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "outsideChild";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

	@Override
	protected Predicate parentPredicate(Root<MyEntity1436> root, CriteriaBuilder cb, BusinessComponent bc) {
		return cb.equal(root.get(MyEntity1436_.ownerId), bc.getParentIdAsLong());
	}

}
