package org.demo.documentation.widgets.property.filtration.filtergroupsave;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624PickService;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist.MyEntity3618PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3618Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3618(MyExample3618Service.class),
	myEntity3618PickPick(myexample3618, MyEntity3618PickPickService.class),
	myEntity3624Pick(myexample3618, MyEntity3624PickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3618Controller> Holder = new Holder<>(
			CxboxMyExample3618Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3618Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3618Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3618Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3618Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3618Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3618Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3618Controller> {

		public BcSupplier() {
			super(CxboxMyExample3618Controller.Holder);
		}

	}

}