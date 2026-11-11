package org.demo.documentation.feature.scheduler;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.feature.scheduler.admin.job.MyExample5262JobService;
import org.demo.documentation.feature.scheduler.admin.stats.MyExample5262JobStatsService;
import org.demo.documentation.feature.scheduler.task.MyExample5262Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5262Controller implements EnumBcIdentifier {

	// @formatter:off
	myexample5262(MyExample5262Service.class),
	// --8<-- [start:bc]
	myexample5262jobstats(MyExample5262JobStatsService.class),
		myexample5262job(myexample5262jobstats, MyExample5262JobService.class);
	// --8<-- [end:bc]
	// @formatter:on

	public static final EnumBcIdentifier.Holder<CxboxMyExample5262Controller> Holder = new Holder<>(
			CxboxMyExample5262Controller.class);

	private final BcDescription bcDescription;

	CxboxMyExample5262Controller(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxMyExample5262Controller(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxMyExample5262Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxMyExample5262Controller(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxMyExample5262Controller(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxMyExample5262Controller(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5262Controller> {

		public BcSupplier() {
			super(CxboxMyExample5262Controller.Holder);
		}

	}

}
