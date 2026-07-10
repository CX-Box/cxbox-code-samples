package org.demo.documentation.widgets.ringprogress.fieldslayoute;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4213Controller implements EnumBcIdentifier {

	myExampleBc4213(MyExample4213Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4213Controller> Holder = new Holder<>(
			PlatformMyExample4213Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4213Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4213Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4213Controller> {

		public BcSupplier() {
			super(PlatformMyExample4213Controller.Holder);
		}
	}
}
