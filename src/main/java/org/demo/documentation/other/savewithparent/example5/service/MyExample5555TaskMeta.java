package org.demo.documentation.other.savewithparent.example5.service;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO_;
import org.demo.documentation.other.savewithparent.example5.enums.ImportanceEnum;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample5555TaskMeta extends FieldMetaBuilder<TaskDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<TaskDTO> fields, InnerBcDescription bcDescription, Long id,
									  Long parentId) {
		fields.setEnabled(
				TaskDTO_.name,
				TaskDTO_.status,
				TaskDTO_.applicationEntityId,
				TaskDTO_.importance,
				TaskDTO_.executorId,
				TaskDTO_.executorName,
				TaskDTO_.file,
				TaskDTO_.comment
		);
		fields.setRequired(
				TaskDTO_.name,
				TaskDTO_.status
		);
		fields.setEnumValues(TaskDTO_.status, StatusEnum.values());
		fields.setEnumValues(TaskDTO_.importance, ImportanceEnum.values());
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<TaskDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableSort(TaskDTO_.name);
		fields.enableFilter(TaskDTO_.name);
		fields.enableSort(TaskDTO_.id);
		fields.enableFilter(TaskDTO_.id);
		fields.enableSort(TaskDTO_.status);
		fields.enableFilter(TaskDTO_.status);
		fields.setForceActive(
				TaskDTO_.name,
				TaskDTO_.id,
				TaskDTO_.status
		);
		fields.setEnumFilterValues(fields, TaskDTO_.status, StatusEnum.values());
	}

}
