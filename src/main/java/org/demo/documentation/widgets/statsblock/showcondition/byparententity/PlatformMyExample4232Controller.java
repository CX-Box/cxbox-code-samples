package org.demo.documentation.widgets.statsblock.showcondition.byparententity;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.statsblock.showcondition.byparententity.child.MyExample4233Service;
import org.demo.documentation.widgets.statsblock.showcondition.byparententity.parent.MyExample4232Service;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample4232Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample4232(MyExample4232Service.class),
	myexample4233(myexample4232, MyExample4233Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<PlatformMyExample4232Controller> Holder = new Holder<>(
			PlatformMyExample4232Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample4232Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample4232Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample4232Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample4232Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample4232Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample4232Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4232Controller> {

		public BcSupplier() {
			super(PlatformMyExample4232Controller.Holder);
		}

	}

}
