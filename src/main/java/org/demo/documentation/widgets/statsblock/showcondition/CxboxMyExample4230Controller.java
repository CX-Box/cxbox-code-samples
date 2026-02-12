package org.demo.documentation.widgets.statsblock.showcondition;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4230Controller implements EnumBcIdentifier {


	myexample4230(MyExample4230Service.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample4230Controller> Holder = new Holder<>(
			CxboxMyExample4230Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample4230Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample4230Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4230Controller> {

		public BcSupplier() {
			super(CxboxMyExample4230Controller.Holder);
		}

	}

}