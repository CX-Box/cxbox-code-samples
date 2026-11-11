package org.demo.documentation.feature.scheduler.task;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5262DTO extends DataResponseDTO {

	private String customField;

	private String status;

	private LocalDateTime scheduledDate;

	private LocalDateTime executedDate;

	public MyExample5262DTO(MyEntity5262 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.status = entity.getStatus().getValue();
		this.scheduledDate = entity.getScheduledDate();
		this.executedDate = entity.getExecutedDate();
	}

}
