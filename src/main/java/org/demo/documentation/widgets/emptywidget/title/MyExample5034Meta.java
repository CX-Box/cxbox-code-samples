package org.demo.documentation.widgets.emptywidget.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5034Meta extends FieldMetaBuilder<MyExample5034DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5034DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5034DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5034DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}