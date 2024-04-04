package org.demo.documentation.number.ro;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxNumberCreateEditController implements EnumBcIdentifier {

	// @formatter:on

	numberCreateEdit(NumberCreateEditService.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<CxboxNumberCreateEditController> Holder = new Holder<>(
			CxboxNumberCreateEditController.class);

	private final BcDescription bcDescription;

	CxboxNumberCreateEditController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberCreateEditController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberCreateEditController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberCreateEditController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberCreateEditController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberCreateEditController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberCreateEditController> {

		public BcSupplier() {
			super(CxboxNumberCreateEditController.Holder);
		}

	}

}