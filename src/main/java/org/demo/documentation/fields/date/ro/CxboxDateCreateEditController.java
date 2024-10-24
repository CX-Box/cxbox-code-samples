package org.demo.documentation.fields.date.ro;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateCreateEditController implements EnumBcIdentifier {

	

	dateCreateEdit(DateCreateEditService.class);
	// --8<-- [end:bc]
	


	public static final EnumBcIdentifier.Holder<CxboxDateCreateEditController> Holder = new Holder<>(
			CxboxDateCreateEditController.class);

	private final BcDescription bcDescription;

	CxboxDateCreateEditController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateCreateEditController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateCreateEditController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateCreateEditController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateCreateEditController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateCreateEditController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateCreateEditController> {

		public BcSupplier() {
			super(CxboxDateCreateEditController.Holder);
		}

	}

}