package org.demo.documentation.widgets.funnel.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.funnel.base.data.MyExampleBc5042Service;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum CxboxMyExample5041Controller implements EnumBcIdentifier {

	// @formatter:off
	myExampleBc5042(MyExampleBc5042Service.class),
	myExampleBc5041(MyExampleBc5041Service.class);
	// @formatter:on

	public static final Holder<CxboxMyExample5041Controller> Holder = new Holder<>(CxboxMyExample5041Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5041Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5041Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5041Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5041Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5041Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5041Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5041Controller> {

		public BcSupplier() {
			super(CxboxMyExample5041Controller.Holder);
		}

	}
}
