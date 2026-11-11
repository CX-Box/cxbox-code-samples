package org.demo.documentation.feature.scheduler.admin.job;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5262JobMeta extends AnySourceFieldMetaBuilder<MyExample5262JobDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5262JobDTO> fields, BcDescription bc,
			String id, String parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5262JobDTO> fields, BcDescription bcDescription,
			String parentId) {
	}

}
