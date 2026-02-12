package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3862PickPickMeta extends FieldMetaBuilder<MyEntity3862PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3862PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3862PickPickDTO_.id);
		fields.setEnabled(MyEntity3862PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3862PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
