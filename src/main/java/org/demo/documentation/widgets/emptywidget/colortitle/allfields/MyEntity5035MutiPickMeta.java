package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity5035MutiPickMeta extends FieldMetaBuilder<MyEntity5035MutiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity5035MutiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.emptywidget.colortitle.allfields.MyEntity5035MutiPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.emptywidget.colortitle.allfields.MyEntity5035MutiPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity5035MutiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
