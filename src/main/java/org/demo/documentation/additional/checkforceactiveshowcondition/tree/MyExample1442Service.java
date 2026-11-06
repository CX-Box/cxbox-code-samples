package org.demo.documentation.additional.checkforceactiveshowcondition.tree;

import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.springframework.stereotype.Service;

/**
 * Scenario 3: Tree with showCondition by the forceActive field of the parent
 */
@Service
public class MyExample1442Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "tree";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

}
