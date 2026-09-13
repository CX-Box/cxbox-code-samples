package org.demo.documentation.widgets.assoctree.actions;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3331Controller implements EnumBcIdentifier {

	myexample3331(MyExample3331Service.class),
	myEntity3331MultiAssocTreePopupCreate(myexample3331, MyEntity3331MultiMultivalueService.class),
	myEntity3331MultiAssocTreePopup(myexample3331, MyEntity3331MultiMultivalueService.class),
	myEntity3331MultiAssocDeleteListPopup(myexample3331, MyEntity3331MultiMultivalueService.class),
	myEntity3331MultiAssocSaveListPopup(myexample3331, MyEntity3331MultiMultivalueService.class),
	myEntity3331MultiAssocTreePopupEditInline(myexample3331, MyEntity3331MultiMultivalueService.class),
	myEntity3331MultiAssocTreePopupEditInlineForm(myexample3331, MyEntity3331MultiMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3331Controller> Holder = new Holder<>(
			CxboxMyExample3331Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3331Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3331Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3331Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3331Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3331Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3331Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3331Controller> {

		public BcSupplier() {
			super(CxboxMyExample3331Controller.Holder);
		}

	}

}