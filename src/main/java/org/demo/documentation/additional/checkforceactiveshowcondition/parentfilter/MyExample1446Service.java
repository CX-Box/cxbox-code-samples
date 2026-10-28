package org.demo.documentation.additional.checkforceactiveshowcondition.parentfilter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.MyEntity1432_;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436_;
import org.springframework.stereotype.Service;

/**
 * Scenario 6: the children are filtered by the saved CRS status of the parent record
 */
@Service
public class MyExample1446Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "parentFilter";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

	@Override
	protected Predicate parentPredicate(Root<MyEntity1436> root, CriteriaBuilder cb, BusinessComponent bc) {
		var parent = root.join(MyEntity1436_.parentEntity);
		return cb.and(
				super.parentPredicate(root, cb, bc),
				cb.equal(root.get(MyEntity1436_.crsStatus), parent.get(MyEntity1432_.crsStatus))
		);
	}

}
