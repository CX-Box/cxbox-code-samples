package org.demo.documentation.fields.date.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateValidationRuntimeExEntityController implements EnumBcIdentifier {

	// @formatter:on

	dateValidationRuntimeExEntity(DateValidationRuntimeExEntityService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxDateValidationRuntimeExEntityController> Holder = new Holder<>(
			CxboxDateValidationRuntimeExEntityController.class);

	private final BcDescription bcDescription;

	CxboxDateValidationRuntimeExEntityController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateValidationRuntimeExEntityController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateValidationRuntimeExEntityController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateValidationRuntimeExEntityController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateValidationRuntimeExEntityController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateValidationRuntimeExEntityController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateValidationRuntimeExEntityController> {

		public BcSupplier() {
			super(CxboxDateValidationRuntimeExEntityController.Holder);
		}

	}

}