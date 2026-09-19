package org.demo.documentation.feature.file.availability;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample6104Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample6104(MyExample6104Service.class),
	myexample6105(myexample6104, MyExample6105Service.class);

	// @formatter:on

	public static final Holder<CxboxMyExample6104Controller> Holder = new Holder<>(
			CxboxMyExample6104Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample6104Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample6104Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample6104Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample6104Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample6104Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample6104Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample6104Controller> {

		public BcSupplier() {
			super(CxboxMyExample6104Controller.Holder);
		}

	}

}
