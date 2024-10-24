package org.demo.documentation.fields.datetime.required;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxRequiredDateTimeController implements EnumBcIdentifier {

	

	requiredDateTime(RequiredDateTimeService.class);
	// --8<-- [end:bc]
	


	public static final EnumBcIdentifier.Holder<CxboxRequiredDateTimeController> Holder = new Holder<>(
			CxboxRequiredDateTimeController.class);

	private final BcDescription bcDescription;

	CxboxRequiredDateTimeController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxRequiredDateTimeController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxRequiredDateTimeController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxRequiredDateTimeController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxRequiredDateTimeController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxRequiredDateTimeController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxRequiredDateTimeController> {

		public BcSupplier() {
			super(CxboxRequiredDateTimeController.Holder);
		}

	}

}