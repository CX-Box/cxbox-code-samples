package org.demo.documentation.getstarted.microservice.document;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4003Controller implements EnumBcIdentifier {


	myExampleBc4003(MyExample4003Service.class);


	public static final EnumBcIdentifier.Holder<PlatformMyExample4003Controller> Holder = new Holder<>(
			PlatformMyExample4003Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4003Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4003Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4003Controller> {

		public BcSupplier() {
			super(PlatformMyExample4003Controller.Holder);
		}

	}

}