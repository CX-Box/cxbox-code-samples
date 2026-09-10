package org.demo.documentation.widgets.tree.treesearchmodes;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription; 
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3280Controller implements EnumBcIdentifier {


	myExampleBc3280(MyExample3280Service.class);


	public static final Holder<PlatformMyExample3280Controller> Holder = new Holder<>(
			PlatformMyExample3280Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample3280Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample3280Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample3280Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample3280Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample3280Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample3280Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3280Controller> {

		public BcSupplier() {
			super(PlatformMyExample3280Controller.Holder);
		}

	}

}
