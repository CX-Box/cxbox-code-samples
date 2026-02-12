package org.demo.documentation.other.equalsOfOne;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyExample3250MultivalueMeta extends FieldMetaBuilder<MyExample3250MultivalueDTO> {

	@Override
	public void buildRowDependentMeta(final RowDependentFieldsMeta<MyExample3250MultivalueDTO> fields, final InnerBcDescription bcDescription,
									  final Long id,
									  final Long parentId) {

	}

	@Override
	public void buildIndependentMeta(final FieldsMeta<MyExample3250MultivalueDTO> fields, final InnerBcDescription bcDescription, final Long parentId) {

	}

}
