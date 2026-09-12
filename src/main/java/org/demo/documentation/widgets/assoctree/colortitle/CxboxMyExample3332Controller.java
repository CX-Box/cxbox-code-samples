package org.demo.documentation.widgets.assoctree.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoctree.colortitle.color.MyEntity3332MultiPickService;
import org.demo.documentation.widgets.assoctree.colortitle.colorconst.MyEntity3332MultiPick0Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3332Controller implements EnumBcIdentifier {


	myexample3332(MyExample3332Service.class),
	myEntity3332MultiPick0(myexample3332, MyEntity3332MultiPick0Service.class),
	myEntity3332MultiPick(myexample3332, MyEntity3332MultiPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3332Controller> Holder = new Holder<>(
			CxboxMyExample3332Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3332Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3332Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3332Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3332Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3332Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3332Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3332Controller> {

		public BcSupplier() {
			super(CxboxMyExample3332Controller.Holder);
		}

	}

}