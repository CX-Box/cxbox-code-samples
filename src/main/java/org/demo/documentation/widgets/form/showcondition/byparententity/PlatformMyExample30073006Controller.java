package org.demo.documentation.widgets.form.showcondition.byparententity;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.form.showcondition.byparententity.child.MyExample3006Service;
import org.demo.documentation.widgets.form.showcondition.byparententity.parent.MyExample3007Service;
import org.springframework.stereotype.Component;

/**
 * This is actually an analog of a usual @RestController.
 * When you add enum, you just add rest endpoints, that cxbox UI can call.
 * We could actually make a usual @RestController and make it Generic,
 * but current enum approach shows, that it is less error-prone in huge enterprise projects
 * (because single line in this enum creates >6 rest endpoints)
 */
@Getter
public enum PlatformMyExample30073006Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myExampleBc3007(MyExample3007Service.class),
	myExampleBc3006(myExampleBc3007, MyExample3006Service.class);
	// --8<-- [end:bc]



	public static final EnumBcIdentifier.Holder<PlatformMyExample30073006Controller> Holder = new Holder<>(
			PlatformMyExample30073006Controller.class);

	private final BcDescription bcDescription;

	PlatformMyExample30073006Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExample30073006Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExample30073006Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExample30073006Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExample30073006Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExample30073006Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample30073006Controller> {

		public BcSupplier() {
			super(PlatformMyExample30073006Controller.Holder);
		}

	}

}