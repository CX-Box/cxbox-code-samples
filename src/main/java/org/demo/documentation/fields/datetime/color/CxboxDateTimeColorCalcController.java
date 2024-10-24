package org.demo.documentation.fields.datetime.color;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeColorCalcController implements EnumBcIdentifier {



	dateTimeColorCalc(DateTimeColorCalcService.class);
	// --8<-- [end:bc]



	public static final EnumBcIdentifier.Holder<CxboxDateTimeColorCalcController> Holder = new Holder<>(
			CxboxDateTimeColorCalcController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeColorCalcController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeColorCalcController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeColorCalcController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeColorCalcController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeColorCalcController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeColorCalcController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeColorCalcController> {

		public BcSupplier() {
			super(CxboxDateTimeColorCalcController.Holder);
		}

	}

}