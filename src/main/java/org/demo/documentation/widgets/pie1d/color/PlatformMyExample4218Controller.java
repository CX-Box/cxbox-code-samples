package org.demo.documentation.widgets.pie1d.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4218Controller implements EnumBcIdentifier {

	myExampleBc4218(MyExample4218Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4218Controller> Holder = new Holder<>(
			PlatformMyExample4218Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4218Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4218Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4218Controller> {

		public BcSupplier() {
			super(PlatformMyExample4218Controller.Holder);
		}
	}
}
