package org.demo.documentation.fields.datetimewithseconds.validationconfirm;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsValidationBusinessExController implements EnumBcIdentifier {

	// @formatter:on

	dateTimeWithSecondsValidationBusinessEx(DateTimeWithSecondsValidationBusinessExService.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsValidationBusinessExController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsValidationBusinessExController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsValidationBusinessExController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsValidationBusinessExController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsValidationBusinessExController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsValidationBusinessExController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsValidationBusinessExController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsValidationBusinessExController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends
			AbstractEnumBcSupplier<CxboxDateTimeWithSecondsValidationBusinessExController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsValidationBusinessExController.Holder);
		}

	}

}