package org.demo.documentation.fields.datetimewithseconds.sorting;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeWithSecondsSortingController implements EnumBcIdentifier {



	dateTimeWithSecondsSorting(DateTimeWithSecondsSortingService.class);
	// --8<-- [end:bc]

	

	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsSortingController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsSortingController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsSortingController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsSortingController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsSortingController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsSortingController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsSortingController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsSortingController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeWithSecondsSortingController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsSortingController.Holder);
		}

	}

}