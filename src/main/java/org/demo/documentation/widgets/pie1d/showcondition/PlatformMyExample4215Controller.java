package org.demo.documentation.widgets.pie1d.showcondition;

import lombok.Getter;
import org.demo.documentation.widgets.pie1d.showcondition.parent.MyExample4215ParentService;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4215Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myExampleBc4215Parent(MyExample4215ParentService.class),
	myExampleBc4215(myExampleBc4215Parent, MyExample4215Service.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<PlatformMyExample4215Controller> Holder = new Holder<>(
			PlatformMyExample4215Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4215Controller(BcIdentifier parent, Class<?> serviceClass) {
		this.bcDescription = buildDescription(parent == null ? null : parent.getName(), serviceClass, false);
	}

	PlatformMyExample4215Controller(Class<?> serviceClass) {
		this(null, serviceClass);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4215Controller> {

		public BcSupplier() {
			super(PlatformMyExample4215Controller.Holder);
		}

	}

}
