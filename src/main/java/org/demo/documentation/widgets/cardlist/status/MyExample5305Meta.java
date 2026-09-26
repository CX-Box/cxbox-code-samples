package org.demo.documentation.widgets.cardlist.status;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.cardlist.status.enums.StatusEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample5305Meta extends FieldMetaBuilder<MyExample5305DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5305DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5305DTO_.document,
				MyExample5305DTO_.documentId,
				MyExample5305DTO_.customField,
				MyExample5305DTO_.customFieldDescription, MyExample5305DTO_.status
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5305DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5305DTO_.customField);
		fields.setEnumValues(MyExample5305DTO_.status, StatusEnum.values());
		fields.enableFilter(MyExample5305DTO_.status);
	}

}
