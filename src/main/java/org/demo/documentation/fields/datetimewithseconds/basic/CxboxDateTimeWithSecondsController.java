package org.demo.documentation.fields.datetimewithseconds.basic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsController implements EnumBcIdentifier {


	dateTimeWithSeconds(DateTimeWithSecondsService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeWithSecondsController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsController.Holder);
		}

	}

}