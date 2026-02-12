package org.demo.documentation.widgets.emptywidget.showcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.emptywidget.showcondition.bycurrententity.MyExample5033Service;
import org.demo.documentation.widgets.emptywidget.showcondition.byparententity.child.MyExample5037Service;
import org.demo.documentation.widgets.emptywidget.showcondition.byparententity.parent.MyExample5036Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5036Controller implements EnumBcIdentifier {

	// @formatter:on
	myexample5033(MyExample5033Service.class),
	myexample5036(MyExample5036Service.class),
	myexample5037(myexample5036, MyExample5037Service.class);


	// @formatter:on

	public static final Holder<CxboxMyExample5036Controller> Holder = new Holder<>(
			CxboxMyExample5036Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5036Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5036Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5036Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5036Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5036Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5036Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5036Controller> {

		public BcSupplier() {
			super(CxboxMyExample5036Controller.Holder);
		}

	}

}