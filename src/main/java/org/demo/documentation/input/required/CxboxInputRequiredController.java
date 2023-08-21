package org.demo.documentation.input.required;

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
public enum CxboxInputRequiredController implements EnumBcIdentifier {

	// @formatter:on

	InputRequired(InputRequiredService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxInputRequiredController> Holder = new Holder<>(
			CxboxInputRequiredController.class);

	private final BcDescription bcDescription;

	CxboxInputRequiredController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputRequiredController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputRequiredController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputRequiredController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputRequiredController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputRequiredController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputRequiredController> {

		public BcSupplier() {
			super(CxboxInputRequiredController.Holder);
		}

	}

}