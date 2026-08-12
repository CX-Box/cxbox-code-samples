package org.demo.documentation.widgets.tree;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.tree.tree.Myexample3261Service;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum CxboxMyExample3260Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample3261(Myexample3261Service.class),
	myexample3260(Myexample3260Service.class),
		myexample3261Pick0(myexample3260, Myexample3261Pick0Service.class),
		myexample3260Assoc(myexample3260, Myexample3261Pick0Service.class),
		myexample3261Pick(myexample3260, Myexample3261PickService.class);
	// @formatter:on

	public static final Holder<CxboxMyExample3260Controller> Holder = new Holder<>(CxboxMyExample3260Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3260Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3260Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3260Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}


	CxboxMyExample3260Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3260Controller> {

		public BcSupplier() {
			super(CxboxMyExample3260Controller.Holder);
		}

	}
}
