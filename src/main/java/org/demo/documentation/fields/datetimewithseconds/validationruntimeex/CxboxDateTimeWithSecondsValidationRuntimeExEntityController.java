package org.demo.documentation.fields.datetimewithseconds.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsValidationRuntimeExEntityController implements EnumBcIdentifier {

	// @formatter:on

	dateTimeWithSecondsValidationRuntimeExEntity(DateTimeWithSecondsValidationRuntimeExEntityService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsValidationRuntimeExEntityController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsValidationRuntimeExEntityController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsValidationRuntimeExEntityController(String parentName, Class<?> serviceClass,
			boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsValidationRuntimeExEntityController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsValidationRuntimeExEntityController(BcIdentifier parent, Class<?> serviceClass,
			boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsValidationRuntimeExEntityController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsValidationRuntimeExEntityController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsValidationRuntimeExEntityController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends
			AbstractEnumBcSupplier<CxboxDateTimeWithSecondsValidationRuntimeExEntityController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsValidationRuntimeExEntityController.Holder);
		}

	}

}