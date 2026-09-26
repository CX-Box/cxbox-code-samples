package org.demo.documentation.widgets.pie1d.pagelimit;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4263Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4263(MyExample4263Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4263Controller> Holder = new Holder<>(
			PlatformMyExample4263Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4263Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4263Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4263Controller> {

		public BcSupplier() {
			super(PlatformMyExample4263Controller.Holder);
		}

	}

}
