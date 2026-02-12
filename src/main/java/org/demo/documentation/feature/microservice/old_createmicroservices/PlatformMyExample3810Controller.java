package org.demo.documentation.feature.microservice.old_createmicroservices;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3810Controller implements EnumBcIdentifier {


	myExampleBc3810(MyExample3810Service.class);


	public static final EnumBcIdentifier.Holder<PlatformMyExample3810Controller> Holder = new Holder<>(
			PlatformMyExample3810Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3810Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3810Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3810Controller> {

		public BcSupplier() {
			super(PlatformMyExample3810Controller.Holder);
		}

	}

}