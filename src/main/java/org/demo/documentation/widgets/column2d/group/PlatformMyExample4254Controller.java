package org.demo.documentation.widgets.column2d.group;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4254Controller implements EnumBcIdentifier {

	myExampleBc4254(MyExample4254Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4254Controller> Holder = new Holder<>(
			PlatformMyExample4254Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4254Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4254Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4254Controller> {

		public BcSupplier() {
			super(PlatformMyExample4254Controller.Holder);
		}

	}

}
