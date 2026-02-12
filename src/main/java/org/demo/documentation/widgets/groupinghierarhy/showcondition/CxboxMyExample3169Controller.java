package org.demo.documentation.widgets.groupinghierarhy.showcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child.MyExample3170Service;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent.MyExample3169Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3169Controller implements EnumBcIdentifier {

	myexample3169(MyExample3169Service.class),
	myexample3170(myexample3169, MyExample3170Service.class);

	public static final EnumBcIdentifier.Holder<CxboxMyExample3169Controller> Holder = new Holder<>(
			CxboxMyExample3169Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3169Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3169Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3169Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3169Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3169Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3169Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3169Controller> {

		public BcSupplier() {
			super(CxboxMyExample3169Controller.Holder);
		}

	}

}