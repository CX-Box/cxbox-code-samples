package org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3865PickPick0Meta extends FieldMetaBuilder<MyEntity3865PickPick0DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3865PickPick0DTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(MyEntity3865PickPick0DTO_.id);
		fields.setEnabled(MyEntity3865PickPick0DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3865PickPick0DTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {

	}

}
