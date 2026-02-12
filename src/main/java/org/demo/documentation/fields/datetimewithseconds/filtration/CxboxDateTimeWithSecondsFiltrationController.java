package org.demo.documentation.fields.datetimewithseconds.filtration;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsFiltrationController implements EnumBcIdentifier {


	dateTimeWithSecondsFiltration(DateTimeWithSecondsFiltrationService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsFiltrationController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsFiltrationController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsFiltrationController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsFiltrationController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsFiltrationController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsFiltrationController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsFiltrationController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsFiltrationController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeWithSecondsFiltrationController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsFiltrationController.Holder);
		}

	}

}