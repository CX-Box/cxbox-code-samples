package org.demo.documentation.additional.checkforceactiveshowcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.MyExample1432Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson.MyExample1434Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson.taxresidency.MyExample1435Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.taxresidency.MyExample1433Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.emptyparent.MyExample1453Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.emptyparent.MyExample1454Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.groupinghierarchy.MyExample1443Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.hiddenchain.MyExample1448Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.hiddenchain.MyExample1449Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.hiddenchain.MyExample1450Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.nowidgetparent.MyExample1451Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.nowidgetparent.MyExample1452Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.outsidehierarchy.MyExample1441Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.outsidehierarchy.MyExample1447Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.parentfilter.MyExample1446Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.popup.MyExample1440Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.tree.MyExample1442Service;
import org.springframework.stereotype.Component;

/**
 * Checks of widgets shown by showCondition, when the field of the condition is changed by forceActive of the parent (CXBOX-1432).
 * myexample1432 - the parent form with the forceActive radio, all the other bc are hidden by its showCondition field,
 * except myexample1434 (control persons), myexample1447 (bc outside of the hierarchy of myexample1432),
 * myexample1451 (no widget on the view of its child) and myexample1453 (empty list)
 */
@Getter
public enum CxboxMyExample1432Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample1432(MyExample1432Service.class),
		myexample1433(myexample1432, MyExample1433Service.class),
		myexample1434(myexample1432, MyExample1434Service.class),
			myexample1435(myexample1434, MyExample1435Service.class),
		myexample1440(myexample1432, MyExample1440Service.class),
		myexample1442(myexample1432, MyExample1442Service.class),
		myexample1443(myexample1432, MyExample1443Service.class),
		myexample1446(myexample1432, MyExample1446Service.class),
		myexample1448(myexample1432, MyExample1448Service.class),
			myexample1449(myexample1448, MyExample1449Service.class),
				myexample1450(myexample1449, MyExample1450Service.class),
		myexample1451(myexample1432, MyExample1451Service.class),
			myexample1452(myexample1451, MyExample1452Service.class),
		myexample1453(myexample1432, MyExample1453Service.class),
			myexample1454(myexample1453, MyExample1454Service.class),
	myexample1447(MyExample1447Service.class),
		myexample1441(myexample1447, MyExample1441Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample1432Controller> Holder = new Holder<>(
			CxboxMyExample1432Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample1432Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample1432Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample1432Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample1432Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample1432Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample1432Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample1432Controller> {

		public BcSupplier() {
			super(CxboxMyExample1432Controller.Holder);
		}

	}

}
