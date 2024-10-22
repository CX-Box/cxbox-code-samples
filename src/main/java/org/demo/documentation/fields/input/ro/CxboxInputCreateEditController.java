package org.demo.documentation.fields.input.ro;


import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxInputCreateEditController implements EnumBcIdentifier {

	

	InputCreateEdit(InputCreateEditService.class);
	// --8<-- [end:bc]
	
	

	public static final EnumBcIdentifier.Holder<CxboxInputCreateEditController> Holder = new Holder<>(
			CxboxInputCreateEditController.class);

	private final BcDescription bcDescription;

	CxboxInputCreateEditController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxInputCreateEditController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxInputCreateEditController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxInputCreateEditController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxInputCreateEditController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxInputCreateEditController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxInputCreateEditController> {

		public BcSupplier() {
			super(CxboxInputCreateEditController.Holder);
		}

	}

}
