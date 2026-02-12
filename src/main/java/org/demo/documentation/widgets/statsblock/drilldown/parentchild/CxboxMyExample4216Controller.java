package org.demo.documentation.widgets.statsblock.drilldown.parentchild;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.MyExample4216Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4216Controller implements EnumBcIdentifier {
	// --8<-- [start:bc]
	// @formatter:on
	myexample4127(MyExample4127Service.class),
	myexample4216(myexample4127, MyExample4216Service.class);

	// @formatter:on
	// --8<-- [end:bc]
	public static final Holder<CxboxMyExample4216Controller> Holder = new Holder<>(
			CxboxMyExample4216Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample4216Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample4216Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample4216Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample4216Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample4216Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample4216Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4216Controller> {

		public BcSupplier() {
			super(CxboxMyExample4216Controller.Holder);
		}

	}

}