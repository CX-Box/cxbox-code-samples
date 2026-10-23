package org.demo.documentation.widgets.line2d.filtration;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4272Controller implements EnumBcIdentifier {

	myExampleBc4272(MyExample4272Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4272Controller> Holder = new Holder<>(
			PlatformMyExample4272Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4272Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4272Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4272Controller> {

		public BcSupplier() {
			super(PlatformMyExample4272Controller.Holder);
		}
	}
}
