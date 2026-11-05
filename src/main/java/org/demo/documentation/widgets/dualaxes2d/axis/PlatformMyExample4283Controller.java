package org.demo.documentation.widgets.dualaxes2d.axis;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4283Controller implements EnumBcIdentifier {

	myExampleBc4283(MyExample4283Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4283Controller> Holder = new Holder<>(
			PlatformMyExample4283Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4283Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4283Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4283Controller> {

		public BcSupplier() {
			super(PlatformMyExample4283Controller.Holder);
		}
	}
}
