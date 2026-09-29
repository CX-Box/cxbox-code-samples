package org.demo.documentation.widgets.pie1d.base.defaultfields;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4207Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4207(MyExample4207Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4207Controller> Holder = new Holder<>(
			PlatformMyExample4207Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4207Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4207Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4207Controller> {

		public BcSupplier() {
			super(PlatformMyExample4207Controller.Holder);
		}

	}

}
