package org.demo.documentation.dateytimewithseconds.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample322Meta extends FieldMetaBuilder<MyExample322DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample322DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample322DTO_.customFieldAdditional);
		fields.setEnabled(MyExample322DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample322DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample322DTO_.customFieldAdditional);
		fields.enableFilter(MyExample322DTO_.customField);
	}

}