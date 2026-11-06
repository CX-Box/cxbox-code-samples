package org.demo.documentation.widgets.relationGraph.dragnode;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6162Controller implements EnumBcIdentifier {

	myExampleBc6162(MyExample6162Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6162Controller> Holder = new Holder<>(
			PlatformMyExample6162Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6162Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6162Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6162Controller> {

		public BcSupplier() {
			super(PlatformMyExample6162Controller.Holder);
		}
	}
}
