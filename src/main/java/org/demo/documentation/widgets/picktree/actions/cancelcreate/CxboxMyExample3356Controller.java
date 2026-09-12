package org.demo.documentation.widgets.picktree.actions.cancelcreate;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.basic.MyEntity3356PickPickService;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.oncancel.MyEntity3356PickOnCancelPickService;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.postaction.MyEntity3356PickPostActionPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3356Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3356(MyExample3356Service.class),
	myEntity3356PickPostActionPick(myexample3356, MyEntity3356PickPostActionPickService.class),
	myEntity3356PickOnCancelPick(myexample3356, MyEntity3356PickOnCancelPickService.class),
	myEntity3356PickPick(myexample3356, MyEntity3356PickPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3356Controller> Holder = new Holder<>(
			CxboxMyExample3356Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3356Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3356Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3356Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3356Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3356Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3356Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3356Controller> {

		public BcSupplier() {
			super(CxboxMyExample3356Controller.Holder);
		}

	}

}