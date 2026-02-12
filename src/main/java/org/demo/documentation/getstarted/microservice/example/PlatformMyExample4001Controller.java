package org.demo.documentation.getstarted.microservice.example;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4001Controller implements EnumBcIdentifier {


	myExampleBc4001(MyExample4001Service.class);


	public static final EnumBcIdentifier.Holder<PlatformMyExample4001Controller> Holder = new Holder<>(
			PlatformMyExample4001Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4001Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4001Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4001Controller> {

		public BcSupplier() {
			super(PlatformMyExample4001Controller.Holder);
		}

	}

}