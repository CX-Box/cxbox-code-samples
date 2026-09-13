package org.demo.documentation.widgets.picktree.title.calculatedtitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3347Controller implements EnumBcIdentifier {


	myexample3347(MyExample3347Service.class), myEntity3347PickPickTreePopup(myexample3347, MyEntity3347PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3347Controller> Holder = new Holder<>(
			CxboxMyExample3347Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3347Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3347Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3347Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3347Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3347Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3347Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3347Controller> {

		public BcSupplier() {
			super(CxboxMyExample3347Controller.Holder);
		}

	}

}