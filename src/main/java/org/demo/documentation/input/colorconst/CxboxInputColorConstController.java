package org.demo.documentation.input.colorconst;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxInputColorConstController implements EnumBcIdentifier {

	// @formatter:on

	InputColorConst(InputColorConstService.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<CxboxInputColorConstController> Holder = new Holder<>(
			CxboxInputColorConstController.class);

	private final BcDescription bcDescription;

	CxboxInputColorConstController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputColorConstController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputColorConstController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputColorConstController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputColorConstController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputColorConstController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputColorConstController> {

		public BcSupplier() {
			super(CxboxInputColorConstController.Holder);
		}

	}

}