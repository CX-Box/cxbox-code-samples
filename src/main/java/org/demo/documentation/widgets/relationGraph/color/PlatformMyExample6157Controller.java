package org.demo.documentation.widgets.relationGraph.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6157Controller implements EnumBcIdentifier {

	myExampleBc6157(MyExample6157Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6157Controller> Holder = new Holder<>(
			PlatformMyExample6157Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6157Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6157Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6157Controller> {

		public BcSupplier() {
			super(PlatformMyExample6157Controller.Holder);
		}
	}
}
