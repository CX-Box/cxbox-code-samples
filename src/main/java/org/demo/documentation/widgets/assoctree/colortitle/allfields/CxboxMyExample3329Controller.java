package org.demo.documentation.widgets.assoctree.colortitle.allfields;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiAssocMultivalueService;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiMultiAssocMultivalueService;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329PicklistAssocPickService;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329PicklistPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3329Controller implements EnumBcIdentifier {


	myexample3329(MyExample3329Service.class),
	myEntity3329MultiAssocTreePopup(myexample3329, MyEntity3329MultiMultivalueService.class),
	myEntity3329MultiAssocTreePopupColorConst(myexample3329, MyEntity3329MultiMultivalueService.class),
	myEntity3329PicklistAssocPickTreePopup(myEntity3329MultiAssocTreePopup, MyEntity3329PicklistAssocPickService.class),
	myEntity3329PicklistAssocPickTreePopupColorConst(myEntity3329MultiAssocTreePopupColorConst, MyEntity3329PicklistAssocPickService.class),
	myEntity3329PicklistPickTreePopupColorConst(myEntity3329MultiAssocTreePopupColorConst, MyEntity3329PicklistPickService.class),
	myEntity3329PicklistPickTreePopup(myEntity3329MultiAssocTreePopup, MyEntity3329PicklistPickService.class),
	myEntity3329MultiMultiAssocAssocTreePopupColorConst(myEntity3329MultiAssocTreePopup, MyEntity3329MultiMultiAssocMultivalueService.class),
	myEntity3329MultiAssocAssocTreePopup(myEntity3329MultiAssocTreePopup, MyEntity3329MultiAssocMultivalueService.class),
	myEntity3329MultiMultiAssocAssocTreePopup(myEntity3329MultiAssocTreePopup, MyEntity3329MultiAssocMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3329Controller> Holder = new Holder<>(
			CxboxMyExample3329Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3329Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3329Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3329Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3329Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3329Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3329Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3329Controller> {

		public BcSupplier() {
			super(CxboxMyExample3329Controller.Holder);
		}

	}

}