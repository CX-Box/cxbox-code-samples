package org.demo.documentation.fields.multivaluetree.validationconfirm;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3326Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3326(MyExample3326Service.class),
	myEntity3326MultivalueAssocTreePopup(myExampleBc3326, MyEntity3326MultivalueService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<PlatformMyExample3326Controller> Holder = new Holder<>(
			PlatformMyExample3326Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3326Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3326Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3326Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3326Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3326Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3326Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3326Controller> {

		public BcSupplier() {
			super(PlatformMyExample3326Controller.Holder);
		}

	}

}