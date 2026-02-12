package org.demo.documentation.fields.number.additionalproperties.digits;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDigitsNumberController implements EnumBcIdentifier {


	digitsNumber(DigitsNumberService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxDigitsNumberController> Holder = new Holder<>(
			CxboxDigitsNumberController.class);

	private final BcDescription bcDescription;

	CxboxDigitsNumberController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDigitsNumberController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDigitsNumberController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDigitsNumberController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDigitsNumberController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDigitsNumberController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDigitsNumberController> {

		public BcSupplier() {
			super(CxboxDigitsNumberController.Holder);
		}

	}

}