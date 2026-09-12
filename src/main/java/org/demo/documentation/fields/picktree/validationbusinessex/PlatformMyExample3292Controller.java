package org.demo.documentation.fields.picktree.validationbusinessex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3292Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3292(MyExample3292Service.class),
	myEntity3292PickTreePopup(myExampleBc3292, MyEntity3292PickPickTreeService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<PlatformMyExample3292Controller> Holder = new Holder<>(
			PlatformMyExample3292Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3292Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3292Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3292Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3292Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3292Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3292Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3292Controller> {

		public BcSupplier() {
			super(PlatformMyExample3292Controller.Holder);
		}

	}

}