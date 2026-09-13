package org.demo.documentation.widgets.picktree.actions.save;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.actions.save.forpicktreepopup.MyEntity3355PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3355Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3355(MyExample3355Service.class), myEntity3355PickPick(myexample3355, MyEntity3355PickPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3355Controller> Holder = new Holder<>(
			CxboxMyExample3355Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3355Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3355Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3355Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3355Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3355Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3355Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3355Controller> {

		public BcSupplier() {
			super(CxboxMyExample3355Controller.Holder);
		}

	}

}