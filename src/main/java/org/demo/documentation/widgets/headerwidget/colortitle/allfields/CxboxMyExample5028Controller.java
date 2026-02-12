package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5028Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample5028(MyExample5028Service.class), myEntity5028PickPick0(myexample5028, MyEntity5028PickPick0Service.class),
	myEntity5028PickPick(myexample5028, MyEntity5028PickPickService.class), myEntity5028MultiPick0(myexample5028, MyEntity5028MultiPick0Service.class), myEntity5028MultiPick(myexample5028, MyEntity5028MultiPickService.class);

	// @formatter:on

	public static final Holder<CxboxMyExample5028Controller> Holder = new Holder<>(
			CxboxMyExample5028Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5028Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5028Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5028Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5028Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5028Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5028Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5028Controller> {

		public BcSupplier() {
			super(CxboxMyExample5028Controller.Holder);
		}

	}

}