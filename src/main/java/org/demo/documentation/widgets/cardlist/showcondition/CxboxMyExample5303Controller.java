package org.demo.documentation.widgets.cardlist.showcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;
import org.demo.documentation.widgets.cardlist.showcondition.child.MyExample5313Service;
import org.demo.documentation.widgets.cardlist.showcondition.parent.MyExample5303Service;

@Getter
public enum CxboxMyExample5303Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample5303(MyExample5303Service.class),
	myexample5313(myexample5303, MyExample5313Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample5303Controller> Holder = new Holder<>(
			CxboxMyExample5303Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5303Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5303Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5303Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5303Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5303Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5303Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5303Controller> {

		public BcSupplier() {
			super(CxboxMyExample5303Controller.Holder);
		}

	}

}
