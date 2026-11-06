package org.demo.documentation.widgets.relationGraph.showcondition;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6153Controller implements EnumBcIdentifier {

	myExampleBc6153Form(MyExample6153FormService.class),
	myExampleBc6153(MyExample6153Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6153Controller> Holder = new Holder<>(
			PlatformMyExample6153Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6153Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample6153Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6153Controller> {

		public BcSupplier() {
			super(PlatformMyExample6153Controller.Holder);
		}
	}
}
