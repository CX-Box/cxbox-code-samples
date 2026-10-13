package org.demo.documentation.widgets.column2d.sorting;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4271Controller implements EnumBcIdentifier {

	myExampleBc4271(MyExample4271Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4271Controller> Holder = new Holder<>(
			PlatformMyExample4271Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4271Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4271Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4271Controller> {

		public BcSupplier() {
			super(PlatformMyExample4271Controller.Holder);
		}

	}

}
