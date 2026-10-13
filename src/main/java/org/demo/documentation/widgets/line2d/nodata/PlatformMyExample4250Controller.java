package org.demo.documentation.widgets.line2d.nodata;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4250Controller implements EnumBcIdentifier {

	myExampleBc4250(MyExample4250Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4250Controller> Holder = new Holder<>(
			PlatformMyExample4250Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4250Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4250Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4250Controller> {

		public BcSupplier() {
			super(PlatformMyExample4250Controller.Holder);
		}
	}
}
