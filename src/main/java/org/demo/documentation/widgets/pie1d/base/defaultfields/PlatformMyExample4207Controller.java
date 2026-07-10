package org.demo.documentation.widgets.pie1d.base.defaultfields;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4207Controller implements EnumBcIdentifier {

	myExampleBc4207(MyExample4207Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4207Controller> Holder = new Holder<>(
			PlatformMyExample4207Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4207Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4207Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4207Controller> {

		public BcSupplier() {
			super(PlatformMyExample4207Controller.Holder);
		}
	}
}
