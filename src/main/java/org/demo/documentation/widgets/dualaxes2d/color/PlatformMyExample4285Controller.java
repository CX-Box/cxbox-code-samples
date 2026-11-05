package org.demo.documentation.widgets.dualaxes2d.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4285Controller implements EnumBcIdentifier {

	myExampleBc4285(MyExample4285Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4285Controller> Holder = new Holder<>(
			PlatformMyExample4285Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4285Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4285Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4285Controller> {

		public BcSupplier() {
			super(PlatformMyExample4285Controller.Holder);
		}
	}
}
