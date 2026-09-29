package org.demo.documentation.widgets.pie1d.tooltip;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4211Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4211(MyExample4211Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4211Controller> Holder = new Holder<>(
			PlatformMyExample4211Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4211Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4211Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4211Controller> {

		public BcSupplier() {
			super(PlatformMyExample4211Controller.Holder);
		}

	}

}
