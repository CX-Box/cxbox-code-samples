package org.demo.documentation.fields.suggestion.drilldown;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.drilldown.forfield.MyExample3095Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3084Controller implements EnumBcIdentifier {


	myexample3095(MyExample3095Service.class),
	myexample3084(MyExample3084SuggestionService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3084Controller> Holder = new Holder<>(
			CxboxMyExample3084Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3084Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3084Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3084Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3084Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3084Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3084Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3084Controller> {

		public BcSupplier() {
			super(CxboxMyExample3084Controller.Holder);
		}

	}

}