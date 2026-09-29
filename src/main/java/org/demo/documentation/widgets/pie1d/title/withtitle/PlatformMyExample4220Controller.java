package org.demo.documentation.widgets.pie1d.title.withtitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4220Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4220(MyExample4220Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4220Controller> Holder = new Holder<>(
			PlatformMyExample4220Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4220Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4220Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4220Controller> {

		public BcSupplier() {
			super(PlatformMyExample4220Controller.Holder);
		}

	}

}
