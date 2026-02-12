package org.demo.documentation.widgets.assoc.customizationcolumns;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3078Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3078(MyExample3078Service.class), myEntity3078AssocPick(myexample3078, MyEntity3078AssocPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3078Controller> Holder = new Holder<>(
			CxboxMyExample3078Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3078Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3078Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3078Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3078Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3078Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3078Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3078Controller> {

		public BcSupplier() {
			super(CxboxMyExample3078Controller.Holder);
		}

	}

}