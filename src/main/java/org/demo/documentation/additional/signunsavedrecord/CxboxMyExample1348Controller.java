package org.demo.documentation.additional.signunsavedrecord;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

/**
 * Signing and encrypting the document of a record that is not saved yet (CXBOX-1348): the file is uploaded to a new record,
 * and the action of signing is clicked before Save. The id of the file is only in the pending changes of the record.
 */
@Getter
public enum CxboxMyExample1348Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample1348(MyExample1348Service.class);
	// @formatter:on

	public static final Holder<CxboxMyExample1348Controller> Holder = new Holder<>(CxboxMyExample1348Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample1348Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample1348Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample1348Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample1348Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample1348Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample1348Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample1348Controller> {

		public BcSupplier() {
			super(CxboxMyExample1348Controller.Holder);
		}

	}

}
