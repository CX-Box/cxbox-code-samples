package org.demo.documentation.widgets.tree.customizationcolumns;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268InlinePickPickService;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268MultiHoverMultivalueService;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268MultiMultivalueService;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3268Controller implements EnumBcIdentifier {


	myexample3268(MyExample3268Service.class), myEntity3268MultiAssocTreePopup(myexample3268, MyEntity3268MultiMultivalueService.class),
	myEntity3268PickPickTreePopup(myexample3268, MyEntity3268PickPickService.class),
	myEntity3268InlinePickPickTreePopup(myexample3268, MyEntity3268InlinePickPickService.class),
	myEntity3268MultiHoverAssocTreePopup(myexample3268, MyEntity3268MultiHoverMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3268Controller> Holder = new Holder<>(
			CxboxMyExample3268Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3268Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3268Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3268Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3268Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3268Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3268Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3268Controller> {

		public BcSupplier() {
			super(CxboxMyExample3268Controller.Holder);
		}

	}

}