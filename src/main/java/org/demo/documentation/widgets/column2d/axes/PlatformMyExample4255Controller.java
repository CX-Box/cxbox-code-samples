package org.demo.documentation.widgets.column2d.axes;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4255Controller implements EnumBcIdentifier {

	myExampleBc4255(MyExample4255Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4255Controller> Holder = new Holder<>(
			PlatformMyExample4255Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4255Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4255Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4255Controller> {

		public BcSupplier() {
			super(PlatformMyExample4255Controller.Holder);
		}

	}

}
