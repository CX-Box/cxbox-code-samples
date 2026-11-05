package org.demo.documentation.fields.property.snapshotkey;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample5900PickMeta extends FieldMetaBuilder<MyExample5900PickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5900PickDTO> fields,
			InnerBcDescription bcDescription, Long id, Long parentId) {

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5900PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
