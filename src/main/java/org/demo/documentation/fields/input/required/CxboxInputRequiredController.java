package org.demo.documentation.fields.input.required;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxInputRequiredController implements EnumBcIdentifier {



	InputRequired(InputRequiredService.class);
	// --8<-- [end:bc]

	

	public static final EnumBcIdentifier.Holder<CxboxInputRequiredController> Holder = new Holder<>(
			CxboxInputRequiredController.class);

	private final BcDescription bcDescription;

	CxboxInputRequiredController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputRequiredController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputRequiredController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputRequiredController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputRequiredController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputRequiredController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputRequiredController> {

		public BcSupplier() {
			super(CxboxInputRequiredController.Holder);
		}

	}

}