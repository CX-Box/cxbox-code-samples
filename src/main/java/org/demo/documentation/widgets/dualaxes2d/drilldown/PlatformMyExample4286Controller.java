package org.demo.documentation.widgets.dualaxes2d.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4286Controller implements EnumBcIdentifier {

	myExampleBc4286(MyExample4286Service.class),
	myExampleBc4286List(MyExample4286ListService.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4286Controller> Holder = new Holder<>(
			PlatformMyExample4286Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4286Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4286Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4286Controller> {

		public BcSupplier() {
			super(PlatformMyExample4286Controller.Holder);
		}
	}
}
