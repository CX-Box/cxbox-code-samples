package org.demo.documentation.widgets.assoctree.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330MultiMultivalueService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3330Controller implements EnumBcIdentifier {


	myexample3330(MyExample3330Service.class),
	myexample3330Assoc(myexample3330, MyEntity3330MultiMultivalueService.class),
	myEntity3330MultiAssocTreePopup(myexample3330, MyEntity3330MultiMultivalueService.class);

	public static final EnumBcIdentifier.Holder<CxboxMyExample3330Controller> Holder = new Holder<>(
			CxboxMyExample3330Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3330Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3330Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3330Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3330Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3330Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3330Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3330Controller> {

		public BcSupplier() {
			super(CxboxMyExample3330Controller.Holder);
		}

	}

}