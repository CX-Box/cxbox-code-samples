package org.demo.documentation.widgets.line2d.sorting;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4275Controller implements EnumBcIdentifier {

	myExampleBc4275(MyExample4275Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4275Controller> Holder = new Holder<>(
			PlatformMyExample4275Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4275Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4275Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4275Controller> {

		public BcSupplier() {
			super(PlatformMyExample4275Controller.Holder);
		}
	}
}
