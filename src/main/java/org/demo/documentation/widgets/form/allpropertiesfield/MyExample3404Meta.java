package org.demo.documentation.widgets.form.allpropertiesfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3404Meta extends FieldMetaBuilder<MyExample3404DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3404DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3404DTO_.customFieldRequired);
		fields.setEnabled(MyExample3404DTO_.customFieldColorSort);
		fields.setEnabled(MyExample3404DTO_.customFieldColorValidation);
		fields.setEnabled(MyExample3404DTO_.customFieldColorDrilldown);
		fields.setEnabled(MyExample3404DTO_.customFieldColorConst);
		fields.setEnabled(MyExample3404DTO_.customFieldColor);
		fields.setEnabled(MyExample3404DTO_.customFieldPlaceholder);
		fields.setEnabled(MyExample3404DTO_.customField);
		fields.setPlaceholder(MyExample3404DTO_.customFieldPlaceholder, "Placeholder text");
		fields.setRequired(MyExample3404DTO_.customFieldRequired);
		fields.setDrilldown(MyExample3404DTO_.customFieldColorDrilldown, DrillDownType.INNER,
				"/screen/myexample3610");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3404DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3404DTO_.customFieldRequired);
		fields.enableFilter(MyExample3404DTO_.customFieldColorSort);
		fields.enableFilter(MyExample3404DTO_.customFieldColorValidation);
		fields.enableFilter(MyExample3404DTO_.customFieldColorDrilldown);
		fields.enableFilter(MyExample3404DTO_.customFieldColorConst);
		fields.enableFilter(MyExample3404DTO_.customFieldColor);
		fields.enableFilter(MyExample3404DTO_.customFieldPlaceholder);
		fields.enableSort(MyExample3404DTO_.customFieldColorSort);
	}

}