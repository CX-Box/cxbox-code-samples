package org.demo.documentation.fields.multivaluehover.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity339PickMeta extends FieldMetaBuilder<MyEntity339PickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity339PickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivaluehover.validationdynamic.MyEntity339PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivaluehover.validationdynamic.MyEntity339PickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity339PickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
