package org.demo.documentation.widgets.assoctree.actions.other.customsave;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3334Controller implements EnumBcIdentifier {


	myexample3334(MyExample3334Service.class), myEntity3334MultiAssocTreePopup(myexample3334, MyEntity3334MultiMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3334Controller> Holder = new Holder<>(
			CxboxMyExample3334Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3334Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3334Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3334Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3334Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3334Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3334Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3334Controller> {

		public BcSupplier() {
			super(CxboxMyExample3334Controller.Holder);
		}

	}

}