package org.demo.controller;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.conf.cxbox.customization.dictionary.service.DictionaryAdminService;
import org.demo.conf.cxbox.customization.dictionary.service.DictionaryTypeAdminService;
import org.demo.conf.cxbox.customization.responsibilities.service.ResponsibilitiesAdminService;
import org.demo.conf.cxbox.customization.responsibilitiesAction.service.ActionSuggestionAdminService;
import org.demo.conf.cxbox.customization.responsibilitiesAction.service.ResponsibilitiesActionAdminService;
import org.springframework.stereotype.Component;

/**
 * This is actually an analog of a usual @RestController.
 * When you add enum, you just add rest endpoints, that cxbox UI can call.
 * We could actually make a usual @RestController and make it Generic,
 * but current enum approach shows, that it is less error-prone in huge enterprise projects
 * (because single line in this enum creates >5 rest endpoints)
 */
@SuppressWarnings({"java:S115", "java:S1144"})
@Getter
public enum CxboxRestController implements EnumBcIdentifier {

	// @formatter:off

	//core administration
	dictionary(DictionaryAdminService.class),
		dictionaryType(dictionary, DictionaryTypeAdminService.class),
	responsibilities(ResponsibilitiesAdminService.class),
	responsibilitiesAction(ResponsibilitiesActionAdminService.class),
		responsibilitiesActionSuggestion(responsibilitiesAction, ActionSuggestionAdminService.class);


	

	public static final EnumBcIdentifier.Holder<CxboxRestController> Holder = new Holder<>(CxboxRestController.class);

	private final BcDescription bcDescription;

	CxboxRestController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxRestController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxRestController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxRestController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxRestController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxRestController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxRestController> {

		public BcSupplier() {
			super(CxboxRestController.Holder);
		}

	}

}
