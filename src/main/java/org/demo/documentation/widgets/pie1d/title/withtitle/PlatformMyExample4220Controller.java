package org.demo.documentation.widgets.pie1d.title.withtitle;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4220Controller implements EnumBcIdentifier {

	myExampleBc4220(MyExample4220Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4220Controller> Holder = new Holder<>(
			PlatformMyExample4220Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4220Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4220Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4220Controller> {

		public BcSupplier() {
			super(PlatformMyExample4220Controller.Holder);
		}
	}
}
