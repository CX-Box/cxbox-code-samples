package org.demo.documentation.widgets.ringprogress.drilldown.parentchild;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4212Controller implements EnumBcIdentifier {

	myExampleBc4212(MyExample4212Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4212Controller> Holder = new Holder<>(
			PlatformMyExample4212Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4212Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4212Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4212Controller> {

		public BcSupplier() {
			super(PlatformMyExample4212Controller.Holder);
		}
	}
}
