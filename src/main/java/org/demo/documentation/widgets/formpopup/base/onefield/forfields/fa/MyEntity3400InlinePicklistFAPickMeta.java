package org.demo.documentation.widgets.formpopup.base.onefield.forfields.fa;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3400InlinePicklistFAPickMeta extends FieldMetaBuilder<MyEntity3400InlinePicklistFAPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3400InlinePicklistFAPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3400InlinePicklistFAPickDTO_.id);
		fields.setEnabled(MyEntity3400InlinePicklistFAPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3400InlinePicklistFAPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
