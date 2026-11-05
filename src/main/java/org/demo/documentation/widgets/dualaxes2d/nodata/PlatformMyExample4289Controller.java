package org.demo.documentation.widgets.dualaxes2d.nodata;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4289Controller implements EnumBcIdentifier {

	myExampleBc4289(MyExample4289Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4289Controller> Holder = new Holder<>(
			PlatformMyExample4289Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4289Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4289Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4289Controller> {

		public BcSupplier() {
			super(PlatformMyExample4289Controller.Holder);
		}
	}
}
