package org.demo.documentation.widgets.line2d.stack;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4244Controller implements EnumBcIdentifier {

	myExampleBc4244(MyExample4244Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4244Controller> Holder = new Holder<>(
			PlatformMyExample4244Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4244Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4244Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4244Controller> {

		public BcSupplier() {
			super(PlatformMyExample4244Controller.Holder);
		}
	}
}
