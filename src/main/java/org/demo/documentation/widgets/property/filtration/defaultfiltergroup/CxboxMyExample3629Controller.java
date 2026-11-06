package org.demo.documentation.widgets.property.filtration.defaultfiltergroup;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.MyExample3618Service;
import org.springframework.stereotype.Component;

/**
 * Default filter group: the records of the filter group sample, each business component has its own filter groups
 * in BC_FILTER_GROUPS.
 */
@Getter
public enum CxboxMyExample3629Controller implements EnumBcIdentifier {

	// @formatter:on

	// List: the group "Dictionary = High" is the default filter group
	myexample3629(MyExample3618Service.class),
	// Tree: the group "Dictionary = High" is the default filter group
	myexample3629tree(MyExample3618Service.class),
	// List: BC_PROPERTIES.FILTER is applied instead of the default filter group
	myexample3629bcfilter(MyExample3618Service.class);

	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample3629Controller> Holder = new Holder<>(
			CxboxMyExample3629Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3629Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3629Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3629Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3629Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3629Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3629Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3629Controller> {

		public BcSupplier() {
			super(CxboxMyExample3629Controller.Holder);
		}

	}

}
