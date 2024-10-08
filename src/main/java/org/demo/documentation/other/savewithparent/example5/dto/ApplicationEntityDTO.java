package org.demo.documentation.other.savewithparent.example5.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationEntityDTO extends DataResponseDTO {

	@SearchParameter
	private String name;

	@SearchParameter
	private StatusEnum status;

	@SearchParameter
	private LocalDateTime createdDate;

	public ApplicationEntityDTO(ApplicationEntity applicationEntity) {
		this.id = applicationEntity.getId().toString();
		this.name = applicationEntity.getName();
		this.status = applicationEntity.getStatus();
		this.createdDate = applicationEntity.getCreatedDate();
	}
}
