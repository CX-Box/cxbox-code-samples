package org.demo.documentation.widgets.pie1d.showcondition;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4215Controller implements EnumBcIdentifier {

	myExampleBc4215(MyExample4215Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4215Controller> Holder = new Holder<>(
			PlatformMyExample4215Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4215Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4215Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4215Controller> {

		public BcSupplier() {
			super(PlatformMyExample4215Controller.Holder);
		}
	}
}
