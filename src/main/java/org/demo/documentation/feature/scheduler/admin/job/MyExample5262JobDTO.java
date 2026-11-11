package org.demo.documentation.feature.scheduler.admin.job;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@SuperBuilder(toBuilder = true)
public class MyExample5262JobDTO extends DataResponseDTO {

	private String jobName;

	private String state;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private String recurringJobId;

	private String jobSignature;

}
