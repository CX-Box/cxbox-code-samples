package org.demo.documentation.widgets.funnel.base.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc5042MetaBuilder extends FieldMetaBuilder<MyExampleBc5042DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc5042DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MyExampleBc5042DTO_.customFieldNum);
		fields.setEnabled(
				org.demo.documentation.widgets.funnel.base.data.MyExampleBc5042DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc5042DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExampleBc5042DTO_.customFieldNum);
		fields.enableFilter(
				org.demo.documentation.widgets.funnel.base.data.MyExampleBc5042DTO_.id
		);
		fields.enableSort(
				org.demo.documentation.widgets.funnel.base.data.MyExampleBc5042DTO_.id
		);
	}

}
