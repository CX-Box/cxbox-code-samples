package org.demo.documentation.widgets.tree.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267InlinePicklistPickService;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMultiMultivalueService;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMultivalueService;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267PicklistPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3267Controller implements EnumBcIdentifier {


	myexample3267(MyExample3267Service.class), myEntity3267PicklistPickTreePopup(myexample3267, MyEntity3267PicklistPickService.class), myEntity3267InlinePicklistPickTreePopup(myexample3267, MyEntity3267InlinePicklistPickService.class), myEntity3267MultiMultiAssocTreePopup(myexample3267, MyEntity3267MultiMultiMultivalueService.class), myEntity3267MultiAssocTreePopup(myexample3267, MyEntity3267MultiMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3267Controller> Holder = new Holder<>(
			CxboxMyExample3267Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3267Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3267Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3267Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3267Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3267Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3267Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3267Controller> {

		public BcSupplier() {
			super(CxboxMyExample3267Controller.Holder);
		}

	}

}