package org.demo.documentation.widgets.picklist.actions.edit;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.inlinepicklist.MyEntity3092PickPick0Service;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.picklist.MyEntity3092PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3092Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3092(MyExample3092Service.class),
	myEntity3092InlinePickListInline(myexample3092, MyEntity3092PickPick0Service.class),
	myEntity3092InlinePickListInlineForm(myexample3092, MyEntity3092PickPick0Service.class),
	myEntity3092PickInline(myexample3092, MyEntity3092PickPickService.class),
	myEntity3092PickInlineForm(myexample3092, MyEntity3092PickPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3092Controller> Holder = new Holder<>(
			CxboxMyExample3092Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3092Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3092Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3092Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3092Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3092Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3092Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3092Controller> {

		public BcSupplier() {
			super(CxboxMyExample3092Controller.Holder);
		}

	}

}