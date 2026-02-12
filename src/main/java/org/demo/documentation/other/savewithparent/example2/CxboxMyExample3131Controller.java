package org.demo.documentation.other.savewithparent.example2;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.savewithparent.example2.child.MyExample3130Service;
import org.demo.documentation.other.savewithparent.example2.parent.MyExample3131Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3131Controller implements EnumBcIdentifier {


	myexample3131(MyExample3131Service.class),
	myexample3130(myexample3131, MyExample3130Service.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3131Controller> Holder = new Holder<>(
			CxboxMyExample3131Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3131Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3131Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3131Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3131Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3131Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3131Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3131Controller> {

		public BcSupplier() {
			super(CxboxMyExample3131Controller.Holder);
		}

	}

}