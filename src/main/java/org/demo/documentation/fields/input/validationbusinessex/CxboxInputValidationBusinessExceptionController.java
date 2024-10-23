package org.demo.documentation.fields.input.validationbusinessex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxInputValidationBusinessExceptionController implements EnumBcIdentifier {



	InputValidationBusinessException(InputValidationBusinessExceptionService.class);
	// --8<-- [end:bc]

	

	public static final EnumBcIdentifier.Holder<CxboxInputValidationBusinessExceptionController> Holder = new Holder<>(
			CxboxInputValidationBusinessExceptionController.class);

	private final BcDescription bcDescription;

	CxboxInputValidationBusinessExceptionController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputValidationBusinessExceptionController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputValidationBusinessExceptionController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputValidationBusinessExceptionController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputValidationBusinessExceptionController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputValidationBusinessExceptionController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputValidationBusinessExceptionController> {

		public BcSupplier() {
			super(CxboxInputValidationBusinessExceptionController.Holder);
		}

	}

}