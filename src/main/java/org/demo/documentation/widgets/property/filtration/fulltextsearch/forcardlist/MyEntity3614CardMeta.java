package org.demo.documentation.widgets.property.filtration.fulltextsearch.forcardlist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3614CardMeta extends FieldMetaBuilder<MyEntity3614CardDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3614CardDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyEntity3614CardDTO_.document,
				MyEntity3614CardDTO_.documentId,
				MyEntity3614CardDTO_.customField,
				MyEntity3614CardDTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3614CardDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
