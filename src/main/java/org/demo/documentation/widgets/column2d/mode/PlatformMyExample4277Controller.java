package org.demo.documentation.widgets.column2d.mode;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4277Controller implements EnumBcIdentifier {

	myExampleBc4277(MyExample4277Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4277Controller> Holder = new Holder<>(
			PlatformMyExample4277Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4277Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4277Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4277Controller> {

		public BcSupplier() {
			super(PlatformMyExample4277Controller.Holder);
		}

	}

}
