package org.demo.documentation.widgets.column2d.filtration;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4268Controller implements EnumBcIdentifier {

	myExampleBc4268(MyExample4268Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4268Controller> Holder = new Holder<>(
			PlatformMyExample4268Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4268Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4268Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4268Controller> {

		public BcSupplier() {
			super(PlatformMyExample4268Controller.Holder);
		}

	}

}
