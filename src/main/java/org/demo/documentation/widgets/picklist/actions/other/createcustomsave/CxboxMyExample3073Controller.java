package org.demo.documentation.widgets.picklist.actions.other.createcustomsave;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3073Controller implements EnumBcIdentifier {


	myexample3073(MyExample3073Service.class), myEntity3073PickPickListPopup(myexample3073, MyEntity3073PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3073Controller> Holder = new Holder<>(
			CxboxMyExample3073Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3073Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3073Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3073Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3073Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3073Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3073Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3073Controller> {

		public BcSupplier() {
			super(CxboxMyExample3073Controller.Holder);
		}

	}

}