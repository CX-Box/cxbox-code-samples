package org.demo.documentation.widgets.relationGraph.incorrectdata;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6160Controller implements EnumBcIdentifier {

	myExampleBc6160(MyExample6160Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6160Controller> Holder = new Holder<>(
			PlatformMyExample6160Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6160Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6160Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6160Controller> {

		public BcSupplier() {
			super(PlatformMyExample6160Controller.Holder);
		}
	}
}
