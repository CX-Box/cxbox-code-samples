package org.demo.documentation.widgets.relationGraph.expand;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6159Controller implements EnumBcIdentifier {

	myExampleBc6159(MyExample6159Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6159Controller> Holder = new Holder<>(
			PlatformMyExample6159Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6159Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6159Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6159Controller> {

		public BcSupplier() {
			super(PlatformMyExample6159Controller.Holder);
		}
	}
}
