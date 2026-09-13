package org.demo.documentation.widgets.picktree.actions.delete;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.actions.delete.forpicktreepopup.MyEntity3354PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3354Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3354(MyExample3354Service.class),
	myEntity3354PickPick(myexample3354, MyEntity3354PickPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3354Controller> Holder = new Holder<>(
			CxboxMyExample3354Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3354Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3354Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3354Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3354Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3354Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3354Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3354Controller> {

		public BcSupplier() {
			super(CxboxMyExample3354Controller.Holder);
		}

	}

}