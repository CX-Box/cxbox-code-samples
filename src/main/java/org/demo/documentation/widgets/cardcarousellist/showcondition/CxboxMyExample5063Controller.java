package org.demo.documentation.widgets.cardcarousellist.showcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;
import org.demo.documentation.widgets.cardcarousellist.showcondition.child.MyExample5064Service;
import org.demo.documentation.widgets.cardcarousellist.showcondition.parent.MyExample5063Service;

@Getter
public enum CxboxMyExample5063Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample5063(MyExample5063Service.class),
	myexample5064(myexample5063, MyExample5064Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample5063Controller> Holder = new Holder<>(
			CxboxMyExample5063Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5063Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5063Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5063Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5063Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5063Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5063Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5063Controller> {

		public BcSupplier() {
			super(CxboxMyExample5063Controller.Holder);
		}

	}

}
