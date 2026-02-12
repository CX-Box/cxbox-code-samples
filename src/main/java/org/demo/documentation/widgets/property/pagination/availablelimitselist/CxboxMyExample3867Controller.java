package org.demo.documentation.widgets.property.pagination.availablelimitselist;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.list.MyExample3867Service;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue.MyEntity3867MultiPickService;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup.MyEntity3867PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3867Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3867(MyExample3867Service.class),
	myEntity3867PickPick(myexample3867, MyEntity3867PickPickService.class),
	myEntity3867MultiPick(myexample3867, MyEntity3867MultiPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3867Controller> Holder = new Holder<>(
			CxboxMyExample3867Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3867Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3867Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3867Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3867Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3867Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3867Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3867Controller> {

		public BcSupplier() {
			super(CxboxMyExample3867Controller.Holder);
		}

	}

}