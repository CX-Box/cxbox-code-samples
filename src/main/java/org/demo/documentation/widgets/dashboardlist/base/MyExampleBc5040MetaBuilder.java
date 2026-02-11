package org.demo.documentation.widgets.dashboardlist.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc5040MetaBuilder extends FieldMetaBuilder<MyExampleBc5040DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc5040DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MyExampleBc5040DTO_.customField);
		fields.setEnabled(
				org.demo.documentation.widgets.dashboardlist.base.MyExampleBc5040DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc5040DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExampleBc5040DTO_.customField);
		fields.enableFilter(
				org.demo.documentation.widgets.dashboardlist.base.MyExampleBc5040DTO_.id
		);
		fields.enableSort(
				org.demo.documentation.widgets.dashboardlist.base.MyExampleBc5040DTO_.id
		);
	}

}
