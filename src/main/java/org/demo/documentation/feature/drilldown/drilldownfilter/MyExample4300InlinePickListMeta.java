package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

@Service
public class MyExample4300InlinePickListMeta extends FieldMetaBuilder<MyExample4300InlinePickListDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4300InlinePickListDTO> fields, InnerBcDescription bcDescription,
																		Long id, Long parentId) {
		fields.setEnabled(MyExample4300InlinePickListDTO_.value);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4300InlinePickListDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
