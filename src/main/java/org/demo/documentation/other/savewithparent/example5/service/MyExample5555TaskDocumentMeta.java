package org.demo.documentation.other.savewithparent.example5.service;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDocumentDTO;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDocumentDTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample5555TaskDocumentMeta extends FieldMetaBuilder<TaskDocumentDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<TaskDocumentDTO> fields,
									  InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(TaskDocumentDTO_.file);
		fields.setEnabled(TaskDocumentDTO_.fileId);
		fields.setEnabled(TaskDocumentDTO_.taskId);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<TaskDocumentDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(TaskDocumentDTO_.file);
	}

}
