package org.demo.documentation.fields.datetime.filtration;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeFiltrationController implements EnumBcIdentifier {


	dateTimeFiltration(DateTimeFiltrationService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxDateTimeFiltrationController> Holder = new Holder<>(
			CxboxDateTimeFiltrationController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeFiltrationController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeFiltrationController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeFiltrationController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeFiltrationController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeFiltrationController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeFiltrationController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeFiltrationController> {

		public BcSupplier() {
			super(CxboxDateTimeFiltrationController.Holder);
		}

	}

}