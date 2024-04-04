package org.demo.documentation.radio.colorconst;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample22Controller implements EnumBcIdentifier {

	// @formatter:on
	// --8<-- [start:bc]
	myExampleBc22(MyExample22Service.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<PlatformMyExample22Controller> Holder = new Holder<>(
			PlatformMyExample22Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample22Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample22Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample22Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample22Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample22Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample22Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample22Controller> {

		public BcSupplier() {
			super(PlatformMyExample22Controller.Holder);
		}

	}

}