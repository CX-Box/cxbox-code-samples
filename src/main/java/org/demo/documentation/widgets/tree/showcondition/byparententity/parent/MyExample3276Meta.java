package org.demo.documentation.widgets.tree.showcondition.byparententity.parent;

import lombok.AllArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyExample3276Meta extends FieldMetaBuilder<MyExample3276DTO> {
	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3276DTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(MyExample3276DTO_.parentTreeId);
		fields.setEnabled(MyExample3276DTO_.customFieldMoney);
		fields.setEnabled(MyExample3276DTO_.parentId);
		fields.setEnabled(MyExample3276DTO_.isLeaf);
		fields.setEnabled(MyExample3276DTO_.customFieldNumber);
		fields.setEnabled(MyExample3276DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3276DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3276DTO_.customFieldMoney);
		fields.enableFilter(MyExample3276DTO_.customFieldNumber);
		fields.enableFilter(MyExample3276DTO_.customField);

	}
	// --8<-- [end:buildIndependentMeta]
}