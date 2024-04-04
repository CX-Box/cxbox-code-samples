package org.demo.documentation.datetime.colorconst;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeColorController implements EnumBcIdentifier {

	// @formatter:on

	dateTimeColor(DateTimeColorService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxDateTimeColorController> Holder = new Holder<>(
			CxboxDateTimeColorController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeColorController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeColorController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeColorController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeColorController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeColorController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeColorController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeColorController> {

		public BcSupplier() {
			super(CxboxDateTimeColorController.Holder);
		}

	}

}