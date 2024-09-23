package org.demo.documentation.other.savewithparent.example5.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.demo.documentation.other.savewithparent.example5.entity.Task;
import org.demo.documentation.other.savewithparent.example5.enums.ImportanceEnum;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO extends DataResponseDTO {

	@SearchParameter(name = "applicationEntityId.name", provider = LongValueProvider.class)
	private String applicationEntity;

	@SearchParameter
	private String name;

	@SearchParameter
	private ImportanceEnum importance;

	@SearchParameter
	private StatusEnum status;

	@SearchParameter
	private String file;

	@SearchParameter
	private String fileId;

	@SearchParameter
	private String comment;

	@SearchParameter(name = "executorId.id")
	private String executorId;

	@SearchParameter
	private LocalDateTime createdDate;

	@SearchParameter(name = "executorId.name")
	private String executorName;

	public TaskDTO(Task task) {
		this.id = task.getId().toString();
		this.executorName = task.getExecutorId() == null ? null : task.getExecutorId().getName();
		this.createdDate = task.getCreatedDate();
		this.name = task.getName();
		this.importance = task.getImportance();
		this.status = task.getStatus();
		this.file = task.getFile();
		this.comment = task.getComment();
		this.executorId = task.getExecutorId() == null ? null : task.getExecutorId().getId().toString();
		this.applicationEntity = task.getApplicationEntityId().getName();
		this.fileId = task.getFileId();
	}
}
