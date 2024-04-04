package org.demo.documentation.datetimewithseconds.required;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsRequredController implements EnumBcIdentifier {

	// @formatter:on

	dateTimeWithSecondsRequred(DateTimeWithSecondsRequredService.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsRequredController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsRequredController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsRequredController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsRequredController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsRequredController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsRequredController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsRequredController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsRequredController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeWithSecondsRequredController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsRequredController.Holder);
		}

	}

}