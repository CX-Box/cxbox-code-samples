package org.demo.documentation.widgets.pie1d.title.withouttitle;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4217Controller implements EnumBcIdentifier {

	myExampleBc4217(MyExample4217Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4217Controller> Holder = new Holder<>(
			PlatformMyExample4217Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4217Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4217Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4217Controller> {

		public BcSupplier() {
			super(PlatformMyExample4217Controller.Holder);
		}
	}
}
