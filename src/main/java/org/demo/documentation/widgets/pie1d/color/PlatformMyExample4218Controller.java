package org.demo.documentation.widgets.pie1d.color;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4218Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4218(MyExample4218Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4218Controller> Holder = new Holder<>(
			PlatformMyExample4218Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4218Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4218Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4218Controller> {

		public BcSupplier() {
			super(PlatformMyExample4218Controller.Holder);
		}

	}

}
