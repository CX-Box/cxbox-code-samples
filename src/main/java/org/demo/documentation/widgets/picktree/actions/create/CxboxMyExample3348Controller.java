package org.demo.documentation.widgets.picktree.actions.create;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picktree.actions.create.inlinepicktree.MyEntity3348InlinePickPickService;
import org.demo.documentation.widgets.picktree.actions.create.picktree.MyEntity3348PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3348Controller implements EnumBcIdentifier {


	myexample3348(MyExample3348Service.class),
	myEntity3348InlinePickPickTreePopup(myexample3348, MyEntity3348InlinePickPickService.class),
	myEntity3348PickPickTreePopup(myexample3348, MyEntity3348PickPickService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3348Controller> Holder = new Holder<>(
			CxboxMyExample3348Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3348Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3348Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3348Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3348Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3348Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3348Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3348Controller> {

		public BcSupplier() {
			super(CxboxMyExample3348Controller.Holder);
		}

	}

}