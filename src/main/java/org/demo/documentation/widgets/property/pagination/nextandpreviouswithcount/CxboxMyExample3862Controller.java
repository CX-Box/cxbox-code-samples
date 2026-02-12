package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862AssocPickService;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist.MyEntity3862PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3862Controller implements EnumBcIdentifier {


	myexample3862(MyExample3862Service.class), myEntity3862AssocPick(myexample3862, MyEntity3862AssocPickService.class),
	myEntity3862PickPick(myexample3862, MyEntity3862PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3862Controller> Holder = new Holder<>(
			CxboxMyExample3862Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3862Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3862Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3862Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3862Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3862Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3862Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3862Controller> {

		public BcSupplier() {
			super(CxboxMyExample3862Controller.Holder);
		}

	}

}