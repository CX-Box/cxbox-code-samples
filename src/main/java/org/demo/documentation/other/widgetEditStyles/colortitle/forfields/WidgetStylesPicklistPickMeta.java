package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class WidgetStylesPicklistPickMeta extends FieldMetaBuilder<WidgetStylesPicklistPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<WidgetStylesPicklistPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(WidgetStylesPicklistPickDTO_.id);
		fields.setEnabled(WidgetStylesPicklistPickDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<WidgetStylesPicklistPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
