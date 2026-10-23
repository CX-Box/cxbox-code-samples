package org.demo.documentation.widgets.column2d.tooltip;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4256Controller implements EnumBcIdentifier {

	myExampleBc4256(MyExample4256Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4256Controller> Holder = new Holder<>(
			PlatformMyExample4256Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4256Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4256Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4256Controller> {

		public BcSupplier() {
			super(PlatformMyExample4256Controller.Holder);
		}

	}

}
