package org.demo.documentation.widgets.column2d.showcondition;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4276Controller implements EnumBcIdentifier {

	myExampleBc4276Form(MyExample4276FormService.class),
	myExampleBc4276(MyExample4276Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4276Controller> Holder = new Holder<>(
			PlatformMyExample4276Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4276Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4276Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4276Controller> {

		public BcSupplier() {
			super(PlatformMyExample4276Controller.Holder);
		}

	}

}
