package org.demo.documentation.widgets.picktree.fieldslayoute;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3346Controller implements EnumBcIdentifier {


	myexample3346(MyExample3346Service.class),
	myEntity3346PickPickTreePopup(myexample3346, MyEntity3346PickPickService.class),
	myEntity3346PickPickTreePopup6(myexample3346, MyEntity3346PickPickService.class),
	myEntity3346PickPickTreePopup12(myexample3346, MyEntity3346PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3346Controller> Holder = new Holder<>(
			CxboxMyExample3346Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3346Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3346Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3346Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3346Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3346Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3346Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3346Controller> {

		public BcSupplier() {
			super(CxboxMyExample3346Controller.Holder);
		}

	}

}