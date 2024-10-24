package org.demo.documentation.fields.number.additionalproperties.nullable;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample57Controller implements EnumBcIdentifier {

	
	// --8<-- [start:bc]
	myExampleBc57(MyExample57Service.class);
	// --8<-- [end:bc]
	


	public static final EnumBcIdentifier.Holder<PlatformMyExample57Controller> Holder = new Holder<>(
			PlatformMyExample57Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample57Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample57Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample57Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample57Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample57Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample57Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample57Controller> {

		public BcSupplier() {
			super(PlatformMyExample57Controller.Holder);
		}

	}

}