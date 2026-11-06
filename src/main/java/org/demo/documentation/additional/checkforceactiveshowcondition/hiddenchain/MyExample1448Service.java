package org.demo.documentation.additional.checkforceactiveshowcondition.hiddenchain;

import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.springframework.stereotype.Service;

/**
 * Scenario 7: the child of myexample1432, hidden by showCondition. Its children (myexample1449, myexample1450) are hidden too:
 * on the first open no bc of the chain has the data and the cursor
 */
@Service
public class MyExample1448Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "hiddenChild";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

}
