package org.demo.documentation.other.savewithparent.example5;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.savewithparent.example5.service.MyExample5555ApplicationService;
import org.demo.documentation.other.savewithparent.example5.service.MyExample5555ExecutorService;
import org.demo.documentation.other.savewithparent.example5.service.MyExample5555TaskService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5555Controller implements EnumBcIdentifier {
// @formatter:on

	application(MyExample5555ApplicationService.class),
	task(MyExample5555TaskService.class),
	executor(MyExample5555ExecutorService.class),
	executorPickListPopup(executor, MyExample5555ExecutorService.class);
	// --8<-- [end:bc]
	// @formatter:on


	public static final EnumBcIdentifier.Holder<CxboxMyExample5555Controller> Holder = new Holder<>(
			CxboxMyExample5555Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5555Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5555Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5555Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5555Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5555Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5555Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5555Controller> {

		public BcSupplier() {
			super(CxboxMyExample5555Controller.Holder);
		}

	}
}
