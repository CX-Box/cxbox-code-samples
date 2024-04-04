package org.demo.documentation.money.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample69Controller implements EnumBcIdentifier {

	// @formatter:on
	// --8<-- [start:bc]
	myExampleBc69(MyExample69Service.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<PlatformMyExample69Controller> Holder = new Holder<>(
			PlatformMyExample69Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample69Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample69Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample69Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample69Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample69Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample69Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample69Controller> {

		public BcSupplier() {
			super(PlatformMyExample69Controller.Holder);
		}

	}

}