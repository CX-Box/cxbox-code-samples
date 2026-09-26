package org.demo.documentation.widgets.pie1d.labelposition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4262Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4262(MyExample4262Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4262Controller> Holder = new Holder<>(
			PlatformMyExample4262Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4262Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4262Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4262Controller> {

		public BcSupplier() {
			super(PlatformMyExample4262Controller.Holder);
		}

	}

}
