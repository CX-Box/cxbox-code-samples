package org.demo.documentation.widgets.line2d.pagelimit;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4251Controller implements EnumBcIdentifier {

	myExampleBc4251(MyExample4251Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4251Controller> Holder = new Holder<>(
			PlatformMyExample4251Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4251Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4251Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4251Controller> {

		public BcSupplier() {
			super(PlatformMyExample4251Controller.Holder);
		}
	}
}
