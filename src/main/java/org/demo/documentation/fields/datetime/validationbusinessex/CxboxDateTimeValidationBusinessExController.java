package org.demo.documentation.fields.datetime.validationbusinessex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeValidationBusinessExController implements EnumBcIdentifier {

	

	dateTimeValidationBusinessEx(DateTimeValidationBusinessExService.class);
	// --8<-- [end:bc]
	
	

	public static final EnumBcIdentifier.Holder<CxboxDateTimeValidationBusinessExController> Holder = new Holder<>(
			CxboxDateTimeValidationBusinessExController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeValidationBusinessExController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeValidationBusinessExController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeValidationBusinessExController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeValidationBusinessExController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeValidationBusinessExController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeValidationBusinessExController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeValidationBusinessExController> {

		public BcSupplier() {
			super(CxboxDateTimeValidationBusinessExController.Holder);
		}

	}

}