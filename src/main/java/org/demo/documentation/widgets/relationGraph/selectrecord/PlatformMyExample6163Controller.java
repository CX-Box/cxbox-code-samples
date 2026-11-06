package org.demo.documentation.widgets.relationGraph.selectrecord;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6163Controller implements EnumBcIdentifier {

	myExampleBc6163(MyExample6163Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6163Controller> Holder = new Holder<>(
			PlatformMyExample6163Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6163Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6163Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6163Controller> {

		public BcSupplier() {
			super(PlatformMyExample6163Controller.Holder);
		}
	}
}
