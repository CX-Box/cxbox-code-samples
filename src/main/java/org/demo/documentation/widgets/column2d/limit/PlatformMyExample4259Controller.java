package org.demo.documentation.widgets.column2d.limit;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4259Controller implements EnumBcIdentifier {

	myExampleBc4259(MyExample4259Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4259Controller> Holder = new Holder<>(
			PlatformMyExample4259Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4259Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4259Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4259Controller> {

		public BcSupplier() {
			super(PlatformMyExample4259Controller.Holder);
		}

	}

}
