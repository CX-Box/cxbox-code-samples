package org.demo.documentation.widgets.pie1d.drilldown.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4219Controller implements EnumBcIdentifier {

	myExampleBc4219(MyExample4219Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4219Controller> Holder = new Holder<>(
			PlatformMyExample4219Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4219Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4219Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4219Controller> {

		public BcSupplier() {
			super(PlatformMyExample4219Controller.Holder);
		}
	}
}
