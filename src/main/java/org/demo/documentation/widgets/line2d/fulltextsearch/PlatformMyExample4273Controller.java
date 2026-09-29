package org.demo.documentation.widgets.line2d.fulltextsearch;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4273Controller implements EnumBcIdentifier {

	myExampleBc4273(MyExample4273Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4273Controller> Holder = new Holder<>(
			PlatformMyExample4273Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4273Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4273Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4273Controller> {

		public BcSupplier() {
			super(PlatformMyExample4273Controller.Holder);
		}
	}
}
