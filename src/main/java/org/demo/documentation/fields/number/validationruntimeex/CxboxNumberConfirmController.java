package org.demo.documentation.fields.number.validationruntimeex;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.number.validationconfirm.NumberConfirmService;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxNumberConfirmController implements EnumBcIdentifier {

	// @formatter:on

	numberConfirm(NumberConfirmService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxNumberConfirmController> Holder = new Holder<>(
			CxboxNumberConfirmController.class);

	private final BcDescription bcDescription;

	CxboxNumberConfirmController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxNumberConfirmController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxNumberConfirmController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxNumberConfirmController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxNumberConfirmController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxNumberConfirmController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxNumberConfirmController> {

		public BcSupplier() {
			super(CxboxNumberConfirmController.Holder);
		}

	}

}