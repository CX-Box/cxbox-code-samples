package org.demo.documentation.widgets.pie1d.filtration;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4264Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4264(MyExample4264Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4264Controller> Holder = new Holder<>(
			PlatformMyExample4264Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4264Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4264Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4264Controller> {

		public BcSupplier() {
			super(PlatformMyExample4264Controller.Holder);
		}

	}

}
