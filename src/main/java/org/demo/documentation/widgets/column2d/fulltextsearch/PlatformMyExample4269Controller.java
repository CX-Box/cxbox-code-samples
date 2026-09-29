package org.demo.documentation.widgets.column2d.fulltextsearch;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4269Controller implements EnumBcIdentifier {

	myExampleBc4269(MyExample4269Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4269Controller> Holder = new Holder<>(
			PlatformMyExample4269Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4269Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4269Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4269Controller> {

		public BcSupplier() {
			super(PlatformMyExample4269Controller.Holder);
		}

	}

}
