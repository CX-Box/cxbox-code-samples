package org.demo.documentation.widgets.dashboardlist.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum CxboxMyExample5040Controller implements EnumBcIdentifier {

	// @formatter:off
	myExampleBc5040(MyExampleBc5040Service.class);
	// @formatter:on

	public static final Holder<CxboxMyExample5040Controller> Holder = new Holder<>(CxboxMyExample5040Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5040Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5040Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5040Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5040Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5040Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5040Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5040Controller> {

		public BcSupplier() {
			super(CxboxMyExample5040Controller.Holder);
		}

	}
}
