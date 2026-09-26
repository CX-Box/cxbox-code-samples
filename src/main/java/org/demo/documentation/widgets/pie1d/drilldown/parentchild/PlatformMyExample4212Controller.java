package org.demo.documentation.widgets.pie1d.drilldown.parentchild;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4212Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4212(MyExample4212Service.class),
	myExampleBc4212Sale(myExampleBc4212, MyExample4212SaleService.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4212Controller> Holder = new Holder<>(
			PlatformMyExample4212Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4212Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4212Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4212Controller> {

		public BcSupplier() {
			super(PlatformMyExample4212Controller.Holder);
		}

	}

}
