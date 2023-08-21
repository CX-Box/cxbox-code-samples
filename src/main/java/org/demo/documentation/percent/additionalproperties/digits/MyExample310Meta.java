package org.demo.documentation.percent.additionalproperties.digits;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample310Meta extends FieldMetaBuilder<MyExample310DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample310DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample310DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample310DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample310DTO_.customField);
	}

}