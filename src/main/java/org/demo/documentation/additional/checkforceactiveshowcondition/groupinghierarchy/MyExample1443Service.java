package org.demo.documentation.additional.checkforceactiveshowcondition.groupinghierarchy;

import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.springframework.stereotype.Service;

/**
 * Scenario 3: GroupingHierarchy with showCondition by the forceActive field of the parent
 */
@Service
public class MyExample1443Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "groupingHierarchy";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

}
