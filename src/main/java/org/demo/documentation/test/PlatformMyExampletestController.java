package org.demo.documentation.test;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum PlatformMyExampletestController implements EnumBcIdentifier {

	// @formatter:off

	editLegalEntity(EditLegalEntityService.class),
		editManagingAuthority(editLegalEntity, EditManagingAuthorityService.class)
  ;
	// @formatter:on

	public static final Holder<PlatformMyExampletestController> Holder = new Holder<>(PlatformMyExampletestController.class);

	private final BcDescription bcDescription;

	PlatformMyExampletestController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	PlatformMyExampletestController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	PlatformMyExampletestController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	PlatformMyExampletestController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	PlatformMyExampletestController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	PlatformMyExampletestController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExampletestController> {

		public BcSupplier() {
			super(PlatformMyExampletestController.Holder);
		}

	}
}
