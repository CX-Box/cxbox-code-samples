package org.demo.documentation.widgets.relationGraph.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6158Controller implements EnumBcIdentifier {

	myExampleBc6158(MyExample6158Service.class),
	myExampleBc6158Company(MyExample6158CompanyService.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6158Controller> Holder = new Holder<>(
			PlatformMyExample6158Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6158Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6158Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6158Controller> {

		public BcSupplier() {
			super(PlatformMyExample6158Controller.Holder);
		}
	}
}
