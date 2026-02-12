package org.demo.documentation.widgets.picklist.actions.other.createwithparent;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3074Controller implements EnumBcIdentifier {


	myexample3074(MyExample3074Service.class), myEntity3074PickPickListPopup(myexample3074, MyEntity3074PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3074Controller> Holder = new Holder<>(
			CxboxMyExample3074Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3074Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3074Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3074Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3074Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3074Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3074Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3074Controller> {

		public BcSupplier() {
			super(CxboxMyExample3074Controller.Holder);
		}

	}

}