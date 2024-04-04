package org.demo.documentation.percent.ro;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4Controller implements EnumBcIdentifier {

	// @formatter:on
	// --8<-- [start:bc]
	myExampleBc4(MyExample4Service.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<PlatformMyExample4Controller> Holder = new Holder<>(
			PlatformMyExample4Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample4Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample4Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample4Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample4Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4Controller> {

		public BcSupplier() {
			super(PlatformMyExample4Controller.Holder);
		}

	}

}