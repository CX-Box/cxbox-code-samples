package org.demo.documentation.widgets.line2d.filtergroup;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4274Controller implements EnumBcIdentifier {

	myExampleBc4274(MyExample4274Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4274Controller> Holder = new Holder<>(
			PlatformMyExample4274Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4274Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4274Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4274Controller> {

		public BcSupplier() {
			super(PlatformMyExample4274Controller.Holder);
		}
	}
}
