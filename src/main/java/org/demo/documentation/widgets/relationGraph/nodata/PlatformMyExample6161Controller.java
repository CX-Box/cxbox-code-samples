package org.demo.documentation.widgets.relationGraph.nodata;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6161Controller implements EnumBcIdentifier {

	myExampleBc6161(MyExample6161Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6161Controller> Holder = new Holder<>(
			PlatformMyExample6161Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6161Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6161Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6161Controller> {

		public BcSupplier() {
			super(PlatformMyExample6161Controller.Holder);
		}
	}
}
