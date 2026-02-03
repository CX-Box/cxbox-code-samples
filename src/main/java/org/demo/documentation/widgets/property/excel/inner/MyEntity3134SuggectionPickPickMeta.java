package org.demo.documentation.widgets.property.excel.inner;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3134SuggectionPickPickMeta extends FieldMetaBuilder<MyEntity3134SuggectionPickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3134SuggectionPickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.property.excel.inner.MyEntity3134SuggectionPickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.property.excel.inner.MyEntity3134SuggectionPickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3134SuggectionPickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
