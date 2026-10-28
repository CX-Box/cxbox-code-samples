package org.demo.documentation.additional.forceactiveshowcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.additional.forceactiveshowcondition.controlperson.MyExample1434Service;
import org.demo.documentation.additional.forceactiveshowcondition.controlperson.taxresidency.MyExample1435Service;
import org.demo.documentation.additional.forceactiveshowcondition.taxresidency.MyExample1433Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample1432Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample1432(MyExample1432Service.class),
		myexample1433(myexample1432, MyExample1433Service.class),
		myexample1434(myexample1432, MyExample1434Service.class),
			myexample1435(myexample1434, MyExample1435Service.class);
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
