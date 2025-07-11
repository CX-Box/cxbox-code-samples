package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;

import org.springframework.stereotype.Component;

import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;

@Getter
public enum CxboxMyExample4300Controller implements EnumBcIdentifier {

	// @formatter:on

	myexample4300form(MyExample4300PostActionWithCustomBuilderService.class),
	myEntity4300MultivalueForm(myexample4300form, MyExample4300MultivalueService.class),
	myEntity4300MultivalueHoverForm(myexample4300form, MyExample4300MultivalueHoverService.class),
	myEntity4300PickListForm(myexample4300form, MyExample4300PickListService.class),
	myEntity4300InlinePickListForm(myexample4300form, MyExample4300InlinePickListService.class),

	myexample4300(MyExample4300WithDrillDownService.class),

	myEntity4300Multivalue(myexample4300, MyExample4300MultivalueService.class),
	myEntity4300MultivalueHover(myexample4300, MyExample4300MultivalueHoverService.class),
	myEntity4300PickList(myexample4300, MyExample4300PickListService.class),
	myEntity4300InlinePickList(myexample4300, MyExample4300InlinePickListService.class),
	;

	// @formatter:on

	public static final Holder<CxboxMyExample4300Controller> Holder = new Holder<>(
			CxboxMyExample4300Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample4300Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample4300Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample4300Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample4300Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample4300Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample4300Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4300Controller> {

		public BcSupplier() {
			super(CxboxMyExample4300Controller.Holder);
		}

	}

}

