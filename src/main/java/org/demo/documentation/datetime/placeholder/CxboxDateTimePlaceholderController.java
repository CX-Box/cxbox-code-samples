package org.demo.documentation.datetime.placeholder;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimePlaceholderController implements EnumBcIdentifier {

	// @formatter:on

	dateTimePlaceholder(DateTimePlaceholderService.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<CxboxDateTimePlaceholderController> Holder = new Holder<>(
			CxboxDateTimePlaceholderController.class);

	private final BcDescription bcDescription;

	CxboxDateTimePlaceholderController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimePlaceholderController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimePlaceholderController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimePlaceholderController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimePlaceholderController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimePlaceholderController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimePlaceholderController> {

		public BcSupplier() {
			super(CxboxDateTimePlaceholderController.Holder);
		}

	}

}