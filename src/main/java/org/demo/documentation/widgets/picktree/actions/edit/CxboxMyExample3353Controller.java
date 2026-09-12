package org.demo.documentation.widgets.picktree.actions.edit;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.inlinepicktree.MyEntity3353PickPick0Service;
import org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.picktree.MyEntity3353PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3353Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample3353(MyExample3353Service.class),
	myEntity3353InlinePickTreeInline(myexample3353, MyEntity3353PickPick0Service.class),
	myEntity3353InlinePickTreeInlineForm(myexample3353, MyEntity3353PickPick0Service.class),
	myEntity3353PickInline(myexample3353, MyEntity3353PickPickService.class),
	myEntity3353PickInlineForm(myexample3353, MyEntity3353PickPickService.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3353Controller> Holder = new Holder<>(
			CxboxMyExample3353Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3353Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3353Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3353Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3353Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3353Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3353Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3353Controller> {

		public BcSupplier() {
			super(CxboxMyExample3353Controller.Holder);
		}

	}

}