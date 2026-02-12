package org.demo.documentation.fields.multivaluehover.placeholder;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntityMulti235PickMeta extends FieldMetaBuilder<MyEntityMulti235PickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntityMulti235PickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluehover.placeholder.MyEntityMulti235PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivaluehover.placeholder.MyEntityMulti235PickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntityMulti235PickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
