package org.demo.documentation.widgets.tree.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.tree.base.allType.*;
import org.demo.documentation.widgets.tree.base.any.Myexample3261AnyService;
import org.demo.documentation.widgets.tree.base.inner.Myexample3263Service;
import org.demo.documentation.widgets.tree.base.inner.Myexample3261Pick0Service;
import org.demo.documentation.widgets.tree.base.inner.Myexample3261PickService;
import org.demo.documentation.widgets.tree.data.departments.My3261UsersPickService;
import org.demo.documentation.widgets.tree.data.departments.MydepartmentsService;
import org.demo.documentation.widgets.tree.data.users.My3261UsersService;
import org.demo.documentation.widgets.tree.base.inner.Myexample3261Service;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum CxboxMyExample3263Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample3261(Myexample3261Service.class),
	myexample3263(Myexample3263Service.class),
		myexample3261Pick0(myexample3263, Myexample3261Pick0Service.class),
		myexample3263Assoc(myexample3263, Myexample3261Pick0Service.class),
		myexample3261Pick(myexample3263, Myexample3261PickService.class),
		myexample3261child(myexample3263,Myexample3261Service.class),
	myexample3261any(Myexample3261AnyService.class),
	mydepartments(MydepartmentsService.class),
		my3261UsersPick(mydepartments, My3261UsersPickService.class),
	my3261users(My3261UsersService.class),
	myexample3262(Myexample3262Service.class),myexample3262PickPick0(myexample3262, Myexample3262PickPick0Service.class),myexample3262PickPick(myexample3262, Myexample3262PickPickService.class),myexample3262MultiPick(myexample3262, Myexample3262MultiPickService.class),myexample3262MultiHoverPick(myexample3262, Myexample3262MultiHoverPickService.class);
	// @formatter:on

	public static final Holder<CxboxMyExample3263Controller> Holder = new Holder<>(CxboxMyExample3263Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3263Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3263Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3263Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}


	CxboxMyExample3263Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3263Controller> {

		public BcSupplier() {
			super(CxboxMyExample3263Controller.Holder);
		}

	}
}
