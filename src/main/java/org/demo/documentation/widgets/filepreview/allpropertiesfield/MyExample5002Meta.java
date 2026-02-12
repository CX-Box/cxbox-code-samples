package org.demo.documentation.widgets.filepreview.allpropertiesfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5002Meta extends FieldMetaBuilder<MyExample5002DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5002DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5002DTO_.customFieldId);
		fields.setEnabled(MyExample5002DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5002DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5002DTO_.customFieldId);
	}

}