package org.demo.documentation.widgets.pie1d.icon;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4214Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4214(MyExample4214Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4214Controller> Holder = new Holder<>(
			PlatformMyExample4214Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4214Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4214Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4214Controller> {

		public BcSupplier() {
			super(PlatformMyExample4214Controller.Holder);
		}

	}

}
