package org.demo.documentation.widgets.picktree.actions.delete;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3354Meta extends FieldMetaBuilder<MyExample3354DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3354DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3354DTO_.customFieldDeleteId);
		fields.setEnabled(MyExample3354DTO_.customFieldDelete);
		fields.setEnabled(MyExample3354DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3354DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3354DTO_.customFieldDelete);
	}

}