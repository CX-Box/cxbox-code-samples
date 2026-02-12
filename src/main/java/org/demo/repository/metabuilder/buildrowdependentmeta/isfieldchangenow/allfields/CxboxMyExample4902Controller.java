package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4902Controller implements EnumBcIdentifier {

	// @formatter:on
	myexamplefa4902(MyExample4902Service.class),
	myEntity4902SuggectionPick(myexamplefa4902, MyEntity4902SuggectionPickService.class), myEntity4902MultiPick0(myexamplefa4902, MyEntity4902MultiPick0Service.class),
	myEntity4902PickPick2(myexamplefa4902, MyEntity4902PickPickService.class),
	myEntity4902PickInlinePick2(myexamplefa4902, MyEntity4902PickInlinePickService.class),
	myexample4902(MyExample4902Service.class),
	myEntity4902PickPick(myexample4902, MyEntity4902PickPickService.class),
	myEntity4902PickInlinePick(myexample4902, MyEntity4902PickInlinePickService.class),
	myEntity4902MultiPick(myexample4902, MyEntity4902MultiPickService.class),
	myEntity4902MultiHoverPick(myexample4902, MyEntity4902MultiHoverPickService.class);

	// @formatter:on

	public static final Holder<CxboxMyExample4902Controller> Holder = new Holder<>(
			CxboxMyExample4902Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample4902Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample4902Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample4902Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample4902Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample4902Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample4902Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4902Controller> {

		public BcSupplier() {
			super(CxboxMyExample4902Controller.Holder);
		}

	}

}