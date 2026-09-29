package org.demo.documentation.widgets.pie1d.drilldown.drilldown;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4219Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4219(MyExample4219Service.class),
	myExampleBc4219Sale(MyExample4219SaleService.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4219Controller> Holder = new Holder<>(
			PlatformMyExample4219Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4219Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4219Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4219Controller> {

		public BcSupplier() {
			super(PlatformMyExample4219Controller.Holder);
		}

	}

}
