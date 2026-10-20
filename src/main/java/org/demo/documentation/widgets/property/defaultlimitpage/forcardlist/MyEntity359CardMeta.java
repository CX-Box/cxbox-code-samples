package org.demo.documentation.widgets.property.defaultlimitpage.forcardlist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyEntity359CardMeta extends FieldMetaBuilder<MyEntity359CardDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity359CardDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyEntity359CardDTO_.document,
				MyEntity359CardDTO_.documentId,
				MyEntity359CardDTO_.customField,
				MyEntity359CardDTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity359CardDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
