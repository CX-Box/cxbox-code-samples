package org.demo.documentation.widgets.picktree.customizationcolumns;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3352Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3352(MyExample3352Service.class), myEntity3352PickPick(myexample3352, MyEntity3352PickPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3352Controller> Holder = new Holder<>(
			CxboxMyExample3352Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3352Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3352Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3352Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3352Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3352Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3352Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3352Controller> {

		public BcSupplier() {
			super(CxboxMyExample3352Controller.Holder);
		}

	}

}