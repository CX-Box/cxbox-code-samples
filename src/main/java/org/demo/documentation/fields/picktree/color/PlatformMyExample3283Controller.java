package org.demo.documentation.fields.picktree.color;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3283Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3283(MyExample3283Service.class),
	myEntity3283PickTreePopup(myExampleBc3283, MyEntity3283PickPickTreeService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<PlatformMyExample3283Controller> Holder = new Holder<>(
			PlatformMyExample3283Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3283Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3283Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3283Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3283Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3283Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3283Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3283Controller> {

		public BcSupplier() {
			super(PlatformMyExample3283Controller.Holder);
		}

	}

}