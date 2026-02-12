package org.demo.documentation.widgets.calendarlist.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc5038MetaBuilder extends FieldMetaBuilder<MyExampleBc5038DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc5038DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MyExampleBc5038DTO_.endDateTime);
		fields.setEnabled(MyExampleBc5038DTO_.startDateTime);
		fields.setEnabled(MyExampleBc5038DTO_.customField);
		fields.setEnabled(
				MyExampleBc5038DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc5038DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExampleBc5038DTO_.endDateTime);
		fields.enableFilter(MyExampleBc5038DTO_.startDateTime);
		fields.enableFilter(MyExampleBc5038DTO_.customField);
		fields.enableFilter(
				MyExampleBc5038DTO_.id
		);
		fields.enableSort(
				MyExampleBc5038DTO_.id
		);
	}

}
