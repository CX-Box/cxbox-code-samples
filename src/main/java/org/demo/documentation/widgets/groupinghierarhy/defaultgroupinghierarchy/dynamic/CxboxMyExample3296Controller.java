package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3296Controller implements EnumBcIdentifier {


	myexample3296config(MyExample3296ConfigService.class),
	myexample3296(MyExample3296Service.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3296Controller> Holder = new Holder<>(
			CxboxMyExample3296Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3296Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3296Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3296Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3296Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3296Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3296Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3296Controller> {

		public BcSupplier() {
			super(CxboxMyExample3296Controller.Holder);
		}

	}

}