package org.demo.documentation.widgets.info.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.info.base.allfields.MyExample3001Service;
import org.demo.documentation.widgets.info.base.allfields.forfields.MyEntity4222Multi2MultivalueService;
import org.demo.documentation.widgets.info.base.allfields.forfields.MyEntity4222MultiMultivalueService;
import org.demo.documentation.widgets.info.base.allfields.forfields.MyEntity4222Pick2PickService;
import org.demo.documentation.widgets.info.base.allfields.forfields.MyEntity4222PickPickService;
import org.demo.documentation.widgets.info.base.onefield.MyExample3009Service;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3001Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3001(MyExample3001Service.class),
	myEntity4222Pick2PickListPopup(myExampleBc3001, MyEntity4222Pick2PickService.class),
	myEntity4222PickPickListPopup(myExampleBc3001, MyEntity4222PickPickService.class),
	myEntity4222Multi2AssocListPopup(myExampleBc3001, MyEntity4222Multi2MultivalueService.class),
	myEntity4222MultiAssocListPopup(myExampleBc3001, MyEntity4222MultiMultivalueService.class),
	// --8<-- [end:bc]

	myexample3009(MyExample3009Service .class);



	public static final EnumBcIdentifier.Holder<PlatformMyExample3001Controller> Holder = new Holder<>(
			PlatformMyExample3001Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3001Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3001Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3001Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3001Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3001Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3001Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3001Controller> {

		public BcSupplier() {
			super(PlatformMyExample3001Controller.Holder);
		}

	}

}