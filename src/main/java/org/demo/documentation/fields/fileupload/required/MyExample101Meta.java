package org.demo.documentation.fields.fileupload.required;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyExample101Meta extends FieldMetaBuilder<MyExample101DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample101DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample101DTO_.customFieldId);
		fields.setEnabled(MyExample101DTO_.customField);
		fields.setRequired(MyExample101DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample101DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample101DTO_.customField);
		}
		fields.enableFilter(MyExample101DTO_.customField);
		fields.setFileAccept(MyExample101DTO_.customField, List.of(".png", ".pdf", ".jpg", ".jpeg", ".mp3", ".wav", ".m4a", ".txt"));
	}
	// --8<-- [end:buildIndependentMeta]
}