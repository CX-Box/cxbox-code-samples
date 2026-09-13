package org.demo.documentation.widgets.picktree.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.base.allfields.MyEntity3343MultiPickService;
import org.demo.documentation.widgets.picktree.base.allfields.MyExample3343Service;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343MultiMultiMultivalueService;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343MultiMultivalueService;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343PickInlinePicktreePickService;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343PickPicktreePickService;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.picktree.MyEntity3343PickPick0Service;
import org.demo.documentation.widgets.picktree.base.onefield.MyExample3351Service;
import org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.picktree.MyEntity3351PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3343Controller implements EnumBcIdentifier {


	myexample3351(MyExample3351Service.class),
	myEntity3351PickPick(myexample3351, MyEntity3351PickPickService.class),
	myexample3343(MyExample3343Service.class), myEntity3343MultiPick(myexample3343, MyEntity3343MultiPickService.class),
	myEntity3343PickPick(myexample3343, MyEntity3343PickPick0Service.class),
	myEntity3343PickPickPopup(myEntity3343PickPick, MyEntity3343PickPicktreePickService.class),
	myEntity3343PickPickTreePopup(myexample3343, MyEntity3343PickPick0Service.class),
	myEntity3343PickPicktreePickTreePopup(myEntity3343PickPickTreePopup, MyEntity3343PickPicktreePickService.class),
	myEntity3343PickInlinePicktreePickTreePopup(myEntity3343PickPickTreePopup, MyEntity3343PickInlinePicktreePickService.class),
	myEntity3343PickInlinePicktreePickTreePopup2(myEntity3343PickPick, MyEntity3343PickInlinePicktreePickService.class),
	myEntity3343PickPicktreePickTreePopup2(myEntity3343PickPick, MyEntity3343PickPicktreePickService.class),
	myEntity3343MultiAssocTreePopup(myEntity3343PickPickTreePopup, MyEntity3343MultiMultivalueService.class), myEntity3343MultiMultiAssocTreePopup(myEntity3343PickPickTreePopup, MyEntity3343MultiMultiMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3343Controller> Holder = new Holder<>(
			CxboxMyExample3343Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3343Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3343Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3343Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3343Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3343Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3343Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3343Controller> {

		public BcSupplier() {
			super(CxboxMyExample3343Controller.Holder);
		}

	}

}