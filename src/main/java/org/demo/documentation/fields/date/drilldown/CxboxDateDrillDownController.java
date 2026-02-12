package org.demo.documentation.fields.date.drilldown;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateDrillDownController implements EnumBcIdentifier {


	dateDrillDown(DateDrillDownService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxDateDrillDownController> Holder = new Holder<>(
			CxboxDateDrillDownController.class);

	private final BcDescription bcDescription;

	CxboxDateDrillDownController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateDrillDownController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateDrillDownController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateDrillDownController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateDrillDownController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateDrillDownController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateDrillDownController> {

		public BcSupplier() {
			super(CxboxDateDrillDownController.Holder);
		}

	}

}