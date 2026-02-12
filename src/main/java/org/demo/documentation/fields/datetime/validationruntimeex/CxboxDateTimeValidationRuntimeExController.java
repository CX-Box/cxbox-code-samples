package org.demo.documentation.fields.datetime.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeValidationRuntimeExController implements EnumBcIdentifier {


	dateTimeValidationRuntimeEx(DateTimeValidationRuntimeExService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxDateTimeValidationRuntimeExController> Holder = new Holder<>(
			CxboxDateTimeValidationRuntimeExController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeValidationRuntimeExController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeValidationRuntimeExController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeValidationRuntimeExController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeValidationRuntimeExController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeValidationRuntimeExController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeValidationRuntimeExController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeValidationRuntimeExController> {

		public BcSupplier() {
			super(CxboxDateTimeValidationRuntimeExController.Holder);
		}

	}

}