package org.demo.documentation.other.savewithparent.example443.parent;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.savewithparent.example443.child.MyExample3077Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3076Controller implements EnumBcIdentifier {


	myexample3076(MyExample3076Service.class),
	myexample3077(myexample3076, MyExample3077Service.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3076Controller> Holder = new Holder<>(
			CxboxMyExample3076Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3076Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3076Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3076Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3076Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3076Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3076Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3076Controller> {

		public BcSupplier() {
			super(CxboxMyExample3076Controller.Holder);
		}

	}

}