package org.demo.documentation.widgets.ringprogress.base.customfields;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4211Controller implements EnumBcIdentifier {

	myExampleBc4211(MyExample4211Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4211Controller> Holder = new Holder<>(
			PlatformMyExample4211Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4211Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4211Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4211Controller> {

		public BcSupplier() {
			super(PlatformMyExample4211Controller.Holder);
		}
	}
}
