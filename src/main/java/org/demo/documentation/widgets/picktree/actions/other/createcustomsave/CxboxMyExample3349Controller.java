package org.demo.documentation.widgets.picktree.actions.other.createcustomsave;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3349Controller implements EnumBcIdentifier {


	myexample3349(MyExample3349Service.class), myEntity3349PickPickTreePopup(myexample3349, MyEntity3349PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3349Controller> Holder = new Holder<>(
			CxboxMyExample3349Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3349Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3349Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3349Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3349Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3349Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3349Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3349Controller> {

		public BcSupplier() {
			super(CxboxMyExample3349Controller.Holder);
		}

	}

}