package org.demo.documentation.widgets.column2d.base;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4252Controller implements EnumBcIdentifier {

	myExampleBc4252(MyExample4252Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4252Controller> Holder = new Holder<>(
			PlatformMyExample4252Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4252Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4252Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4252Controller> {

		public BcSupplier() {
			super(PlatformMyExample4252Controller.Holder);
		}

	}

}
