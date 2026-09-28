package org.demo.documentation.widgets.assoctree.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3335AssocPickMeta extends FieldMetaBuilder<MyEntity3335AssocPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3335AssocPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3335AssocPickDTO_.customFieldNumber);
		fields.setEnabled(MyEntity3335AssocPickDTO_.customFieldText);
		fields.setEnabled(org.demo.documentation.widgets.assoctree.customizationcolumns.MyEntity3335AssocPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3335AssocPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3335AssocPickDTO_.parentId);
		fields.enableFilter(MyEntity3335AssocPickDTO_.customFieldNumber);
		fields.enableFilter(MyEntity3335AssocPickDTO_.customFieldText);

	}

}
