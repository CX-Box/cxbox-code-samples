package org.demo.documentation.widgets.picklist.title.withtitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3068Controller implements EnumBcIdentifier {


	myexample3068(MyExample3068Service.class),
	myEntity3068PickPickListPopup(myexample3068, MyEntity3068PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3068Controller> Holder = new Holder<>(
			CxboxMyExample3068Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3068Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3068Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3068Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3068Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3068Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3068Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3068Controller> {

		public BcSupplier() {
			super(CxboxMyExample3068Controller.Holder);
		}

	}

}