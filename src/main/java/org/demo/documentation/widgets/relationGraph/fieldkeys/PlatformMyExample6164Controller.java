package org.demo.documentation.widgets.relationGraph.fieldkeys;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6164Controller implements EnumBcIdentifier {

	myExampleBc6164(MyExample6164Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6164Controller> Holder = new Holder<>(
			PlatformMyExample6164Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6164Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6164Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6164Controller> {

		public BcSupplier() {
			super(PlatformMyExample6164Controller.Holder);
		}
	}
}
