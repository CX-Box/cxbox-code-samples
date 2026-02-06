package org.demo.documentation.other.relationGraph;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum Myexample6150Controller implements EnumBcIdentifier {


	// --8<-- [start:bc]
	myexample6150(Myexample6150Service.class),
	myexample6150IOB(Myexample6150Service.class);
	// --8<-- [end:bc]


	public static final EnumBcIdentifier.Holder<Myexample6150Controller> Holder = new Holder<>(
			Myexample6150Controller.class);

	private final BcDescription bcDescription;

	Myexample6150Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	Myexample6150Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	Myexample6150Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	Myexample6150Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	Myexample6150Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	Myexample6150Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<Myexample6150Controller> {

		public BcSupplier() {
			super(Myexample6150Controller.Holder);
		}

	}

}