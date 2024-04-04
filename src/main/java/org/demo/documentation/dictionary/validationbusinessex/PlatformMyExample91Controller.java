package org.demo.documentation.dictionary.validationbusinessex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample91Controller implements EnumBcIdentifier {

	// @formatter:on
	// --8<-- [start:bc]
	myExampleBc91(MyExample91Service.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<PlatformMyExample91Controller> Holder = new Holder<>(
			PlatformMyExample91Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample91Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample91Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample91Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample91Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample91Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample91Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample91Controller> {

		public BcSupplier() {
			super(PlatformMyExample91Controller.Holder);
		}

	}

}