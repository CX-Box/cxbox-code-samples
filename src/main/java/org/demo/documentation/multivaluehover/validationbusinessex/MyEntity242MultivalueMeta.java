package org.demo.documentation.multivaluehover.validationbusinessex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@RequiredArgsConstructor
@Service
public class MyEntity242MultivalueMeta extends FieldMetaBuilder<MyEntity242MultivalueDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity242MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.multivaluehover.validationbusinessex.MyEntity242MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.multivaluehover.validationbusinessex.MyEntity242MultivalueDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity242MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
