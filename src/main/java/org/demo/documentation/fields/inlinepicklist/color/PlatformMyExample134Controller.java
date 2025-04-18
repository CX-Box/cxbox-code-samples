package org.demo.documentation.fields.inlinepicklist.color;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample134Controller implements EnumBcIdentifier {

	
	// --8<-- [start:bc]
	myExampleBc134(MyExample134Service.class),
	myEntity135PickListPopup(myExampleBc134, MyEntity135PickPickListService.class);
	// --8<-- [end:bc]
	
	

	public static final EnumBcIdentifier.Holder<PlatformMyExample134Controller> Holder = new Holder<>(
			PlatformMyExample134Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample134Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample134Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample134Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample134Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample134Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample134Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample134Controller> {

		public BcSupplier() {
			super(PlatformMyExample134Controller.Holder);
		}

	}

}