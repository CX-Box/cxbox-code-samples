package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
@SuppressWarnings("java:S115")
public enum CxboxMyExample4300Controller implements EnumBcIdentifier {

	// @formatter:off

	myExample4300PostAction(MyExample4300PostActionWithCustomBuilderService.class),
		myEntity4300MultivaluePostAction(myExample4300PostAction, MyExample4300MultivalueService.class),
		myEntity4300MultivalueHoverPostAction(myExample4300PostAction, MyExample4300MultivalueHoverService.class),
		myEntity4300PickListPostAction(myExample4300PostAction, MyExample4300PickListService.class),
		myEntity4300InlinePickListPostAction(myExample4300PostAction, MyExample4300InlinePickListService.class),

	myExample4300DrillDown(MyExample4300WithDrillDownService.class),
		myEntity4300Multivalue(myExample4300DrillDown, MyExample4300MultivalueService.class),
		myEntity4300MultivalueHover(myExample4300DrillDown, MyExample4300MultivalueHoverService.class),
		myEntity4300PickList(myExample4300DrillDown, MyExample4300PickListService.class),
		myEntity4300InlinePickList(myExample4300DrillDown, MyExample4300InlinePickListService.class),

	myExample4300DrilldownKey(MyExample4300WithDrilldownKeyService.class),
		myExample4300FirstEntity(myExample4300DrilldownKey, MyExample4300FirstEntityService.class),
			myExample4300SecondEntity(myExample4300FirstEntity, MyExample4300SecondEntityService.class),
		myExample4300DrilldownKeyMultivalueHover(myExample4300DrilldownKey, MyExample4300MultivalueHoverService.class),
		myExample4300DrilldownKeyPickList(myExample4300DrilldownKey, MyExample4300PickListService.class),
		myExample4300DrilldownKeyInlinePickList(myExample4300DrilldownKey, MyExample4300InlinePickListService.class),
		myExample4300DrilldownKeyMultivalueForm(myExample4300DrilldownKey, MyExample4300MultivalueService.class),

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

