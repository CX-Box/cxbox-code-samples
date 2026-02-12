package org.demo.documentation.widgets.emptywidget.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5022Meta extends FieldMetaBuilder<MyExample5022DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5022DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5022DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5022DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}