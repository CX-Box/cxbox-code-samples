package org.demo.documentation.widgets.list.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.list.base.forfields.MyEntity3003MultivalueService;
import org.demo.documentation.widgets.list.base.forfields.MyEntity3003PickService;
import org.demo.documentation.widgets.list.base.forfields.MyEntity3002MultivalueService;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3002Controller implements EnumBcIdentifier {

	// @formatter:on
	// --8<-- [start:bc]
	myExampleBc3002(MyExample3002Service.class), myEntity3002MultiAssocListPopup(myExampleBc3002, MyEntity3002MultivalueService.class), myEntity3003AssocListPopup(myExampleBc3002, MyEntity3003MultivalueService.class), myEntity3003PickListPopup(myExampleBc3002, MyEntity3003PickService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<PlatformMyExample3002Controller> Holder = new Holder<>(
			PlatformMyExample3002Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3002Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3002Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3002Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3002Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3002Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3002Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3002Controller> {

		public BcSupplier() {
			super(PlatformMyExample3002Controller.Holder);
		}

	}

}