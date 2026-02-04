package org.demo.documentation.test;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class EditLegalEntityMetaBuilder extends FieldMetaBuilder<EditLegalEntityDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<EditLegalEntityDTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(EditLegalEntityDTO_.sdsad);
		fields.setEnabled(
				EditLegalEntityDTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<EditLegalEntityDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(EditLegalEntityDTO_.sdsad);
		fields.enableFilter(
				EditLegalEntityDTO_.id
		);
		fields.enableSort(
				EditLegalEntityDTO_.id
		);
	}

}
