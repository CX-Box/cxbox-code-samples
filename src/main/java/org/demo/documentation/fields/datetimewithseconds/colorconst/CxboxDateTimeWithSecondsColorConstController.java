package org.demo.documentation.fields.datetimewithseconds.colorconst;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsColorConstController implements EnumBcIdentifier {



	dateTimeWithSecondsColorConst(DateTimeWithSecondsColorConstService.class);
	// --8<-- [end:bc]



	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsColorConstController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsColorConstController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsColorConstController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsColorConstController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsColorConstController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsColorConstController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsColorConstController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsColorConstController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeWithSecondsColorConstController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsColorConstController.Holder);
		}

	}

}