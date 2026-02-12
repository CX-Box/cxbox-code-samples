package org.demo.documentation.fields.suggestion.color.colorconst;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.color.colorconst.forfield.MyExample3094Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3083Controller implements EnumBcIdentifier {


	myexample3083(MyExample3083SuggestionService.class),
	myexample3094(MyExample3094Service.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3083Controller> Holder = new Holder<>(
			CxboxMyExample3083Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3083Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3083Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3083Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3083Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3083Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3083Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3083Controller> {

		public BcSupplier() {
			super(CxboxMyExample3083Controller.Holder);
		}

	}

}