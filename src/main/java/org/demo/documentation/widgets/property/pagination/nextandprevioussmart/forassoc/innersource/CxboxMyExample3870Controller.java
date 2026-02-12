package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forassoc.innersource;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3870Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3870(MyExample3870Service.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3870Controller> Holder = new Holder<>(
			CxboxMyExample3870Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3870Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3870Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3870Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3870Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3870Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3870Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3870Controller> {

		public BcSupplier() {
			super(CxboxMyExample3870Controller.Holder);
		}

	}

}