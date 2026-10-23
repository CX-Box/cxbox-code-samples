package org.demo.documentation.widgets.column2d.filtergroup;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4270Controller implements EnumBcIdentifier {

	myExampleBc4270(MyExample4270Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4270Controller> Holder = new Holder<>(
			PlatformMyExample4270Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4270Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4270Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4270Controller> {

		public BcSupplier() {
			super(PlatformMyExample4270Controller.Holder);
		}

	}

}
