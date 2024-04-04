package org.demo.documentation.radio.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample31Controller implements EnumBcIdentifier {

	// @formatter:on
	// --8<-- [start:bc]
	myExampleBc31(MyExample31Service.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<PlatformMyExample31Controller> Holder = new Holder<>(
			PlatformMyExample31Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample31Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample31Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample31Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample31Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample31Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample31Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample31Controller> {

		public BcSupplier() {
			super(PlatformMyExample31Controller.Holder);
		}

	}

}