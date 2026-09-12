package org.demo.documentation.fields.picktree.validationdynamic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3294Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3294(MyExample3294Service.class),
	myEntity3294PickPickTreePopup(myExampleBc3294, MyEntity3294PickPickService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<PlatformMyExample3294Controller> Holder = new Holder<>(
			PlatformMyExample3294Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3294Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3294Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3294Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3294Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3294Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3294Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3294Controller> {

		public BcSupplier() {
			super(PlatformMyExample3294Controller.Holder);
		}

	}

}