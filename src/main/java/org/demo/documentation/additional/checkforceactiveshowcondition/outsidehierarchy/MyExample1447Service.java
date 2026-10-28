package org.demo.documentation.additional.checkforceactiveshowcondition.outsidehierarchy;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.springframework.stereotype.Service;

/**
 * Scenario 2: the root bc outside of the hierarchy of myexample1432 (owners), always shown
 */
@Service
public class MyExample1447Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "outsideOwner";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

	@Override
	protected Predicate parentPredicate(Root<MyEntity1436> root, CriteriaBuilder cb, BusinessComponent bc) {
		return cb.conjunction();
	}

}
