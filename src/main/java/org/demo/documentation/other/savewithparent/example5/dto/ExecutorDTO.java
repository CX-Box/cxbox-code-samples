package org.demo.documentation.other.savewithparent.example5.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.savewithparent.example5.entity.Executor;

@Getter
@Setter
@NoArgsConstructor
public class ExecutorDTO extends DataResponseDTO {

	@SearchParameter
	private String name;

	@SearchParameter
	private String role;

	public ExecutorDTO(Executor executor) {
		this.id = executor.getId().toString();
		this.name = executor.getName();
		this.role = executor.getRole();
	}
}