package org.demo.documentation.widgets.relationGraph.drilldown;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample6158CompanyMeta extends FieldMetaBuilder<MyExample6158CompanyDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6158CompanyDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6158CompanyDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}
}
