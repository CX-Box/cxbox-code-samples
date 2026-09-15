package org.demo.documentation.widgets.calendarlist.actions.create.withwidget;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample5061Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample5061(MyExample5061Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<PlatformMyExample5061Controller> Holder = new Holder<>(
			PlatformMyExample5061Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample5061Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample5061Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample5061Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample5061Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample5061Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample5061Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample5061Controller> {

		public BcSupplier() {
			super(PlatformMyExample5061Controller.Holder);
		}

	}

}
