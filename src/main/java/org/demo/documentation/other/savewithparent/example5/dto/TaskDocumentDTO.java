package org.demo.documentation.other.savewithparent.example5.dto;

import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.other.savewithparent.example5.entity.TaskDocument;
import org.demo.documentation.other.savewithparent.example5.entity.Task;

@Getter
@Setter
@NoArgsConstructor
public class TaskDocumentDTO extends DataResponseDTO {

	private String fileId;

	@SearchParameter(name = "file")
	private String file;

	@SearchParameter(name = "task.id", provider = LongValueProvider.class)
	private Long taskId;

	private String type;

	public TaskDocumentDTO(TaskDocument document) {
		this.id = String.valueOf(document.getId());
		this.fileId = document.getFileId();
		this.taskId = Optional.ofNullable(document.getTask()).map(Task::getId).orElse(null);
		this.file = document.getFile();
	}

}
