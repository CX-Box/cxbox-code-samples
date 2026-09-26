package org.demo.documentation.widgets.column2d.title;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4253Controller implements EnumBcIdentifier {

	myExampleBc4253(MyExample4253Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample4253Controller> Holder = new Holder<>(
			PlatformMyExample4253Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4253Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4253Controller(Class<?> serviceClass) {
		this(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4253Controller> {

		public BcSupplier() {
			super(PlatformMyExample4253Controller.Holder);
		}

	}

}
