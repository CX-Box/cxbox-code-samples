package org.demo.documentation.other.forceactive.example2;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.forceactive.example2.child.MyExample3206Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3205Controller implements EnumBcIdentifier {

	// @formatter:on
	myexample3205(MyExample3205Service.class),
	myexample3206(myexample3205, MyExample3206Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3205Controller> Holder = new Holder<>(
			CxboxMyExample3205Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3205Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3205Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3205Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3205Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3205Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3205Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3205Controller> {

		public BcSupplier() {
			super(CxboxMyExample3205Controller.Holder);
		}

	}

}