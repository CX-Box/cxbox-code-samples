package org.demo.documentation.widgets.picklist.allpropertiesfield;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup.MyEntity3405PickListPopupPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3405Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3405(MyExample3405Service.class), myEntity3405PickListPopupPick(myexample3405, MyEntity3405PickListPopupPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3405Controller> Holder = new Holder<>(
			CxboxMyExample3405Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3405Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3405Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3405Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3405Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3405Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3405Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3405Controller> {

		public BcSupplier() {
			super(CxboxMyExample3405Controller.Holder);
		}

	}

}