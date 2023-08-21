package org.demo.documentation.number.colorconst;

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
public enum CxboxNumberColorConstController implements EnumBcIdentifier {

	// @formatter:on

	numberColorConst(NumberColorConstService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxNumberColorConstController> Holder = new Holder<>(
			CxboxNumberColorConstController.class);

	private final BcDescription bcDescription;

	CxboxNumberColorConstController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberColorConstController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberColorConstController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberColorConstController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberColorConstController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberColorConstController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberColorConstController> {

		public BcSupplier() {
			super(CxboxNumberColorConstController.Holder);
		}

	}

}