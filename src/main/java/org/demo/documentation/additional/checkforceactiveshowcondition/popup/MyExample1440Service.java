package org.demo.documentation.additional.checkforceactiveshowcondition.popup;

import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.springframework.stereotype.Service;

/**
 * Scenario 1: FormPopup with showCondition by the forceActive field of the parent. The popup is not opened
 */
@Service
public class MyExample1440Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "popup";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

}
