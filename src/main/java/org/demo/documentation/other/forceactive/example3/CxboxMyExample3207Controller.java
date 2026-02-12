package org.demo.documentation.other.forceactive.example3;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.forceactive.example3.child.MyExample3208Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3207Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3207(MyExample3207Service.class),
	myexample3208(myexample3207, MyExample3208Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3207Controller> Holder = new Holder<>(
			CxboxMyExample3207Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3207Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3207Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3207Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3207Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3207Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3207Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3207Controller> {

		public BcSupplier() {
			super(CxboxMyExample3207Controller.Holder);
		}

	}

}