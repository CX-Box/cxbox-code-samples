package org.demo.documentation.widgets.relationGraph.base;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6151Controller implements EnumBcIdentifier {

	myExampleBc6151(MyExample6151Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6151Controller> Holder = new Holder<>(
			PlatformMyExample6151Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6151Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6151Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6151Controller> {

		public BcSupplier() {
			super(PlatformMyExample6151Controller.Holder);
		}
	}
}
