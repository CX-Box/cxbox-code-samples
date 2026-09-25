package org.demo.documentation.widgets.line2d.showcondition;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4242Controller implements EnumBcIdentifier {

	myExampleBc4242Form(MyExample4242FormService.class),
	myExampleBc4242(MyExample4242Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4242Controller> Holder = new Holder<>(
			PlatformMyExample4242Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4242Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4242Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4242Controller> {

		public BcSupplier() {
			super(PlatformMyExample4242Controller.Holder);
		}
	}
}
