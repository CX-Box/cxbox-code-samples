package org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3126Meta extends FieldMetaBuilder<MyExample3126DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3126DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3126DTO_.netAnnualRate);
		fields.setEnabled(MyExample3126DTO_.insuranceAmount);
		fields.setEnabled(MyExample3126DTO_.insuranceValue);
		fields.setEnabled(MyExample3126DTO_.object);
		fields.setEnabled(MyExample3126DTO_.location);
		fields.setEnabled(MyExample3126DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3126DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3126DTO_.netAnnualRate);
		fields.enableFilter(MyExample3126DTO_.insuranceAmount);
		fields.enableFilter(MyExample3126DTO_.insuranceValue);
		fields.enableFilter(MyExample3126DTO_.object);
		fields.enableFilter(MyExample3126DTO_.location);
	}

}