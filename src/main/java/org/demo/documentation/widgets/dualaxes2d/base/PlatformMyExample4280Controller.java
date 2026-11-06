package org.demo.documentation.widgets.dualaxes2d.base;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4280Controller implements EnumBcIdentifier {

	myExampleBc4280(MyExample4280Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4280Controller> Holder = new Holder<>(
			PlatformMyExample4280Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4280Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4280Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4280Controller> {

		public BcSupplier() {
			super(PlatformMyExample4280Controller.Holder);
		}
	}
}
