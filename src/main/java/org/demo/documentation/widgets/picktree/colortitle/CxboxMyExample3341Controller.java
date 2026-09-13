package org.demo.documentation.widgets.picktree.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMultiMultivalueService;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMultivalueService;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342PickPickPickService;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3341Controller implements EnumBcIdentifier {


	myexample3341(MyExample3341Service.class),
	myEntity3342PickTreePopup(myexample3341, MyEntity3342PickService.class),
	myEntity3342PickTreePopupColorConst(myexample3341, MyEntity3342PickService.class),
	myEntity3342PickPickPickTreePopup(myEntity3342PickTreePopup, MyEntity3342PickPickPickService.class),
	myEntity3342PickPickPickTreePopupColorConst(myEntity3342PickTreePopupColorConst, MyEntity3342PickPickPickService.class),
	myEntity3342PickPickTreePopupCC(myEntity3342PickTreePopupColorConst, MyEntity3342PickPickService.class),
	myEntity3342PickPickTreePopup(myEntity3342PickTreePopup, MyEntity3342PickPickService.class),
	myEntity3342MultiMultiAssocTreePopup(myEntity3342PickTreePopup, MyEntity3342MultiMultiMultivalueService.class),
	myEntity3342MultiAssocTreePopup(myEntity3342PickTreePopup, MyEntity3342MultiMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3341Controller> Holder = new Holder<>(
			CxboxMyExample3341Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3341Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3341Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3341Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3341Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3341Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3341Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3341Controller> {

		public BcSupplier() {
			super(CxboxMyExample3341Controller.Holder);
		}

	}

}