package org.demo.documentation.widgets.column2d.labelposition;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4278Controller implements EnumBcIdentifier {

	myExampleBc4278(MyExample4278Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4278Controller> Holder = new Holder<>(
			PlatformMyExample4278Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4278Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4278Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4278Controller> {

		public BcSupplier() {
			super(PlatformMyExample4278Controller.Holder);
		}

	}

}
