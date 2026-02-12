package org.demo.documentation.widgets.property.defaultlimitpage.forassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity359AssocPickMeta extends FieldMetaBuilder<MyEntity359AssocPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity359AssocPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity359AssocPickDTO_.id);
		fields.setEnabled(MyEntity359AssocPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity359AssocPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
