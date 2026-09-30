package org.demo.documentation.widgets.pie1d.fulltextsearch;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4265Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4265(MyExample4265Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4265Controller> Holder = new Holder<>(
			PlatformMyExample4265Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4265Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4265Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4265Controller> {

		public BcSupplier() {
			super(PlatformMyExample4265Controller.Holder);
		}

	}

}
