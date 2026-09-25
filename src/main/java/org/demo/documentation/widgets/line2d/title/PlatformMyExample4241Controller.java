package org.demo.documentation.widgets.line2d.title;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4241Controller implements EnumBcIdentifier {

	myExampleBc4241(MyExample4241Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4241Controller> Holder = new Holder<>(
			PlatformMyExample4241Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4241Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4241Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4241Controller> {

		public BcSupplier() {
			super(PlatformMyExample4241Controller.Holder);
		}
	}
}
