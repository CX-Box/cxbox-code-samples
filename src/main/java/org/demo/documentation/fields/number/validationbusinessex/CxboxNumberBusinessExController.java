package org.demo.documentation.fields.number.validationbusinessex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxNumberBusinessExController implements EnumBcIdentifier {


	numberBusinessEx(NumberBusinessExService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxNumberBusinessExController> Holder = new Holder<>(
			CxboxNumberBusinessExController.class);

	private final BcDescription bcDescription;

	CxboxNumberBusinessExController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberBusinessExController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberBusinessExController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberBusinessExController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberBusinessExController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberBusinessExController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberBusinessExController> {

		public BcSupplier() {
			super(CxboxNumberBusinessExController.Holder);
		}

	}

}