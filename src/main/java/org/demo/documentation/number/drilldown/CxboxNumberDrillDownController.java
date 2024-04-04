package org.demo.documentation.number.drilldown;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxNumberDrillDownController implements EnumBcIdentifier {

	// @formatter:on

	numberDrillDown(NumberDrillDownService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxNumberDrillDownController> Holder = new Holder<>(
			CxboxNumberDrillDownController.class);

	private final BcDescription bcDescription;

	CxboxNumberDrillDownController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberDrillDownController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberDrillDownController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberDrillDownController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberDrillDownController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberDrillDownController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberDrillDownController> {

		public BcSupplier() {
			super(CxboxNumberDrillDownController.Holder);
		}

	}

}