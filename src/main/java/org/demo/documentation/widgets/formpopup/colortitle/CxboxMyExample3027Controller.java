package org.demo.documentation.widgets.formpopup.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041MultivalueService;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042MultivalueService;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3043PickService;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3044PickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3027Controller implements EnumBcIdentifier {


	myexample3027(MyExample3027Service.class), myEntity3044PickListPopup(myexample3027, MyEntity3044PickService.class), myEntity3043PickListPopup(myexample3027, MyEntity3043PickService.class), myEntity3042AssocListPopup(myexample3027, MyEntity3042MultivalueService.class), myEntity3041AssocListPopup(myexample3027, MyEntity3041MultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3027Controller> Holder = new Holder<>(
			CxboxMyExample3027Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3027Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3027Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3027Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3027Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3027Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3027Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3027Controller> {

		public BcSupplier() {
			super(CxboxMyExample3027Controller.Holder);
		}

	}

}