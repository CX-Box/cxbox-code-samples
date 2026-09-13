package org.demo.documentation.widgets.assoctree.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3336Meta extends FieldMetaBuilder<MyExample3336DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3336DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3336DTO_.customFieldMultivalue);
		fields.setEnabled(MyExample3336DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3336DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3336DTO_.customFieldMultivalue);
	}

}