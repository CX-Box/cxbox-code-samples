package org.demo.documentation.widgets.statsblock.color.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4206Controller implements EnumBcIdentifier {


	myExampleBc4206(MyExample4206Service.class);


	public static final EnumBcIdentifier.Holder<PlatformMyExample4206Controller> Holder = new Holder<>(
			PlatformMyExample4206Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4206Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4206Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4206Controller> {

		public BcSupplier() {
			super(PlatformMyExample4206Controller.Holder);
		}

	}

}