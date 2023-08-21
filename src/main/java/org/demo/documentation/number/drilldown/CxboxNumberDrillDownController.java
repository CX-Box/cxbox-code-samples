package org.demo.documentation.number.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

/**
 * This is actually an analog of a usual @RestController.
 * When you add enum, you just add rest endpoints, that cxbox UI can call.
 * We could actually make a usual @RestController and make it Generic,
 * but current enum approach shows, that it is less error-prone in huge enterprise projects
 * (because single line in this enum creates >5 rest endpoints)
 */
@Getter
public enum CxboxNumberDrillDownController implements EnumBcIdentifier {

	// @formatter:on

	numberDrillDown(NumberDrillDownService.class);

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