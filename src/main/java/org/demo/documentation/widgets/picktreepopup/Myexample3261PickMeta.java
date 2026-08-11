package org.demo.documentation.widgets.picktreepopup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class Myexample3261PickMeta extends FieldMetaBuilder<Myexample3261PickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3261PickDTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.picktreepopup.Myexample3261PickDTO_.id);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3261PickDTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {

	}

}
