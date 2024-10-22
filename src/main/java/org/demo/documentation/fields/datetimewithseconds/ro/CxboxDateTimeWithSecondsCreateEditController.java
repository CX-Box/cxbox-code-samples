package org.demo.documentation.fields.datetimewithseconds.ro;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsCreateEditController implements EnumBcIdentifier {



	dateTimeWithSecondsCreateEdit(DateTimeWithSecondsCreateEditService.class);
	// --8<-- [end:bc]



	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsCreateEditController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsCreateEditController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsCreateEditController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsCreateEditController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsCreateEditController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsCreateEditController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsCreateEditController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsCreateEditController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeWithSecondsCreateEditController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsCreateEditController.Holder);
		}

	}

}