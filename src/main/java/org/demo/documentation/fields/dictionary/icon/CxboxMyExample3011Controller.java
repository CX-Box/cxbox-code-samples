package org.demo.documentation.fields.dictionary.icon;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011MultiPickService;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012MultiPickService;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3012PickService;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3013PickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3011Controller implements EnumBcIdentifier {


	myexample3011(MyExample3011Service.class), myEntity3012MultiPick(myexample3011, MyEntity3012MultiPickService.class), myEntity3011MultiPick(myexample3011, MyEntity3011MultiPickService.class), myEntity3013Pick(myexample3011, MyEntity3013PickService.class),
	myEntity3012Pick(myexample3011, MyEntity3012PickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3011Controller> Holder = new Holder<>(
			CxboxMyExample3011Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3011Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3011Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3011Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3011Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3011Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3011Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3011Controller> {

		public BcSupplier() {
			super(CxboxMyExample3011Controller.Holder);
		}

	}

}