package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4300SecondEntityMeta extends FieldMetaBuilder<MyExample4300SecondEntityDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4300SecondEntityDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		// not need implementation

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4300SecondEntityDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		// not need implementation
	}

}
