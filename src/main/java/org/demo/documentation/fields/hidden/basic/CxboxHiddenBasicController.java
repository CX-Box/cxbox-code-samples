package org.demo.documentation.fields.hidden.basic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxHiddenBasicController implements EnumBcIdentifier {

	// @formatter:on

	hiddenBasic(HiddenBasicService.class);
	// --8<-- [end:bc]
	// @formatter:on
	

	public static final EnumBcIdentifier.Holder<CxboxHiddenBasicController> Holder = new Holder<>(
			CxboxHiddenBasicController.class);

	private final BcDescription bcDescription;

	CxboxHiddenBasicController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxHiddenBasicController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxHiddenBasicController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxHiddenBasicController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxHiddenBasicController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxHiddenBasicController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxHiddenBasicController> {

		public BcSupplier() {
			super(CxboxHiddenBasicController.Holder);
		}

	}

}