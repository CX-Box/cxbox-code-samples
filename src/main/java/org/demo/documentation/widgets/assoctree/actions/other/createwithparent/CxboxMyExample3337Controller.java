package org.demo.documentation.widgets.assoctree.actions.other.createwithparent;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assoc.MyEntity3339MultivalueService;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assocreq.MyEntity3340MultivalueService;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent.MyExample3338Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3337Controller implements EnumBcIdentifier {


	myexample3338(MyExample3338Service.class),
	myexample3337(myexample3338, MyExample3337Service.class),
	myEntity3340AssocTreePopup(myexample3337, MyEntity3340MultivalueService.class),
	myEntity3339AssocTreePopup(myexample3337, MyEntity3339MultivalueService.class);


	public static final EnumBcIdentifier.Holder<CxboxMyExample3337Controller> Holder = new Holder<>(
			CxboxMyExample3337Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3337Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3337Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3337Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3337Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3337Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3337Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3337Controller> {

		public BcSupplier() {
			super(CxboxMyExample3337Controller.Holder);
		}

	}

}