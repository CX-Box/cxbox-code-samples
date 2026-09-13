package org.demo.documentation.widgets.tree.showcondition.byparententity;


import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.tree.showcondition.byparententity.child.MyExample3277Service;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyExample3276Service;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3277Controller implements EnumBcIdentifier {


	myexample3276(MyExample3276Service.class),
	myexample3277(myexample3276, MyExample3277Service.class);


	public static final EnumBcIdentifier.Holder<PlatformMyExample3277Controller> Holder = new Holder<>(
			PlatformMyExample3277Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3277Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3277Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3277Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3277Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3277Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3277Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3277Controller> {

		public BcSupplier() {
			super(PlatformMyExample3277Controller.Holder);
		}

	}

}
