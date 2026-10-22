package org.demo.documentation.widgets.cardcarousellist.status;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.cardcarousellist.status.enums.StatusEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample5065Meta extends FieldMetaBuilder<MyExample5065DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5065DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5065DTO_.document,
				MyExample5065DTO_.documentId,
				MyExample5065DTO_.customField,
				MyExample5065DTO_.customFieldDescription, MyExample5065DTO_.status
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5065DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5065DTO_.customField);
		fields.setEnumValues(MyExample5065DTO_.status, StatusEnum.values());
		fields.enableFilter(MyExample5065DTO_.status);
	}

}
