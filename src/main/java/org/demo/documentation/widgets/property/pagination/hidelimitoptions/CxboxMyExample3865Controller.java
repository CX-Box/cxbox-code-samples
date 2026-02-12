package org.demo.documentation.widgets.property.pagination.hidelimitoptions;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.list.MyExample3865Service;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865MultiPickService;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup.MyEntity3865PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3865Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3865(MyExample3865Service.class),
	myEntity3865MultiPick(myexample3865, MyEntity3865MultiPickService.class),
	myEntity3865PickPick(myexample3865, MyEntity3865PickPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3865Controller> Holder = new Holder<>(
			CxboxMyExample3865Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3865Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3865Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3865Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3865Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3865Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3865Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3865Controller> {

		public BcSupplier() {
			super(CxboxMyExample3865Controller.Holder);
		}

	}

}