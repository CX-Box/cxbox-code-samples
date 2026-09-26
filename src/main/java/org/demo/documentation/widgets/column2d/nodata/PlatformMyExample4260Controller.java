package org.demo.documentation.widgets.column2d.nodata;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4260Controller implements EnumBcIdentifier {

	myExampleBc4260(MyExample4260Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4260Controller> Holder = new Holder<>(
			PlatformMyExample4260Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4260Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4260Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4260Controller> {

		public BcSupplier() {
			super(PlatformMyExample4260Controller.Holder);
		}

	}

}
