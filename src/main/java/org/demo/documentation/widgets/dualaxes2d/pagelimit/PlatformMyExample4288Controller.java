package org.demo.documentation.widgets.dualaxes2d.pagelimit;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4288Controller implements EnumBcIdentifier {

	myExampleBc4288(MyExample4288Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4288Controller> Holder = new Holder<>(
			PlatformMyExample4288Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4288Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4288Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4288Controller> {

		public BcSupplier() {
			super(PlatformMyExample4288Controller.Holder);
		}
	}
}
