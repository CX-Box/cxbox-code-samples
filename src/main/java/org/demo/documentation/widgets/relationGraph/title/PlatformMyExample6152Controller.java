package org.demo.documentation.widgets.relationGraph.title;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6152Controller implements EnumBcIdentifier {

	myExampleBc6152(MyExample6152Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6152Controller> Holder = new Holder<>(
			PlatformMyExample6152Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6152Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6152Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6152Controller> {

		public BcSupplier() {
			super(PlatformMyExample6152Controller.Holder);
		}
	}
}
