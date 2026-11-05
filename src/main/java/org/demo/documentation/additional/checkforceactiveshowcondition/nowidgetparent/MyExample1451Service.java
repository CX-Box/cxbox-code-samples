package org.demo.documentation.additional.checkforceactiveshowcondition.nowidgetparent;

import org.demo.documentation.additional.checkforceactiveshowcondition.common.AbstractMyExample1436Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyExample1436DTO;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.springframework.stereotype.Service;

/**
 * Scenario 8: the child of myexample1432, the parent of myexample1452. It has no widget on the view of myexample1452:
 * its widget is on another view of the screen (a bc without widgets on the whole screen is not in the screen meta)
 */
@Service
public class MyExample1451Service extends AbstractMyExample1436Service<MyExample1436DTO, MyEntity1436> {

	public static final String SCENARIO = "noWidgetParent";

	@Override
	protected String scenario() {
		return SCENARIO;
	}

}
