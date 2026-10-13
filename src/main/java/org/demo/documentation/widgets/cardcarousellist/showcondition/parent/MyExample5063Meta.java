package org.demo.documentation.widgets.cardcarousellist.showcondition.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5063Meta extends FieldMetaBuilder<MyExample5063DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5063DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5063DTO_.customFieldNumber);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5063DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
