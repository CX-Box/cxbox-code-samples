package org.demo.documentation.widgets.assoctree.actions.other.buttonassoc;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3333Controller implements EnumBcIdentifier {


	myexample3333(MyExample3333Service.class),
	myexample3333Assoc(myexample3333, MyEntity3333MultiMultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3333Controller> Holder = new Holder<>(
			CxboxMyExample3333Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3333Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3333Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3333Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3333Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3333Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3333Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3333Controller> {

		public BcSupplier() {
			super(CxboxMyExample3333Controller.Holder);
		}

	}

}