package org.demo.documentation.widgets.pie1d.icon;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4214Controller implements EnumBcIdentifier {

	myExampleBc4214(MyExample4214Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4214Controller> Holder = new Holder<>(
			PlatformMyExample4214Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4214Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4214Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4214Controller> {

		public BcSupplier() {
			super(PlatformMyExample4214Controller.Holder);
		}
	}
}
