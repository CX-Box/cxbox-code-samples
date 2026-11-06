package org.demo.documentation.widgets.relationGraph.edges;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6156Controller implements EnumBcIdentifier {

	myExampleBc6156(MyExample6156Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6156Controller> Holder = new Holder<>(
			PlatformMyExample6156Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6156Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6156Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6156Controller> {

		public BcSupplier() {
			super(PlatformMyExample6156Controller.Holder);
		}
	}
}
