package org.demo.documentation.widgets.line2d.tooltip;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4246Controller implements EnumBcIdentifier {

	myExampleBc4246(MyExample4246Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4246Controller> Holder = new Holder<>(
			PlatformMyExample4246Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4246Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4246Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4246Controller> {

		public BcSupplier() {
			super(PlatformMyExample4246Controller.Holder);
		}
	}
}
