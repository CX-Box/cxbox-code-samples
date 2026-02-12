package org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3405PickListPopupPickMeta extends FieldMetaBuilder<MyEntity3405PickListPopupPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3405PickListPopupPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customFieldPlaceholder);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customFieldColor);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customFieldColorConst);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customFieldDrilldown);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customFieldColorValidation);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customFieldRequired);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customFieldColorSort);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.id);
		fields.setEnabled(MyEntity3405PickListPopupPickDTO_.customField);
		fields.setPlaceholder(MyEntity3405PickListPopupPickDTO_.customFieldPlaceholder, "Placeholder text");
		fields.setRequired(MyEntity3405PickListPopupPickDTO_.customFieldRequired);
		fields.setDrilldown(MyEntity3405PickListPopupPickDTO_.customFieldDrilldown, DrillDownType.INNER,
				"/screen/myexample3610");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3405PickListPopupPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3405PickListPopupPickDTO_.customFieldPlaceholder);
		fields.enableFilter(MyEntity3405PickListPopupPickDTO_.customFieldColor);
		fields.enableFilter(MyEntity3405PickListPopupPickDTO_.customFieldColorConst);
		fields.enableFilter(MyEntity3405PickListPopupPickDTO_.customFieldDrilldown);
		fields.enableFilter(MyEntity3405PickListPopupPickDTO_.customFieldColorValidation);
		fields.enableFilter(MyEntity3405PickListPopupPickDTO_.customFieldRequired);
		fields.enableFilter(MyEntity3405PickListPopupPickDTO_.customFieldColorSort);

	}

}
