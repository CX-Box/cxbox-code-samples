package org.demo.documentation.date.required;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateRequiredController implements EnumBcIdentifier {

	// @formatter:on

	dateRequired(DateRequiredService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxDateRequiredController> Holder = new Holder<>(
			CxboxDateRequiredController.class);

	private final BcDescription bcDescription;

	CxboxDateRequiredController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateRequiredController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateRequiredController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateRequiredController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateRequiredController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateRequiredController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateRequiredController> {

		public BcSupplier() {
			super(CxboxDateRequiredController.Holder);
		}

	}

}