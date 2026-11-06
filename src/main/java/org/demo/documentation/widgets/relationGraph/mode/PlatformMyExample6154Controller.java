package org.demo.documentation.widgets.relationGraph.mode;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6154Controller implements EnumBcIdentifier {

	myExampleBc6154(MyExample6154Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6154Controller> Holder = new Holder<>(
			PlatformMyExample6154Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6154Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6154Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6154Controller> {

		public BcSupplier() {
			super(PlatformMyExample6154Controller.Holder);
		}
	}
}
