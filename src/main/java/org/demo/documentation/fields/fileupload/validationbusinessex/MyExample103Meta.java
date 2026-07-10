package org.demo.documentation.fields.fileupload.validationbusinessex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.demo.documentation.fields.main.TextError.LESS_SIZE;

@Service
@RequiredArgsConstructor
public class MyExample103Meta extends FieldMetaBuilder<MyExample103DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample103DTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(MyExample103DTO_.customFieldId);
		fields.setEnabled(MyExample103DTO_.customField);
		fields.setPlaceholder(MyExample103DTO_.customField, LESS_SIZE);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample103DTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {
		fields.enableFilter(MyExample103DTO_.customField);
		fields.setFileAccept(MyExample103DTO_.customField, List.of(".png", ".pdf", ".jpg", ".jpeg", ".mp3", ".wav", ".m4a", ".txt"));
	}
	// --8<-- [end:buildIndependentMeta]
}