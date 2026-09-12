package org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3357PickTreePopupPickMeta extends FieldMetaBuilder<MyEntity3357PickTreePopupPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3357PickTreePopupPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customFieldPlaceholder);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customFieldColor);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customFieldColorConst);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customFieldDrilldown);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customFieldColorValidation);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customFieldRequired);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customFieldColorSort);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.id);
		fields.setEnabled(MyEntity3357PickTreePopupPickDTO_.customField);
		fields.setPlaceholder(MyEntity3357PickTreePopupPickDTO_.customFieldPlaceholder, "Placeholder text");
		fields.setRequired(MyEntity3357PickTreePopupPickDTO_.customFieldRequired);
		fields.setDrilldown(MyEntity3357PickTreePopupPickDTO_.customFieldDrilldown, DrillDownType.INNER,
				"/screen/myexample3610");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3357PickTreePopupPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.parentId);
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.customFieldPlaceholder);
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.customFieldColor);
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.customFieldColorConst);
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.customFieldDrilldown);
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.customFieldColorValidation);
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.customFieldRequired);
		fields.enableFilter(MyEntity3357PickTreePopupPickDTO_.customFieldColorSort);

	}

}
