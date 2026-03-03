package org.demo.documentation.feature.locale;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.feature.locale.Myexample6103Service;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum CxboxMyExample6103Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample6103(Myexample6103Service.class);
	// @formatter:on

	public static final Holder<CxboxMyExample6103Controller> Holder = new Holder<>(CxboxMyExample6103Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample6103Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample6103Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample6103Controller> {

		public BcSupplier() {
			super(CxboxMyExample6103Controller.Holder);
		}

	}
}
