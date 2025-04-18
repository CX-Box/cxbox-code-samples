package org.demo.documentation.other.test;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample420Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc420(MyExample420Service.class);
	// --8<-- [end:bc]



	public static final EnumBcIdentifier.Holder<PlatformMyExample420Controller> Holder = new Holder<>(
			PlatformMyExample420Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample420Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample420Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample420Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample420Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample420Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample420Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample420Controller> {

		public BcSupplier() {
			super(PlatformMyExample420Controller.Holder);
		}

	}

}