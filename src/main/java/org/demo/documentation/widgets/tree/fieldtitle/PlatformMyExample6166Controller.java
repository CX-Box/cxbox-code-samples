package org.demo.documentation.widgets.tree.fieldtitle;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample6166Controller implements EnumBcIdentifier {

	myexample6166(MyExample6166Service.class);

	public static final EnumBcIdentifier.Holder<PlatformMyExample6166Controller> Holder = new Holder<>(
			PlatformMyExample6166Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample6166Controller(Class<?> serviceClass) {
		this.bcDescription = buildDescription(null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample6166Controller> {

		public BcSupplier() {
			super(PlatformMyExample6166Controller.Holder);
		}

	}

}
