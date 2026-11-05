package org.demo.documentation.widgets.relationGraph.nodes;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6155Controller implements EnumBcIdentifier {

	myExampleBc6155(MyExample6155Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6155Controller> Holder = new Holder<>(
			PlatformMyExample6155Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6155Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6155Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6155Controller> {

		public BcSupplier() {
			super(PlatformMyExample6155Controller.Holder);
		}
	}
}
