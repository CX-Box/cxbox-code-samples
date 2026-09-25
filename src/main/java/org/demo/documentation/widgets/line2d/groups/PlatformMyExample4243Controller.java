package org.demo.documentation.widgets.line2d.groups;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4243Controller implements EnumBcIdentifier {

	myExampleBc4243(MyExample4243Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4243Controller> Holder = new Holder<>(
			PlatformMyExample4243Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4243Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4243Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4243Controller> {

		public BcSupplier() {
			super(PlatformMyExample4243Controller.Holder);
		}
	}
}
