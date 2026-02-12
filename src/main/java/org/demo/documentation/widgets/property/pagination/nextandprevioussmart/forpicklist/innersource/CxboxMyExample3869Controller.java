package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist.innersource;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3869Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3869(MyExample3869Service.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3869Controller> Holder = new Holder<>(
			CxboxMyExample3869Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3869Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3869Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3869Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3869Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3869Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3869Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3869Controller> {

		public BcSupplier() {
			super(CxboxMyExample3869Controller.Holder);
		}

	}

}