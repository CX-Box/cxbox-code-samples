package org.demo.documentation.widgets.assoc.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoc.colortitle.color.MyEntity3056MultiPickService;
import org.demo.documentation.widgets.assoc.colortitle.colorconst.MyEntity3056MultiPick0Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3056Controller implements EnumBcIdentifier {


	myexample3056(MyExample3056Service.class),
	myEntity3056MultiPick0(myexample3056, MyEntity3056MultiPick0Service.class),
	myEntity3056MultiPick(myexample3056, MyEntity3056MultiPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3056Controller> Holder = new Holder<>(
			CxboxMyExample3056Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3056Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3056Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3056Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3056Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3056Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3056Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3056Controller> {

		public BcSupplier() {
			super(CxboxMyExample3056Controller.Holder);
		}

	}

}