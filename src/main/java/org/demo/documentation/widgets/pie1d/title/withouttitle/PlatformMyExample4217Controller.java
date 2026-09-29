package org.demo.documentation.widgets.pie1d.title.withouttitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4217Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4217(MyExample4217Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4217Controller> Holder = new Holder<>(
			PlatformMyExample4217Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4217Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4217Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4217Controller> {

		public BcSupplier() {
			super(PlatformMyExample4217Controller.Holder);
		}

	}

}
