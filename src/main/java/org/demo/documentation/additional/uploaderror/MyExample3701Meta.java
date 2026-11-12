package org.demo.documentation.additional.uploaderror;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3701Meta extends FieldMetaBuilder<MyExample3701DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3701DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3701DTO_.customFieldFileId);
		fields.setEnabled(MyExample3701DTO_.customFieldFile);
		fields.setEnabled(MyExample3701DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3701DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3701DTO_.customFieldFile);
	}

}