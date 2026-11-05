package org.demo.documentation.widgets.dualaxes2d.tooltip;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4284Controller implements EnumBcIdentifier {

	myExampleBc4284(MyExample4284Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4284Controller> Holder = new Holder<>(
			PlatformMyExample4284Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4284Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4284Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4284Controller> {

		public BcSupplier() {
			super(PlatformMyExample4284Controller.Holder);
		}
	}
}
