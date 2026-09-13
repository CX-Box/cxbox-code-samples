package org.demo.documentation.widgets.assoctree.title;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3336Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3336(MyExample3336Service.class),
	myEntity3336MultiPickEmpty(myexample3336, MyEntity3336MultiPickService.class),
	myEntity3336MultiPick(myexample3336, MyEntity3336MultiPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3336Controller> Holder = new Holder<>(
			CxboxMyExample3336Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3336Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3336Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3336Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3336Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3336Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3336Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3336Controller> {

		public BcSupplier() {
			super(CxboxMyExample3336Controller.Holder);
		}

	}

}