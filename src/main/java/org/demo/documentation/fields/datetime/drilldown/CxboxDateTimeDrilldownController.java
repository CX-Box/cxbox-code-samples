package org.demo.documentation.fields.datetime.drilldown;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum CxboxDateTimeDrilldownController implements EnumBcIdentifier {



	dateTimeDrilldown(DateTimeDrilldownService.class);
	// --8<-- [end:bc]

	

	public static final EnumBcIdentifier.Holder<CxboxDateTimeDrilldownController> Holder = new Holder<>(
			CxboxDateTimeDrilldownController.class);

	private final BcDescription bcDescription;

	CxboxDateTimeDrilldownController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxDateTimeDrilldownController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxDateTimeDrilldownController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxDateTimeDrilldownController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxDateTimeDrilldownController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxDateTimeDrilldownController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxDateTimeDrilldownController> {

		public BcSupplier() {
			super(CxboxDateTimeDrilldownController.Holder);
		}

	}

}