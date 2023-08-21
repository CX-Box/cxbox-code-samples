package org.demo.documentation.input.validationbusinessex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

/**
 * This is actually an analog of a usual @RestController.
 * When you add enum, you just add rest endpoints, that cxbox UI can call.
 * We could actually make a usual @RestController and make it Generic,
 * but current enum approach shows, that it is less error-prone in huge enterprise projects
 * (because single line in this enum creates >5 rest endpoints)
 */
@Getter
public enum CxboxInputValidationBusinessExceptionController implements EnumBcIdentifier {

	// @formatter:on

	InputValidationBusinessException(InputValidationBusinessExceptionService.class);

	// @formatter:on

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