package org.demo.documentation.fields.property.snapshotkey;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5900Controller implements EnumBcIdentifier {

	// --8<-- [start:bc]
	myexample5900(MyExample5900Service.class),
	myexample5900pick(myexample5900, MyExample5900PickService.class);
	// --8<-- [end:bc]

	public static final EnumBcIdentifier.Holder<CxboxMyExample5900Controller> Holder = new Holder<>(
			CxboxMyExample5900Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5900Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5900Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5900Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5900Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5900Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5900Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5900Controller> {

		public BcSupplier() {
			super(CxboxMyExample5900Controller.Holder);
		}

	}

}
