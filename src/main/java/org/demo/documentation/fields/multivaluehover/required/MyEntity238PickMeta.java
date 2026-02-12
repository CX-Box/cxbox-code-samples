package org.demo.documentation.fields.multivaluehover.required;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity238PickMeta extends FieldMetaBuilder<MyEntity238PickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity238PickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluehover.required.MyEntity238PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivaluehover.required.MyEntity238PickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity238PickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
