package org.demo.documentation.fields.date.validationbusinessex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateValidationBusinessExController implements EnumBcIdentifier {


	dateValidationBusinessEx(DateValidationBusinessExService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxDateValidationBusinessExController> Holder = new Holder<>(
			CxboxDateValidationBusinessExController.class);

	private final BcDescription bcDescription;

	CxboxDateValidationBusinessExController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateValidationBusinessExController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateValidationBusinessExController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateValidationBusinessExController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateValidationBusinessExController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateValidationBusinessExController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateValidationBusinessExController> {

		public BcSupplier() {
			super(CxboxDateValidationBusinessExController.Holder);
		}

	}

}