package org.demo.documentation.fields.picktree.sorting;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3290Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3290(MyExample3290Service.class),
	myEntity3290PickTreePopup(myExampleBc3290, MyEntity3290PickPickTreeService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<PlatformMyExample3290Controller> Holder = new Holder<>(
			PlatformMyExample3290Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3290Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3290Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3290Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3290Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3290Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3290Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3290Controller> {

		public BcSupplier() {
			super(PlatformMyExample3290Controller.Holder);
		}

	}

}