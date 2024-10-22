package org.demo.documentation.fields.number.required;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxNumberRequiredController implements EnumBcIdentifier {



	numberRequired(NumberRequiredService.class);
	// --8<-- [end:bc]

	

	public static final EnumBcIdentifier.Holder<CxboxNumberRequiredController> Holder = new Holder<>(
			CxboxNumberRequiredController.class);

	private final BcDescription bcDescription;

	CxboxNumberRequiredController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberRequiredController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberRequiredController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberRequiredController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberRequiredController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberRequiredController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberRequiredController> {

		public BcSupplier() {
			super(CxboxNumberRequiredController.Holder);
		}

	}

}