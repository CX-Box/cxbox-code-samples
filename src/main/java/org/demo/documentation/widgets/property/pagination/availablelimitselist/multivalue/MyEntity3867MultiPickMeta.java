package org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3867MultiPickMeta extends FieldMetaBuilder<MyEntity3867MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3867MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3867MultiPickDTO_.id);
		fields.setEnabled(MyEntity3867MultiPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3867MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
