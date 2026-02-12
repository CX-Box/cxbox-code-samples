package org.demo.documentation.other.drilldown.option3.any;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3435Meta extends AnySourceFieldMetaBuilder<MyExample3435DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3435DTO> fields, BcDescription bcDescription,
									  String id, String parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3435DTO> fields, BcDescription bcDescription, String parentId) {
	}

}
