package org.demo.documentation.other.parentchild;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildService;
import org.demo.documentation.other.parentchild.parent.MyExampleBc3045Service;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum PlatformMyExample3045Controller implements EnumBcIdentifier {

	// @formatter:off
	myExampleBc3045(MyExampleBc3045Service.class),

		myExampleBc3045Child(myExampleBc3045, MyExampleBc3045ChildService.class);
	// @formatter:on

	public static final Holder<PlatformMyExample3045Controller> Holder = new Holder<>(PlatformMyExample3045Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3045Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3045Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3045Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3045Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3045Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3045Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3045Controller> {

		public BcSupplier() {
			super(PlatformMyExample3045Controller.Holder);
		}

	}
}
