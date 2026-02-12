package org.demo.documentation.widgets.form.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.form.base.allfields.MyExample3010Service;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHoverPickService;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiPickService;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010PickPick0Service;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010PickPickService;
import org.demo.documentation.widgets.form.base.onefield.MyExample3000Service;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3000Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3000(MyExample3000Service.class),
	// --8<-- [end:bc]
	myexample3010(MyExample3010Service.class), myEntity3010PickPick0(myexample3010, MyEntity3010PickPick0Service.class), myEntity3010PickPick(myexample3010, MyEntity3010PickPickService.class), myEntity3010MultiPick(myexample3010, MyEntity3010MultiPickService.class), myEntity3010MultiHoverPick(myexample3010, MyEntity3010MultiHoverPickService.class);


	public static final EnumBcIdentifier.Holder<PlatformMyExample3000Controller> Holder = new Holder<>(
			PlatformMyExample3000Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3000Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3000Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3000Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3000Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3000Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3000Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3000Controller> {

		public BcSupplier() {
			super(PlatformMyExample3000Controller.Holder);
		}

	}

}