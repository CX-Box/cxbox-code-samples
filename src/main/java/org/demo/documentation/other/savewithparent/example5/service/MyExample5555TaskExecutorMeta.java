package org.demo.documentation.other.savewithparent.example5.service;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO;
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample5555TaskExecutorMeta extends FieldMetaBuilder<ExecutorDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<ExecutorDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(ExecutorDTO_.name);
		fields.setRequired(ExecutorDTO_.name);
		fields.setEnabled(ExecutorDTO_.role);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<ExecutorDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(ExecutorDTO_.name);
		fields.enableSort(ExecutorDTO_.name);
		fields.enableFilter(ExecutorDTO_.role);
		fields.enableSort(ExecutorDTO_.role);
		fields.setForceActive(
				ExecutorDTO_.role,
				ExecutorDTO_.name
		);
	}

}
