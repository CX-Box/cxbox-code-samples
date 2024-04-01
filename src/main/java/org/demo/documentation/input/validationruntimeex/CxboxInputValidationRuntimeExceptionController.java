package org.demo.documentation.input.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxInputValidationRuntimeExceptionController implements EnumBcIdentifier {

	// @formatter:on

	InputValidationRuntimeException(InputValidationRuntimeExceptionService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxInputValidationRuntimeExceptionController> Holder = new Holder<>(
			CxboxInputValidationRuntimeExceptionController.class);

	private final BcDescription bcDescription;

	CxboxInputValidationRuntimeExceptionController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputValidationRuntimeExceptionController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputValidationRuntimeExceptionController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputValidationRuntimeExceptionController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputValidationRuntimeExceptionController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputValidationRuntimeExceptionController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputValidationRuntimeExceptionController> {

		public BcSupplier() {
			super(CxboxInputValidationRuntimeExceptionController.Holder);
		}

	}

}