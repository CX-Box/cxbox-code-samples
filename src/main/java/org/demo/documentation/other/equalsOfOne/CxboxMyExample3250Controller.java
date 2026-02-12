package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3250Controller implements EnumBcIdentifier {

	myexample3250OneToOne(MyExample3250Service.class),
	myexample3250OneToOneMultivalues(myexample3250OneToOne, MyExample3250MultivalueService.class),
	myexample3250OneToMany(MyExample3250Service.class),
	myexample3250OneToManyMultivalues(myexample3250OneToMany, MyExample3250MultivalueService.class),
	myexample3250ManyToMany(MyExample3250Service.class),
	myexample3250ManyToManyMultivalues(myexample3250ManyToMany, MyExample3250MultivalueService.class),
	;

	public static final Holder<CxboxMyExample3250Controller> Holder = new Holder<>(
			CxboxMyExample3250Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample3250Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample3250Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample3250Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample3250Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample3250Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample3250Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3250Controller> {

		public BcSupplier() {
			super(CxboxMyExample3250Controller.Holder);
		}

	}

}