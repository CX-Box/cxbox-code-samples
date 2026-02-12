package org.demo.documentation.widgets.additionallist.showcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.additionallist.showcondition.bycurrententity.MyExample3193Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3193Controller implements EnumBcIdentifier {


	myexample3193(MyExample3193Service.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3193Controller> Holder = new Holder<>(
			CxboxMyExample3193Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3193Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3193Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3193Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3193Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3193Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3193Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3193Controller> {

		public BcSupplier() {
			super(CxboxMyExample3193Controller.Holder);
		}

	}

}