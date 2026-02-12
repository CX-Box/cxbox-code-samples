package org.demo.documentation.widgets.picklist.actions.delete;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3188Meta extends FieldMetaBuilder<MyExample3188DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3188DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3188DTO_.customFieldDeleteId);
		fields.setEnabled(MyExample3188DTO_.customFieldDelete);
		fields.setEnabled(MyExample3188DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3188DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3188DTO_.customFieldDelete);
	}

}