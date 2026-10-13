package org.demo.documentation.widgets.calendarlist.showcondition.byparententity;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.child.MyExample5059Service;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.parent.MyExample5058Service;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample5058Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample5058(MyExample5058Service.class),
	myexample5059(myexample5058, MyExample5059Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<PlatformMyExample5058Controller> Holder = new Holder<>(
			PlatformMyExample5058Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample5058Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample5058Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample5058Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample5058Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample5058Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample5058Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample5058Controller> {

		public BcSupplier() {
			super(PlatformMyExample5058Controller.Holder);
		}

	}

}
