package org.demo.documentation.dateytimewithseconds.color;

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
public enum CxboxDateTimeWithSecondsColorController implements EnumBcIdentifier {

	// @formatter:on

	dateTimeWithSecondsColor(DateTimeWithSecondsColorService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxDateTimeWithSecondsColorController> Holder = new Holder<>(
			CxboxDateTimeWithSecondsColorController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeWithSecondsColorController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsColorController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeWithSecondsColorController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsColorController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeWithSecondsColorController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeWithSecondsColorController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeWithSecondsColorController> {

		public BcSupplier() {
			super(CxboxDateTimeWithSecondsColorController.Holder);
		}

	}

}