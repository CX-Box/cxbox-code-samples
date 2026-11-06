package org.demo.documentation.widgets.dualaxes2d.tablemode;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4287Controller implements EnumBcIdentifier {

	myExampleBc4287(MyExample4287Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4287Controller> Holder = new Holder<>(
			PlatformMyExample4287Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4287Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4287Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4287Controller> {

		public BcSupplier() {
			super(PlatformMyExample4287Controller.Holder);
		}
	}
}
