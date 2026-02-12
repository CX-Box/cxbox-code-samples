package org.demo.documentation.other.widgetEditStyles.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesInlinePicklistPickService;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMultiMultiMultivalueService;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMultiMultivalueService;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesPicklistPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxWidgetStylesController implements EnumBcIdentifier {


	widgetStyles(WidgetStylesService.class),
	widgetStylesPicklistPickListPopup(widgetStyles, WidgetStylesPicklistPickService.class),
	widgetStylesInlinePicklistPickListPopup(widgetStyles, WidgetStylesInlinePicklistPickService.class),
	widgetStylesMultiMultiAssocListPopup(widgetStyles, WidgetStylesMultiMultiMultivalueService.class),
	widgetStylesMultiAssocListPopup(widgetStyles, WidgetStylesMultiMultivalueService.class),
	widgetStylesNone(widgetStyles, WidgetStylesService.class),
	widgetStylesInlinePicklistNonePickListPopup(widgetStylesNone, WidgetStylesInlinePicklistPickService.class),
	widgetStylesPicklistPickListPopupNone(widgetStylesNone, WidgetStylesPicklistPickService.class);

	public static final EnumBcIdentifier.Holder<CxboxWidgetStylesController> Holder = new Holder<>(
			CxboxWidgetStylesController.class);

	private final BcDescription bcDescription;

	CxboxWidgetStylesController(String parentName, Class<?> serviceClass, boolean refresh) {
		this.bcDescription = buildDescription(parentName, serviceClass, refresh);
	}

	CxboxWidgetStylesController(String parentName, Class<?> serviceClass) {
		this(parentName, serviceClass, false);
	}

	CxboxWidgetStylesController(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
		this(parent == null ? null : parent.getName(), serviceClass, refresh);
	}

	CxboxWidgetStylesController(BcIdentifier parent, Class<?> serviceClass) {
		this(parent, serviceClass, false);
	}

	CxboxWidgetStylesController(Class<?> serviceClass, boolean refresh) {
		this((String) null, serviceClass, refresh);
	}

	CxboxWidgetStylesController(Class<?> serviceClass) {
		this((String) null, serviceClass, false);
	}

	@Component
	public static class BcSupplier extends AbstractEnumBcSupplier<CxboxWidgetStylesController> {

		public BcSupplier() {
			super(CxboxWidgetStylesController.Holder);
		}

	}

}