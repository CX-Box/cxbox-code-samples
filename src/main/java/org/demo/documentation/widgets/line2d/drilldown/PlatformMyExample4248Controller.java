package org.demo.documentation.widgets.line2d.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4248Controller implements EnumBcIdentifier {

	myExampleBc4248(MyExample4248Service.class),
	myExampleBc4248List(MyExample4248ListService.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4248Controller> Holder = new Holder<>(
			PlatformMyExample4248Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4248Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4248Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4248Controller> {

		public BcSupplier() {
			super(PlatformMyExample4248Controller.Holder);
		}
	}
}
