package org.demo.documentation.widgets.calendarlist.actions.create.newview;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum PlatformMyExample5062Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample5062(MyExample5062Service.class);
	// @formatter:on

	public static final EnumBcIdentifier.Holder<PlatformMyExample5062Controller> Holder = new Holder<>(
			PlatformMyExample5062Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample5062Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample5062Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample5062Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample5062Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample5062Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample5062Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample5062Controller> {

		public BcSupplier() {
			super(PlatformMyExample5062Controller.Holder);
		}

	}

}
