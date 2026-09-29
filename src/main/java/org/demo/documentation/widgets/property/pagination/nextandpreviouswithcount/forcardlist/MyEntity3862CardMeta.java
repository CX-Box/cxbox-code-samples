package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forcardlist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3862CardMeta extends FieldMetaBuilder<MyEntity3862CardDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3862CardDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyEntity3862CardDTO_.document,
				MyEntity3862CardDTO_.documentId,
				MyEntity3862CardDTO_.customField,
				MyEntity3862CardDTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3862CardDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
