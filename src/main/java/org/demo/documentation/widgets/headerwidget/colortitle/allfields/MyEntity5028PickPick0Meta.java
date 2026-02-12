package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity5028PickPick0Meta extends FieldMetaBuilder<MyEntity5028PickPick0DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity5028PickPick0DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.headerwidget.colortitle.allfields.MyEntity5028PickPick0DTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.headerwidget.colortitle.allfields.MyEntity5028PickPick0DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity5028PickPick0DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
