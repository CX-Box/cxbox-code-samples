package org.demo.documentation.widgets.list.fieldtitle;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6165Controller implements EnumBcIdentifier {

	myexample6165(MyExample6165Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6165Controller> Holder = new Holder<>(
			PlatformMyExample6165Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6165Controller(Class<?> serviceClass) {
		this.bcDescription = buildDescription(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6165Controller> {

		public BcSupplier() {
			super(PlatformMyExample6165Controller.Holder);
		}

	}

}
