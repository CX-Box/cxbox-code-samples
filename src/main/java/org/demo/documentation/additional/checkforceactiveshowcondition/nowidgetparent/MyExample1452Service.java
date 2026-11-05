package org.demo.documentation.additional.checkforceactiveshowcondition.nowidgetparent;

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
 * Scenario 8: the child of myexample1451 (no widget on the view), hidden by showCondition
 */
@Service
public class MyExample1452Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "noWidgetParentChild";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

	@Override
	protected Predicate parentPredicate(Root<MyEntity1436> root, CriteriaBuilder cb, BusinessComponent bc) {
		return cb.equal(root.get(MyEntity1436_.ownerId), bc.getParentIdAsLong());
	}

}
