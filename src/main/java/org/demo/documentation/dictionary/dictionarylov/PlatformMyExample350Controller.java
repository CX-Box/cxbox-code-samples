package org.demo.documentation.dictionary.dictionarylov;

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
public enum PlatformMyExample350Controller implements EnumBcIdentifier {

	// @formatter:on
	myExampleBc350(MyExample350Service.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<PlatformMyExample350Controller> Holder = new Holder<>(
			PlatformMyExample350Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample350Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample350Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample350Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample350Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample350Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample350Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample350Controller> {

		public BcSupplier() {
			super(PlatformMyExample350Controller.Holder);
		}

	}

}