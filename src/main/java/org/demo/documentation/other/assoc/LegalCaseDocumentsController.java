package org.demo.documentation.other.assoc;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.assoc.LegalCaseDocumentsService;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum LegalCaseDocumentsController implements EnumBcIdentifier {

	// @formatter:off
	legalCaseDocuments(LegalCaseDocumentsService.class),
	myEntity3421Pick(legalCaseDocuments, MyEntity3421PickService.class);
	// @formatter:on

	public static final Holder<LegalCaseDocumentsController> Holder = new Holder<>(LegalCaseDocumentsController.class);

	private final BcDescription bcDescription;

	LegalCaseDocumentsController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	LegalCaseDocumentsController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	LegalCaseDocumentsController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	LegalCaseDocumentsController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	LegalCaseDocumentsController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	LegalCaseDocumentsController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<LegalCaseDocumentsController> {

		public BcSupplier() {
			super(LegalCaseDocumentsController.Holder);
		}

	}
}
