package org.demo.documentation.fields.number.placeholder;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxNumberPlaceholderController implements EnumBcIdentifier {


	numberPlaceholder(NumberPlaceholderService.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<CxboxNumberPlaceholderController> Holder = new Holder<>(
			CxboxNumberPlaceholderController.class);

	private final BcDescription bcDescription;

	CxboxNumberPlaceholderController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberPlaceholderController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberPlaceholderController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberPlaceholderController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberPlaceholderController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberPlaceholderController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberPlaceholderController> {

		public BcSupplier() {
			super(CxboxNumberPlaceholderController.Holder);
		}

	}

}