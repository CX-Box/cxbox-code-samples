package org.demo.documentation.widgets.dualaxes2d.title;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4281Controller implements EnumBcIdentifier {

	myExampleBc4281(MyExample4281Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4281Controller> Holder = new Holder<>(
			PlatformMyExample4281Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4281Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4281Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4281Controller> {

		public BcSupplier() {
			super(PlatformMyExample4281Controller.Holder);
		}
	}
}
