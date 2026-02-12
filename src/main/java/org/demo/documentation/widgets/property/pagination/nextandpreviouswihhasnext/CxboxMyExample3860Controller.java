package org.demo.documentation.widgets.property.pagination.nextandpreviouswihhasnext;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3860Controller implements EnumBcIdentifier {


	myexample3860(MyExample3860Service.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3860Controller> Holder = new Holder<>(
			CxboxMyExample3860Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3860Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3860Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3860Controller> {

		public BcSupplier() {
			super(CxboxMyExample3860Controller.Holder);
		}

	}

}