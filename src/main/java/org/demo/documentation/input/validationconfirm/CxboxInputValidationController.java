package org.demo.documentation.input.validationconfirm;


import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxInputValidationController implements EnumBcIdentifier {

	// @formatter:on

	InputValidation(InputValidationService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxInputValidationController> Holder = new Holder<>(
			CxboxInputValidationController.class);

	private final BcDescription bcDescription;

	CxboxInputValidationController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputValidationController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputValidationController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputValidationController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputValidationController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputValidationController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputValidationController> {

		public BcSupplier() {
			super(CxboxInputValidationController.Holder);
		}

	}

}
