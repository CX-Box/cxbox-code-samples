package org.demo.documentation.widgets.picklist.fieldslayoute;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3070Controller implements EnumBcIdentifier {


	myexample3070(MyExample3070Service.class),
	myEntity3070PickPickListPopup(myexample3070, MyEntity3070PickPickService.class),
	myEntity3070PickPickListPopup6(myexample3070, MyEntity3070PickPickService.class),
	myEntity3070PickPickListPopup12(myexample3070, MyEntity3070PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3070Controller> Holder = new Holder<>(
			CxboxMyExample3070Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3070Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3070Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3070Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3070Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3070Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3070Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3070Controller> {

		public BcSupplier() {
			super(CxboxMyExample3070Controller.Holder);
		}

	}

}