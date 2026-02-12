package org.demo.documentation.widgets.assoc.title;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3090Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3090(MyExample3090Service.class),
	myEntity3090MultiPickEmpty(myexample3090, MyEntity3090MultiPickService.class),
	myEntity3090MultiPick(myexample3090, MyEntity3090MultiPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3090Controller> Holder = new Holder<>(
			CxboxMyExample3090Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3090Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3090Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3090Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3090Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3090Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3090Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3090Controller> {

		public BcSupplier() {
			super(CxboxMyExample3090Controller.Holder);
		}

	}

}