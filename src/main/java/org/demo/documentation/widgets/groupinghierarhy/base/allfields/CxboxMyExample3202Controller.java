package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3202Controller implements EnumBcIdentifier {


	myexample3202(MyExample3202Service.class), myEntity3202PickPick0(myexample3202, MyEntity3202PickPick0Service.class), myEntity3202PickPick(myexample3202, MyEntity3202PickPickService.class), myEntity3202MultiPick(myexample3202, MyEntity3202MultiPickService.class), myEntity3202MultiHoverPick(myexample3202, MyEntity3202MultiHoverPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3202Controller> Holder = new Holder<>(
			CxboxMyExample3202Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3202Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3202Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3202Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3202Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3202Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3202Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3202Controller> {

		public BcSupplier() {
			super(CxboxMyExample3202Controller.Holder);
		}

	}

}