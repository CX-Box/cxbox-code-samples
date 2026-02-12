package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity5028PickPickMeta extends FieldMetaBuilder<MyEntity5028PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity5028PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.headerwidget.colortitle.allfields.MyEntity5028PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.headerwidget.colortitle.allfields.MyEntity5028PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity5028PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
