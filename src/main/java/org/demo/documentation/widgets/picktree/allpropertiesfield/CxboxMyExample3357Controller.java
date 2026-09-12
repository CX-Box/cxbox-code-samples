package org.demo.documentation.widgets.picktree.allpropertiesfield;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup.MyEntity3357PickTreePopupPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3357Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3357(MyExample3357Service.class), myEntity3357PickTreePopupPick(myexample3357, MyEntity3357PickTreePopupPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3357Controller> Holder = new Holder<>(
			CxboxMyExample3357Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3357Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3357Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3357Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3357Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3357Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3357Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3357Controller> {

		public BcSupplier() {
			super(CxboxMyExample3357Controller.Holder);
		}

	}

}