package org.demo.documentation.feature.scheduler.task;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5262Meta extends FieldMetaBuilder<MyExample5262DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5262DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5262DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5262DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
