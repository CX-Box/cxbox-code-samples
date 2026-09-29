package org.demo.documentation.widgets.column2d.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4258Controller implements EnumBcIdentifier {

	myExampleBc4258(MyExample4258Service.class),
	myExampleBc4258Sale(MyExample4258SaleService.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4258Controller> Holder = new Holder<>(
			PlatformMyExample4258Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4258Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4258Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4258Controller> {

		public BcSupplier() {
			super(PlatformMyExample4258Controller.Holder);
		}

	}

}
