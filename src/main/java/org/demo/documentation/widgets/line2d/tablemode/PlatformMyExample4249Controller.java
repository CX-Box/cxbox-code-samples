package org.demo.documentation.widgets.line2d.tablemode;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4249Controller implements EnumBcIdentifier {

	myExampleBc4249(MyExample4249Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4249Controller> Holder = new Holder<>(
			PlatformMyExample4249Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4249Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4249Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4249Controller> {

		public BcSupplier() {
			super(PlatformMyExample4249Controller.Holder);
		}
	}
}
