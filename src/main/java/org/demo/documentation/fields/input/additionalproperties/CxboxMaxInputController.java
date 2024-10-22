package org.demo.documentation.fields.input.additionalproperties;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxMaxInputController implements EnumBcIdentifier {



	maxInput(MaxInputService.class);
	// --8<-- [end:bc]

	

	public static final EnumBcIdentifier.Holder<CxboxMaxInputController> Holder = new Holder<>(
			CxboxMaxInputController.class);

	private final BcDescription bcDescription;

	CxboxMaxInputController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMaxInputController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMaxInputController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMaxInputController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMaxInputController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMaxInputController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMaxInputController> {

		public BcSupplier() {
			super(CxboxMaxInputController.Holder);
		}

	}

}