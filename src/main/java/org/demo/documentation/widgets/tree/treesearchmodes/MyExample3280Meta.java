package org.demo.documentation.widgets.tree.treesearchmodes;

import lombok.AllArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig; 
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyExample3280Meta extends FieldMetaBuilder<MyExample3280DTO> {

	// --8<-- [start:buildRowDependentMeta]
	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3280DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setDisabled(MyExample3280DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3280DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3280DTO_.customField);
		fields.enableSort(MyExample3280DTO_.customField);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3280DTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]
}
