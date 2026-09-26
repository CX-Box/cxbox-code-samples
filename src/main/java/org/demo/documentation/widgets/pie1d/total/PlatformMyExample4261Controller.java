package org.demo.documentation.widgets.pie1d.total;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4261Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4261(MyExample4261Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4261Controller> Holder = new Holder<>(
			PlatformMyExample4261Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4261Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4261Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4261Controller> {

		public BcSupplier() {
			super(PlatformMyExample4261Controller.Holder);
		}

	}

}
