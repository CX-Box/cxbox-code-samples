package org.demo.documentation.widgets.picktree.title.withtitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3344Controller implements EnumBcIdentifier {


	myexample3344(MyExample3344Service.class),
	myEntity3344PickPickTreePopup(myexample3344, MyEntity3344PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3344Controller> Holder = new Holder<>(
			CxboxMyExample3344Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3344Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3344Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3344Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3344Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3344Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3344Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3344Controller> {

		public BcSupplier() {
			super(CxboxMyExample3344Controller.Holder);
		}

	}

}