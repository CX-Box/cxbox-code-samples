package org.demo.documentation.widgets.assoctree.customizationcolumns;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3335Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3335(MyExample3335Service.class), myEntity3335AssocPick(myexample3335, MyEntity3335AssocPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3335Controller> Holder = new Holder<>(
			CxboxMyExample3335Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3335Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3335Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3335Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3335Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3335Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3335Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3335Controller> {

		public BcSupplier() {
			super(CxboxMyExample3335Controller.Holder);
		}

	}

}