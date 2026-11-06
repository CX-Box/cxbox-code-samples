package org.demo.documentation.widgets.dualaxes2d.showcondition;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4282Controller implements EnumBcIdentifier {

	myExampleBc4282Form(MyExample4282FormService.class),
	myExampleBc4282(MyExample4282Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4282Controller> Holder = new Holder<>(
			PlatformMyExample4282Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4282Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4282Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4282Controller> {

		public BcSupplier() {
			super(PlatformMyExample4282Controller.Holder);
		}
	}
}
