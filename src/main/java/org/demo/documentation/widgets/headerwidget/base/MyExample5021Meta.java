package org.demo.documentation.widgets.headerwidget.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5021Meta extends FieldMetaBuilder<MyExample5021DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5021DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5021DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5021DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}