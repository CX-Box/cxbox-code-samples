package org.demo.documentation.input.placeholder;


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
public enum CxboxInputPlaceholderController implements EnumBcIdentifier {

	// @formatter:on

	InputPlaceholder(InputPlaceholderService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxInputPlaceholderController> Holder = new Holder<>(
			CxboxInputPlaceholderController.class);

	private final BcDescription bcDescription;

	CxboxInputPlaceholderController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputPlaceholderController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputPlaceholderController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputPlaceholderController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputPlaceholderController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputPlaceholderController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputPlaceholderController> {

		public BcSupplier() {
			super(CxboxInputPlaceholderController.Holder);
		}

	}

}
