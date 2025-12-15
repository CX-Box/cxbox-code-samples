package org.demo.documentation.other.postAction;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum MyExample6500PostActionExportToExcelList implements EnumBcIdentifier {

    myexample6500PostActionExportToExcelList(MyExample6500PostActionExportToExcelListService.class)
	;

	public static final Holder<MyExample6500PostActionExportToExcelList> Holder = new Holder<>(
            MyExample6500PostActionExportToExcelList.class);

	private final BcDescription bcDescription;

	MyExample6500PostActionExportToExcelList(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	MyExample6500PostActionExportToExcelList(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	MyExample6500PostActionExportToExcelList(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	MyExample6500PostActionExportToExcelList(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	MyExample6500PostActionExportToExcelList(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	MyExample6500PostActionExportToExcelList(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<MyExample6500PostActionExportToExcelList> {

		public BcSupplier() {
			super(MyExample6500PostActionExportToExcelList.Holder);
		}

	}

}