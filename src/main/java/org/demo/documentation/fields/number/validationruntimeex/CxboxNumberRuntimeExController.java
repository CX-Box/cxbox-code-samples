package org.demo.documentation.fields.number.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxNumberRuntimeExController implements EnumBcIdentifier {



	numberRuntimeEx(NumberRuntimeExService.class);
	// --8<-- [end:bc]



	public static final EnumBcIdentifier.Holder<CxboxNumberRuntimeExController> Holder = new Holder<>(
			CxboxNumberRuntimeExController.class);

	private final BcDescription bcDescription;

	CxboxNumberRuntimeExController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberRuntimeExController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberRuntimeExController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberRuntimeExController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberRuntimeExController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberRuntimeExController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberRuntimeExController> {

		public BcSupplier() {
			super(CxboxNumberRuntimeExController.Holder);
		}

	}

}