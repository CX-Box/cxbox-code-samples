package org.demo.documentation.other.action;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;

import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum PlatformMyExample6110Controller implements EnumBcIdentifier {

	myExampleBc6110(MyExampleBc6110Service.class)
	;

	public static final Holder<PlatformMyExample6110Controller> Holder = new EnumBcIdentifier.Holder<>(PlatformMyExample6110Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6110Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6110Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample6110Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample6110Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample6110Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample6110Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6110Controller> {

		public BcSupplier() {
			super(PlatformMyExample6110Controller.Holder);
		}

	}
}
