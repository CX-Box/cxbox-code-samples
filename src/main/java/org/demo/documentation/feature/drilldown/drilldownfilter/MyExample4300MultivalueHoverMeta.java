package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4300MultivalueHoverMeta extends FieldMetaBuilder<MyExample4300MultivalueHoverDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4300MultivalueHoverDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4300MultivalueHoverDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
