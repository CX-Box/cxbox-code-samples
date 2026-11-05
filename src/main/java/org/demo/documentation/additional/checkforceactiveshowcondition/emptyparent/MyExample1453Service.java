package org.demo.documentation.additional.checkforceactiveshowcondition.emptyparent;

import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.springframework.stereotype.Service;

/**
 * Scenario 9: the child of myexample1432, always shown and has no records: its data is loaded, but there is no cursor
 */
@Service
public class MyExample1453Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "emptyParent";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

}
