package org.demo.documentation.widgets.column2d.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4257Controller implements EnumBcIdentifier {

	myExampleBc4257(MyExample4257Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4257Controller> Holder = new Holder<>(
			PlatformMyExample4257Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4257Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4257Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4257Controller> {

		public BcSupplier() {
			super(PlatformMyExample4257Controller.Holder);
		}

	}

}
