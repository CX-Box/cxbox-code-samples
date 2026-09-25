package org.demo.documentation.widgets.line2d.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4247Controller implements EnumBcIdentifier {

	myExampleBc4247(MyExample4247Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4247Controller> Holder = new Holder<>(
			PlatformMyExample4247Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4247Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4247Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4247Controller> {

		public BcSupplier() {
			super(PlatformMyExample4247Controller.Holder);
		}
	}
}
