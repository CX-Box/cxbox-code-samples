package org.demo.documentation.widgets.line2d.base;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4240Controller implements EnumBcIdentifier {

	myExampleBc4240(MyExample4240Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4240Controller> Holder = new Holder<>(
			PlatformMyExample4240Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4240Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4240Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4240Controller> {

		public BcSupplier() {
			super(PlatformMyExample4240Controller.Holder);
		}
	}
}
