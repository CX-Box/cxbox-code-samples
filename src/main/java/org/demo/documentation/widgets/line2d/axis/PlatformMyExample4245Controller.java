package org.demo.documentation.widgets.line2d.axis;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4245Controller implements EnumBcIdentifier {

	myExampleBc4245(MyExample4245Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4245Controller> Holder = new Holder<>(
			PlatformMyExample4245Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4245Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4245Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4245Controller> {

		public BcSupplier() {
			super(PlatformMyExample4245Controller.Holder);
		}
	}
}
