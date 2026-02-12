package org.demo.documentation.widgets.picklist.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3089PickPickMeta extends FieldMetaBuilder<MyEntity3089PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3089PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.picklist.customizationcolumns.MyEntity3089PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.picklist.customizationcolumns.MyEntity3089PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3089PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
