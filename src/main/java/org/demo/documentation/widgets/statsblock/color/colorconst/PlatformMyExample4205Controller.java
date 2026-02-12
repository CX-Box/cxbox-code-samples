package org.demo.documentation.widgets.statsblock.color.colorconst;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4205Controller implements EnumBcIdentifier {


	myExampleBc4205(MyExample4205Service.class);


	public static final EnumBcIdentifier.Holder<PlatformMyExample4205Controller> Holder = new Holder<>(
			PlatformMyExample4205Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4205Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4205Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4205Controller> {

		public BcSupplier() {
			super(PlatformMyExample4205Controller.Holder);
		}

	}

}