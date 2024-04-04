package org.demo.documentation.input.filtration;


import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxInputFiltrationController implements EnumBcIdentifier {

	// @formatter:on

	InputFiltration(InputFiltrationService.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<CxboxInputFiltrationController> Holder = new Holder<>(
			CxboxInputFiltrationController.class);

	private final BcDescription bcDescription;

	CxboxInputFiltrationController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputFiltrationController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputFiltrationController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputFiltrationController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputFiltrationController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputFiltrationController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputFiltrationController> {

		public BcSupplier() {
			super(CxboxInputFiltrationController.Holder);
		}

	}

}
